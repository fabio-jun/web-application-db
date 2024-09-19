package br.uel.admgamehub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uel.admgamehub.model.Plataforma;

public class PlataformaDAO {

    private static final String CREATE_QUERY =
        "INSERT INTO loja.plataforma (nome_plataforma, plat_id_jogo) " +
        "VALUES (?, ?);";

    private static final String READ_QUERY =
        "SELECT nome_plataforma, plat_id_jogo " +
        "FROM loja.plataforma WHERE nome_plataforma = ? AND plat_id_jogo = ?;";

    private static final String UPDATE_QUERY =
        "UPDATE loja.plataforma " +
        "SET nome_plataforma = ? WHERE plat_id_jogo = ?;";

    private static final String DELETE_QUERY =
        "DELETE FROM loja.plataforma WHERE nome_plataforma = ? AND plat_id_jogo = ?;";

    private static final String ALL_QUERY =
        "SELECT nome_plataforma, plat_id_jogo " +
        "FROM loja.plataforma;";

    private final Connection connection;

    public PlataformaDAO(Connection connection) {
        this.connection = connection;
    }

    public void create(Plataforma plataforma) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_QUERY)) {
            statement.setString(1, plataforma.getNomePlataforma());
            statement.setInt(2, plataforma.getPlatIdJogo());
            statement.executeUpdate();
        }
    }

    public Plataforma read(String nomePlataforma, int platIdJogo) throws SQLException {
        Plataforma plataforma = null;
        try (PreparedStatement statement = connection.prepareStatement(READ_QUERY)) {
            statement.setString(1, nomePlataforma);
            statement.setInt(2, platIdJogo);
            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    plataforma = new Plataforma();
                    plataforma.setNomePlataforma(result.getString("nome_plataforma"));
                    plataforma.setPlatIdJogo(result.getInt("plat_id_jogo"));
                }
            }
        }
        return plataforma;
    }

    public void update(Plataforma plataforma) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, plataforma.getNomePlataforma());
            statement.setInt(2, plataforma.getPlatIdJogo());
            statement.executeUpdate();
        }
    }

    public void delete(String nomePlataforma, int platIdJogo) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, nomePlataforma);
            statement.setInt(2, platIdJogo);
            statement.executeUpdate();
        }
    }

    public List<Plataforma> all() throws SQLException {
        List<Plataforma> plataformaList = new ArrayList<>();
        try (PreparedStatement statement = connection.prepareStatement(ALL_QUERY);
             ResultSet result = statement.executeQuery()) {
            while (result.next()) {
                Plataforma plataforma = new Plataforma();
                plataforma.setNomePlataforma(result.getString("nome_plataforma"));
                plataforma.setPlatIdJogo(result.getInt("plat_id_jogo"));
                plataformaList.add(plataforma);
            }
        }
        return plataformaList;
    }
}
