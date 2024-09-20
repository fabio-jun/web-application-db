package br.uel.GameHub.jdbc;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectionFactory {

    @Autowired
    private DataSource dataSource;

    @Bean
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
