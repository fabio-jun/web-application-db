package br.uel.gamehub;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JogoService {
    private final JogoDAO jogoDAO;

    // Injetando a conexão via o construtor
    public JogoService(Connection connection) {
        this.jogoDAO = new JogoDAO(connection);
    }

    public List<Jogo> listarTodos() throws SQLException {
        return jogoDAO.listarTodos();
    }

    public void salvarJogo(Jogo jogo) throws SQLException {
        jogoDAO.salvar(jogo);
    }
}
