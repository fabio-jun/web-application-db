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

import br.uel.admgamehub.dao.CategoriaDAO;
import br.uel.admgamehub.model.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaDAO categoriaDAO;

    public CategoriaController(CategoriaDAO categoriaDAO) {
        this.categoriaDAO = categoriaDAO;
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> getAllCategorias() {
        try {
            List<Categoria> categoriaList = categoriaDAO.all();
            if (categoriaList.isEmpty()) {
                return ResponseEntity.noContent().build();
            }
            return ResponseEntity.ok(categoriaList);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Categoria> criarCategoria(@RequestBody Categoria categoria) {
        try {
            categoriaDAO.create(categoria);
            return ResponseEntity.status(HttpStatus.CREATED).body(categoria);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{nomeCategoria}/{idJogo}")
    public ResponseEntity<Categoria> getCategoriaByNomeAndJogo(@PathVariable String nomeCategoria, @PathVariable int idJogo) {
        try {
            Categoria categoria = categoriaDAO.read(nomeCategoria, idJogo);
            if (categoria == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(categoria);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{idJogo}")
    public ResponseEntity<Categoria> atualizarCategoria(@PathVariable int idJogo, @RequestBody Categoria categoria) {
        try {
            categoria.setIdJogo(idJogo);
            categoriaDAO.update(categoria);
            return ResponseEntity.ok(categoria);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{nomeCategoria}/{idJogo}")
    public ResponseEntity<Void> removerCategoria(@PathVariable String nomeCategoria, @PathVariable int idJogo) {
        try {
            categoriaDAO.delete(nomeCategoria, idJogo);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
