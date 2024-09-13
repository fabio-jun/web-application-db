package br.uel.gamehub;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@Configuration
public class DatabaseConfig {

    @Bean
    public Connection connection() throws SQLException {
        // Substitua com os detalhes corretos do banco de dados
        return DriverManager.getConnection("jdbc:postgresql://sicm.dc.uel.br:5432/fabiojun", "fabiojun", "1290");
    }
}
