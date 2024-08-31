package br.uel.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public Connection connection() throws SQLException {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/fabiojun";
        String username = "fabiojun";
        String password = "1290";
        return DriverManager.getConnection(jdbcUrl, username, password);
    }

    @Bean
    public JogoDAO jogoDAO(Connection connection) {
        return new JogoDAO(connection);
    }
}
