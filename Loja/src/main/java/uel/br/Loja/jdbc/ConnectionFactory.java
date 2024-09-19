package uel.br.Loja.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public abstract class ConnectionFactory {

    private static ConnectionFactory instance = null;
    protected static String propertiesPath = "/conf/datasource.properties"; // Ajuste o caminho se necessário
    private static String dbServer;
    private static String url;
    private static String username;
    private static String password;

    protected ConnectionFactory() {
    }

    public static ConnectionFactory getInstance() throws IOException {
        if (instance == null) {
            Properties properties = new Properties();

            try (InputStream input = ConnectionFactory.class.getClassLoader().getResourceAsStream(propertiesPath)) {
                if (input == null) {
                    throw new IOException("Arquivo de propriedades não encontrado: " + propertiesPath);
                }
                properties.load(input);

                url = properties.getProperty("spring.datasource.url");
                username = properties.getProperty("spring.datasource.username");
                password = properties.getProperty("spring.datasource.password");
                dbServer = properties.getProperty("server");

            } catch (IOException ex) {
                System.err.println(ex.getMessage());
                throw new IOException("Erro ao obter informações do banco de dados.");
            }

            if (url.startsWith("jdbc:postgresql")) {
                instance = new PgConnectionFactory();
            } else {
                throw new RuntimeException("Servidor de banco de dados não suportado.");
            }
        }

        return instance;
    }

    public static String getDbServer() {
        return dbServer;
    }

    public abstract Connection getConnection() throws SQLException;

    protected Connection createConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}