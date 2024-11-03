package org.example.hexlet.repository;

import org.example.hexlet.model.Course;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository extends BaseRepository {

    public static void save(Course course) throws SQLException {
        String sql = "INSERT INTO courses (name, description, created_at) VALUES (?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, course.getName());
            stmt.setString(2, course.getDescription());
            stmt.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
            stmt.executeUpdate();
            ResultSet resultSet = stmt.getGeneratedKeys();

            if (resultSet.next()) {
                course.setId(resultSet.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }

    public static Optional<Course> find(Long id) throws SQLException {
        String sql = "SELECT * FROM courses WHERE id = ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setLong(1, id);
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                Course course = new Course(name, description);
                course.setCreatedAt(createdAt);
                course.setId(id);

                return Optional.of(course);
            }

            return Optional.empty();
        }
    }

    public static List<Course> getEntities() throws SQLException {
        String sql = "SELECT * FROM courses";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet resultSet = stmt.executeQuery();
            List<Course> courses = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                Course course = new Course(name, description);
                course.setCreatedAt(createdAt);
                course.setId(id);

                courses.add(course);
            }

            return courses;
        }
    }

    public static List<Course> search(String term) throws SQLException {
        if (term == null) {
            return getEntities();
        }

        String sql = "SELECT * FROM courses WHERE name ILIKE ?";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%"+term+"%");
            ResultSet resultSet = stmt.executeQuery();
            List<Course> courses = new ArrayList<>();

            while (resultSet.next()) {
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                LocalDateTime createdAt = resultSet.getTimestamp("created_at").toLocalDateTime();

                Course course = new Course(name, description);
                course.setCreatedAt(createdAt);
                course.setId(id);

                courses.add(course);
            }

            return courses;
        }
    }
}
