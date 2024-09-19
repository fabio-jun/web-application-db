package br.uel.admgamehub.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PgConnectionFactory extends ConnectionFactory {

    private String dbHost;
    private String dbPort;
    private String dbName;
    private String dbUser;
    private String dbPassword;

    public PgConnectionFactory() {

        try {
            readProperties();
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler propriedades do banco de dados.", e);
        }
    }

    private void readProperties() throws IOException {
        Properties properties = new Properties();

        try (InputStream input = this.getClass().getClassLoader().getResourceAsStream(propertiesPath)) {
            if (input == null) {
                throw new IOException("Arquivo de propriedades não encontrado: " + propertiesPath);
            }
            properties.load(input);

            dbHost = properties.getProperty("host");
            dbPort = properties.getProperty("port");
            dbName = properties.getProperty("name");
            dbUser = properties.getProperty("user");
            dbPassword = properties.getProperty("password");
        } catch (IOException ex) {
            System.err.println(ex.getMessage());
            throw new IOException("Erro ao obter informações do banco de dados.", ex);
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        Connection connection;

        try {
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://" + dbHost + ":" + dbPort + "/" + dbName;
            connection = DriverManager.getConnection(url, dbUser, dbPassword);
        } catch (ClassNotFoundException ex) {
            System.err.println(ex.getMessage());
            throw new SQLException("Erro de conexão ao banco de dados: driver não encontrado.", ex);
        }

        return connection;
    }
}