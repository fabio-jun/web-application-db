package br.uel.gamehub;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private final Connection connection;

    public JogoDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Jogo> listarTodos() throws SQLException {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM loja.jogo";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()){

            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setIdJogo(rs.getInt("id_jogo"));
                jogo.setNome(rs.getString("nome"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setPreco(rs.getBigDecimal("preco"));
                jogo.setLancamento(rs.getDate("lancamento").toLocalDate());
                jogo.setNota(rs.getBigDecimal("nota"));
                jogo.setImagePath(rs.getString("image_path"));
                jogos.add(jogo);
            }
        }
        return jogos;
    }

    public void salvar(Jogo jogo) throws SQLException {
        String sql = "INSERT INTO loja.jogo (nome, descricao, preco, lancamento, nota, image_path) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getDescricao());
            stmt.setBigDecimal(3, jogo.getPreco());
            stmt.setDate(4, Date.valueOf(jogo.getLancamento()));
            stmt.setBigDecimal(5, jogo.getNota());
            stmt.setString(6, jogo.getImagePath());
            stmt.executeUpdate();
        }
    }

    public List<Jogo> buscarPorNome(String nome) throws SQLException {
        List<Jogo> jogos = new ArrayList<>();
        String sql = "SELECT * FROM loja.jogo WHERE LOWER(nome) LIKE ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, "%" + nome.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Jogo jogo = new Jogo();
                jogo.setIdJogo(rs.getInt("id_jogo"));
                jogo.setNome(rs.getString("nome"));
                jogo.setDescricao(rs.getString("descricao"));
                jogo.setPreco(rs.getBigDecimal("preco"));
                jogo.setLancamento(rs.getDate("lancamento").toLocalDate());
                jogo.setNota(rs.getBigDecimal("nota"));
                jogo.setImagePath(rs.getString("image_path"));
                jogos.add(jogo);
            }
        }
        return jogos;
    }

    public Jogo buscarPorId(int id) throws SQLException {
        Jogo jogo = null;
        String sql = "SELECT * FROM loja.jogo WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    jogo = new Jogo();
                    jogo.setIdJogo(rs.getInt("id_jogo"));
                    jogo.setNome(rs.getString("nome"));
                    jogo.setDescricao(rs.getString("descricao"));
                    jogo.setPreco(rs.getBigDecimal("preco"));
                    jogo.setLancamento(rs.getDate("lancamento").toLocalDate());
                    jogo.setNota(rs.getBigDecimal("nota"));
                    jogo.setImagePath(rs.getString("image_path"));
                }
            }
        }
        return jogo;
    }

    public void atualizar(Jogo jogo) throws SQLException {
        String sql = "UPDATE loja.jogo SET nome = ?, descricao = ?, preco = ?, lancamento = ?, nota = ?, image_path = ? WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, jogo.getNome());
            stmt.setString(2, jogo.getDescricao());
            stmt.setBigDecimal(3, jogo.getPreco());
            stmt.setDate(4, Date.valueOf(jogo.getLancamento()));
            stmt.setBigDecimal(5, jogo.getNota());
            stmt.setString(6, jogo.getImagePath());
            stmt.setInt(7, jogo.getIdJogo());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM loja.jogo WHERE id_jogo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}

