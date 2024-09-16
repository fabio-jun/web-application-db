package br.uel.gamehub;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private final Connection connection;

    public CategoriaDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Categoria> listarTodas() throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT nome_categoria, cat_id_jogo FROM loja.categoria";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setCatIdJogo(rs.getInt("cat_id_jogo"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    public List<Categoria> buscarCategoriasPorJogo(int idJogo) throws SQLException {
        List<Categoria> categorias = new ArrayList<>();
        String sql = "SELECT nome_categoria, cat_id_jogo FROM loja.categoria WHERE cat_id_jogo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Categoria categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setCatIdJogo(rs.getInt("cat_id_jogo"));
                categorias.add(categoria);
            }
        }
        return categorias;
    }

    public Categoria buscarPorIdJogo(int idJogo) throws SQLException {
        Categoria categoria = null;
        String sql = "SELECT nome_categoria, cat_id_jogo FROM loja.categoria WHERE cat_id_jogo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                categoria = new Categoria();
                categoria.setNomeCategoria(rs.getString("nome_categoria"));
                categoria.setCatIdJogo(rs.getInt("cat_id_jogo"));
            }
        }
        return categoria;
    }

    public void salvar(Categoria categoria) throws SQLException {
        String sql = "INSERT INTO loja.categoria (nome_categoria, cat_id_jogo) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getCatIdJogo());
            stmt.executeUpdate();
        }
    }

    public void atualizar(Categoria categoria) throws SQLException {
        String sql = "UPDATE loja.categoria SET nome_categoria = ? WHERE cat_id_jogo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, categoria.getNomeCategoria());
            stmt.setInt(2, categoria.getCatIdJogo());
            stmt.executeUpdate();
        }
    }

    public void remover(int idJogo) throws SQLException {
        String sql = "DELETE FROM loja.categoria WHERE cat_id_jogo = ?";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, idJogo);
            stmt.executeUpdate();
        }
    }
}
