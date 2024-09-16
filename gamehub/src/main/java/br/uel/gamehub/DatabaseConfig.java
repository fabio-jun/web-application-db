package br.uel.gamehub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {
        String url = "jdbc:postgresql://sicm.dc.uel.br:5432/fabiojun";
        String username = "fabiojun";
        String password = "1290";
        return DriverManager.getConnection(url, username, password);
    }
}
