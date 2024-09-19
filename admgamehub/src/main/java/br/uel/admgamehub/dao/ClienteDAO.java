package br.uel.admgamehub.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.uel.admgamehub.model.Cliente;

public class ClienteDAO {

    private final Connection connection;

    public ClienteDAO(Connection connection) {
        this.connection = connection;
    }

    public void salvar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO loja.cliente (pnome, snome, endereco, telefone, email, senha) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPnome());
            stmt.setString(2, cliente.getSnome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            stmt.executeUpdate();
        }
    }

    public Cliente buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM loja.cliente WHERE id_cliente = ?";
        Cliente cliente = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setPnome(rs.getString("pnome"));
                cliente.setSnome(rs.getString("snome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
            }
        }
        return cliente;
    }

    public List<Cliente> listarTodos() throws SQLException {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM loja.cliente";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("id_cliente"));
                cliente.setPnome(rs.getString("pnome"));
                cliente.setSnome(rs.getString("snome"));
                cliente.setEndereco(rs.getString("endereco"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                clientes.add(cliente);
            }
        }
        return clientes;
    }

    public void atualizar(Cliente cliente) throws SQLException {
        String sql = "UPDATE loja.cliente SET pnome = ?, snome = ?, endereco = ?, telefone = ?, email = ?, senha = ? WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cliente.getPnome());
            stmt.setString(2, cliente.getSnome());
            stmt.setString(3, cliente.getEndereco());
            stmt.setString(4, cliente.getTelefone());
            stmt.setString(5, cliente.getEmail());
            stmt.setString(6, cliente.getSenha());
            stmt.setInt(7, cliente.getIdCliente());
            stmt.executeUpdate();
        }
    }

    public void remover(int id) throws SQLException {
        String sql = "DELETE FROM loja.cliente WHERE id_cliente = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
