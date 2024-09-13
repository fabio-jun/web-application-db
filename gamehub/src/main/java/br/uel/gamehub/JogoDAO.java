package br.uel.gamehub;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogoDAO {

    private Connection connection;

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

    }

