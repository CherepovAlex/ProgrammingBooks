package io.hexlet.repository;

import com.zaxxer.hikari.HikariDataSource;

public class BaseRepository {
    // объявляет статическое поле dataSource для хранения общего пула соединений
    public static HikariDataSource dataSource;
}
