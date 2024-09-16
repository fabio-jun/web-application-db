package br.uel.gamehub;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class JogoService {

    private final JogoDAO jogoDAO;
    private final CategoriaDAO categoriaDAO; 

    public JogoService(Connection connection) {
        this.jogoDAO = new JogoDAO(connection);
        this.categoriaDAO = new CategoriaDAO(connection); 
    }

    public List<Jogo> listarTodos() {
        try {
            return jogoDAO.listarTodos();
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao listar jogos", e);
        }
    }

    public List<Jogo> buscarJogosPorNome(String nome) {
        try {
            return jogoDAO.buscarPorNome(nome);
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar jogos por nome", e);
        }
    }

    public void atualizarJogo(Jogo jogo) throws SQLException {
        jogoDAO.atualizar(jogo);
    }

    public Jogo buscarPorId(int id) throws SQLException {
        return jogoDAO.buscarPorId(id);
    }

    public void salvarJogo(Jogo jogo) throws SQLException {
        jogoDAO.salvar(jogo);
    }
    
    public void removerJogo(int id) throws SQLException {
        jogoDAO.remover(id);
    }

    public List<Categoria> buscarCategoriasPorJogo(int idJogo) throws SQLException {
        return categoriaDAO.buscarCategoriasPorJogo(idJogo); 
    }
}
