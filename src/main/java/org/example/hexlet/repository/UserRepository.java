package org.example.hexlet.repository;

import org.example.hexlet.model.User;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository extends BaseRepository {

    public static void save(User user) throws SQLException {
        String sql = "INSERT INTO users (name, email, password, created_at) VALUES (?, ?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();

            if (resultSet.next()) {
                user.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<User> find(Long id) throws SQLException {
        String sql = "SELECT * FROM users WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                User user = new User(name, email, password);
                user.setCreatedAt(createdAt);
                user.setId(id);

                return Optional.of(user);
            }

            return Optional.empty();
        }
    }

    public static List<User> getEntities() throws SQLException {
        String sql = "SELECT * FROM users";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                User user = new User(name, email, password);
                user.setCreatedAt(createdAt);
                user.setId(id);

                users.add(user);
            }

            return users;
        }
    }

    public static List<User> search(String term) throws SQLException {
        if (term == null) {
            return getEntities();
        }

        String sql = "SELECT * FROM courses WHERE name ILIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+term+"%");
            ResultSet resultSet = stmt.executeQuery();
            List<User> users = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String password = resultSet.getString("password");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                User user = new User(name, email, password);
                user.setCreatedAt(createdAt);
                user.setId(id);

                users.add(user);
            }

            return users;
        }
    }

    public static void update(User user) throws SQLException{
        String sql = "UPDATE users SET name = ?, email = ? WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setLong(3, user.getId());
            stmt.executeUpdate();
        }
    }
}
