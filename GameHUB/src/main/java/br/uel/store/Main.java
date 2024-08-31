package br.uel.store;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/fabiojun";
        String username = "fabiojun";
        String password = "1290";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            JogoDAO jogoDAO = new JogoDAO(connection);

            // Exemplo de uso: listar todos os jogos
            List<Jogo> jogos = jogoDAO.listarTodos();
            for (Jogo jogo : jogos) {
                System.out.println("Jogo: " + jogo.getNome() + ", Preço: " + jogo.getPreco());
            }

        } catch (SQLException e) {
            e.printStackTrace();  // Aviso sobre printStackTrace, ver dica abaixo
        }
    }
}
