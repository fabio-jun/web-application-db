package br.uel.store;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private final Connection connection;

    // Construtor que recebe a conexão
    public JogoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para salvar um jogo no banco de dados
    public void salvar(Jogo jogo) throws SQLException {
        String sql = "INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getDescricao());
            stmt.setBigDecimal(3, jogo.getPreco());
            stmt.setDate(4, new Date(jogo.getLancamento().getTime()));
            stmt.setBigDecimal(5, jogo.getNota());
            stmt.setString(6, jogo.getImagePath());
            stmt.executeUpdate();
        }
    }

    // Método para buscar um jogo pelo seu ID
    public Jogo buscarPorId(int idJogo) throws SQLException {
        String sql = "SELECT * FROM loja.jogo WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Jogo jogo = new Jogo();
                    jogo.setIdJogo(rs.getInt("id_jogo"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setDescricao(rs.getString("descricao"));
                    jogo.setPreco(rs.getBigDecimal("preco"));
                    jogo.setLancamento(rs.getDate("lancamento"));
                    jogo.setNota(rs.getBigDecimal("nota"));
                    jogo.setImagePath(rs.getString("image_path"));
                    return jogo;
                }
            }
        }
        return null;
    }

    // Método para listar todos os jogos
    public List<Jogo> listarTodos() throws SQLException {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM loja.jogo";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setIdJogo(rs.getInt("id_jogo"));
                jogo.setNome(rs.getString("nome"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setPreco(rs.getBigDecimal("preco"));
                jogo.setLancamento(rs.getDate("lancamento"));
                jogo.setNota(rs.getBigDecimal("nota"));
                jogo.setImagePath(rs.getString("image_path"));
                jogos.add(jogo);
            }
        }
        return jogos;
    }

    // Método para atualizar um jogo existente
    public void atualizar(Jogo jogo) throws SQLException {
        String sql = "UPDATE loja.jogo SET nome = ?, descricao = ?, preco = ?, lancamento = ?, nota = ?, image_path = ? WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getDescricao());
            stmt.setBigDecimal(3, jogo.getPreco());
            stmt.setDate(4, new Date(jogo.getLancamento().getTime()));
            stmt.setBigDecimal(5, jogo.getNota());
            stmt.setString(6, jogo.getImagePath());
            stmt.setInt(7, jogo.getIdJogo());
            stmt.executeUpdate();
        }
    }

    // Método para deletar um jogo pelo seu ID
    public void deletar(int idJogo) throws SQLException {
        String sql = "DELETE FROM loja.jogo WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            stmt.executeUpdate();
        }
    }
}
