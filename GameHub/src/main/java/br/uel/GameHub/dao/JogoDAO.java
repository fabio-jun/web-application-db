package br.uel.gamehub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.uel.gamehub.model.Jogo;

@Repository
public class JogoDAO implements DAO<Jogo> {
    
    private static final String CREATE_QUERY =
            "INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) " +
            "VALUES (?, ?, ?, ?, ?, ?);";
                            
    private static final String ALL_QUERY =
            "SELECT id_jogo, nome, descricao, preco, lancamento, nota, image_path " +
            "FROM loja.jogo " +
            "ORDER BY id_jogo;";    

    private static final String READ_QUERY =
            "SELECT nome, descricao, preco, lancamento, nota, image_path " +
            "FROM loja.jogo " +
            "WHERE id_jogo = ?;";          

    private static final String UPDATE_QUERY =
            "UPDATE loja.jogo " +
            "SET nome = ?, descricao = ?, preco = ?, lancamento = ?, nota = ?, image_path = ? " +
            "WHERE id_jogo = ?;";

    private static final String DELETE_QUERY =
            "DELETE FROM loja.jogo " +
            "WHERE id_jogo = ?;";

    @Autowired
    private DataSource dataSource;

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    @Override
    public void create(Jogo jogo) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(CREATE_QUERY)) {
            statement.setString(1, jogo.getNome());
            statement.setString(2, jogo.getDescricao());
            statement.setBigDecimal(3, jogo.getPreco());
            statement.setDate(4, jogo.getLancamento());
            statement.setBigDecimal(5, jogo.getNota());
            statement.setString(6, jogo.getImagePath());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, "DAO", ex);

            if (ex.getMessage().contains("uk_jogo_nome")) {
                throw new SQLException("Erro ao inserir jogo: Nome do jogo já existente.");
            } else if (ex.getMessage().contains("uk_jogo_image_path")) {
                throw new SQLException("Erro ao inserir jogo: Imagem já existente.");
            } else if (ex.getMessage().contains("ck_jogo_preco")) {
                throw new SQLException("Erro ao inserir jogo: O preço do jogo deve ser maior ou igual a 0.00.");
            } else if (ex.getMessage().contains("ck_jogo_nota")) {
                throw new SQLException("Erro ao inserir jogo: A nota deve estar entre 0.00 e 10.0.");
            } else if (ex.getMessage().contains("not-null")) {
                throw new SQLException("Erro ao inserir jogo: Pelo menos um campo está em branco.");
            } else {
                throw new SQLException("Erro ao inserir jogo.");
            }
        }
    }

    @Override
    public Jogo read(Integer id) throws SQLException {
        Jogo jogo = new Jogo();
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(READ_QUERY)) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    jogo.setIdJogo(id);
                    jogo.setNome(result.getString("nome"));
                    jogo.setDescricao(result.getString("descricao"));
                    jogo.setPreco(result.getBigDecimal("preco"));
                    jogo.setLancamento(result.getDate("lancamento"));
                    jogo.setNota(result.getBigDecimal("nota"));
                    jogo.setImagePath(result.getString("image_path"));
                } else {
                    throw new SQLException("Erro ao visualizar: Jogo não encontrado.");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, "DAO", ex);

            if (ex.getMessage().equals("Erro ao visualizar: Jogo não encontrado.")) {
                throw ex;
            } else {
                throw new SQLException("Erro ao visualizar jogo.");
            }
        }
        return jogo;
    }

    @Override
    public void update(Jogo jogo) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, jogo.getNome());
            statement.setString(2, jogo.getDescricao());
            statement.setBigDecimal(3, jogo.getPreco());
            statement.setDate(4, jogo.getLancamento());
            statement.setBigDecimal(5, jogo.getNota());
            statement.setString(6, jogo.getImagePath());
            statement.setInt(7, jogo.getIdJogo());

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Erro ao editar jogo: Jogo não encontrado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, "DAO", ex);

            if (ex.getMessage().equals("Erro ao editar jogo: Jogo não encontrado.")) {
                throw ex;
            } else if (ex.getMessage().contains("uk_jogo_nome")) {
                throw new SQLException("Erro ao editar jogo: Nome do jogo já existente.");
            } else if (ex.getMessage().contains("uk_jogo_image_path")) {
                throw new SQLException("Erro ao editar jogo: Imagem já existente.");
            } else if (ex.getMessage().contains("ck_jogo_preco")) {
                throw new SQLException("Erro ao editar jogo: O preço do jogo deve ser maior ou igual a 0.00.");
            } else if (ex.getMessage().contains("ck_jogo_nota")) {
                throw new SQLException("Erro ao editar jogo: A nota deve estar entre 0.00 e 10.0.");
            } else if (ex.getMessage().contains("not-null")) {
                throw new SQLException("Erro ao editar jogo: Pelo menos um campo está em branco.");
            } else {
                throw new SQLException("Erro ao editar jogo.");
            }
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Erro ao excluir: Jogo não encontrado.");
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, "DAO", ex);

            if (ex.getMessage().equals("Erro ao excluir: Jogo não encontrado.")) {
                throw ex;
            } else {
                throw new SQLException("Erro ao excluir jogo.");
            }
        }
    }

    @Override
    public List<Jogo> all() throws SQLException {
        List<Jogo> jogoList = new ArrayList<>();

        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(ALL_QUERY);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                Jogo jogo = new Jogo();
                jogo.setIdJogo(result.getInt("id_jogo"));
                jogo.setNome(result.getString("nome"));
                jogo.setDescricao(result.getString("descricao"));
                jogo.setPreco(result.getBigDecimal("preco"));
                jogo.setLancamento(result.getDate("lancamento"));
                jogo.setNota(result.getBigDecimal("nota"));
                jogo.setImagePath(result.getString("image_path"));

                jogoList.add(jogo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, "DAO", ex);

            throw new SQLException("Erro ao listar jogos.");
        }
        return jogoList;
    }
}
