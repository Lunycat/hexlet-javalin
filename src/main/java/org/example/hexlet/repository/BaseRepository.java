package org.example.hexlet.repository;

import com.zaxxer.hikari.HikariDataSource;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BaseRepository {
    public static HikariDataSource dataSource;
}
