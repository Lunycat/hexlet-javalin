package org.example.hexlet.repository;

import lombok.Getter;
import org.example.hexlet.model.Course;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    @Getter
    private static List<Course> entities = new ArrayList<>();

    public static void save(Course course) {
        course.setId((long) entities.size() + 1);
        course.setCreatedAt(LocalDateTime.now());
        entities.add(course);
    }

    public static void delete(Long id) {
        entities.remove(entities.stream()
                .filter(c -> c.getId() == id)
                .findAny()
                .orElse(null));
    }

    public static Optional<Course> find(Long id) {
        return entities.stream()
                .filter(c -> c.getId() == id)
                .findAny();
    }

    public static List<Course> search(String term) {
        if (term == null) {
            return entities;
        }
        return entities.stream()
                .filter(c -> c.getName().toLowerCase().startsWith(term.toLowerCase()))
                .toList();
    }
}
