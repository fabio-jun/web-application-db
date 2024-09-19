package br.uel.admgamehub.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.uel.admgamehub.dao.CompraDAO;
import br.uel.admgamehub.model.Compra;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraDAO compraDAO;

    public CompraController(CompraDAO compraDAO) {
        this.compraDAO = compraDAO;
    }

    @GetMapping
    public ResponseEntity<List<Compra>> getAllCompras() {
        try {
            List<Compra> compraList = compraDAO.all();
            if (compraList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(compraList);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Compra> criarCompra(@RequestBody Compra compra) {
        try {
            compraDAO.create(compra);
            return ResponseEntity.status(HttpStatus.CREATED).body(compra);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable int id) {
        try {
            Compra compra = compraDAO.read(id);
            if (compra == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(compra);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> atualizarCompra(@PathVariable int id, @RequestBody Compra compra) {
        try {
            compra.setIdCompra(id);
            compraDAO.update(compra);
            return ResponseEntity.ok(compra);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerCompra(@PathVariable int id) {
        try {
            compraDAO.delete(id);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
