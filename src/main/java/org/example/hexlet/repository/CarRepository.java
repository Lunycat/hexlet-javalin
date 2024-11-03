package org.example.hexlet.repository;

import org.example.hexlet.model.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CarRepository extends BaseRepository {

    public static void save(Car car) throws SQLException {
        String sql = "INSERT INTO cars (make, model) VALUES (?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, car.getMake());
            stmt.setString(2, car.getModel());
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();

            if (resultSet.next()) {
                car.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Car> find(Long id) throws SQLException {
        String sql = "SELECT * FROM cars WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");

                Car car = new Car(make, model);
                car.setId(id);

                return Optional.of(car);
            }

            return Optional.empty();
        }
    }

    public static List<Car> getEntities() throws SQLException {
        String sql = "SELECT * FROM cars";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");

                Car car = new Car(make, model);
                car.setId(id);

                cars.add(car);
            }

            return cars;
        }
    }

    public static List<Car> search(String term) throws SQLException {
        if (term == null) {
            return getEntities();
        }

        String sql = "SELECT * FROM cars WHERE make ILIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+term+"%");
            ResultSet resultSet = stmt.executeQuery();
            List<Car> cars = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");

                Car car = new Car(make, model);
                car.setId(id);

                cars.add(car);
            }

            return cars;
        }
    }
}
