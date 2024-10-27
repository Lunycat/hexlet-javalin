package org.example.hexlet.repository;

import lombok.Getter;
import org.example.hexlet.model.User;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {
    @Getter
    private static List<User> entities = new ArrayList<>();

    public static void save(User user) {
        user.setId((long) entities.size() + 1);
        user.setCreatedAt(LocalDateTime.now());
        entities.add(user);
    }

    public static void delete(Long id) {
        entities.remove(entities.stream()
                .filter(u -> u.getId() == id)
                .findAny()
                .orElse(null));
    }

    public static Optional<User> find(Long id) {
        return entities.stream()
                .filter(u -> u.getId() == id)
                .findAny();
    }

    public static List<User> search(String term) {
        if (term == null) {
            return entities;
        }
        return entities.stream()
                .filter(u -> u.getName().toLowerCase().startsWith(term.toLowerCase()))
                .toList();
    }

    public static void update(User user) {
        entities.set(entities.indexOf(user), user);
    }
}
