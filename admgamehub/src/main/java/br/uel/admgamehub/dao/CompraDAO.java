package br.uel.admgamehub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import br.uel.admgamehub.model.Compra;

@Repository
public class CompraDAO implements DAO<Compra> {

    private static final String CREATE_QUERY = 
            "INSERT INTO loja.compra (comp_id_cliente, comp_preco) " +
            "VALUES (?, ?);";

    private static final String READ_QUERY = 
            "SELECT id_comp, comp_id_cliente, comp_preco " +
            "FROM loja.compra " +
            "WHERE id_comp = ?;";

    private static final String UPDATE_QUERY = 
            "UPDATE loja.compra " +
            "SET comp_id_cliente = ?, comp_preco = ? " +
            "WHERE id_comp = ?;";

    private static final String DELETE_QUERY = 
            "DELETE FROM loja.compra " +
            "WHERE id_comp = ?;";

    private static final String ALL_QUERY = 
            "SELECT id_comp, comp_id_cliente, comp_preco " +
            "FROM loja.compra " +
            "ORDER BY id_comp;";

    private final Connection connection;

    public CompraDAO(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Compra compra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(CREATE_QUERY)) {
            statement.setInt(1, compra.getIdCliente());
            statement.setBigDecimal(2, compra.getPreco());

            statement.executeUpdate();
        } catch (SQLException ex) {
            throw new SQLException("Erro ao inserir compra: " + ex.getMessage(), ex);
        }
    }

    @Override
    public Compra read(Integer id) throws SQLException {
        Compra compra = new Compra();

        try (PreparedStatement statement = connection.prepareStatement(READ_QUERY)) {
            statement.setInt(1, id);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    compra.setIdCompra(result.getInt("id_comp"));
                    compra.setIdCliente(result.getInt("comp_id_cliente"));
                    compra.setPreco(result.getBigDecimal("comp_preco"));
                } else {
                    throw new SQLException("Erro ao visualizar: Compra não encontrada.");
                }
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao visualizar compra: " + ex.getMessage(), ex);
        }

        return compra;
    }

    @Override
    public void update(Compra compra) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setInt(1, compra.getIdCliente());
            statement.setBigDecimal(2, compra.getPreco());
            statement.setInt(3, compra.getIdCompra());

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Erro ao editar: Compra não encontrada.");
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao editar compra: " + ex.getMessage(), ex);
        }
    }

    @Override
    public void delete(Integer id) throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setInt(1, id);

            if (statement.executeUpdate() < 1) {
                throw new SQLException("Erro ao excluir: Compra não encontrada.");
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao excluir compra: " + ex.getMessage(), ex);
        }
    }

    @Override
    public List<Compra> all() throws SQLException {
        List<Compra> compraList = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement(ALL_QUERY);
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                Compra compra = new Compra();
                compra.setIdCompra(result.getInt("id_comp"));
                compra.setIdCliente(result.getInt("comp_id_cliente"));
                compra.setPreco(result.getBigDecimal("comp_preco"));

                compraList.add(compra);
            }
        } catch (SQLException ex) {
            throw new SQLException("Erro ao listar compras: " + ex.getMessage(), ex);
        }

        return compraList;
    }
}
