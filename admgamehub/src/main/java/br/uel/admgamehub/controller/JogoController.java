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

import br.uel.admgamehub.dao.JogoDAO;
import br.uel.admgamehub.model.Jogo;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    private final JogoDAO jogoDAO;

    public JogoController(JogoDAO jogoDAO) {
        this.jogoDAO = jogoDAO;
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> getAllJogos() {
        try {
            List<Jogo> jogos = jogoDAO.all();
            return ResponseEntity.ok(jogos);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PostMapping
    public ResponseEntity<Jogo> createJogo(@RequestBody Jogo jogo) {
        try {
            jogoDAO.create(jogo);
            return ResponseEntity.status(HttpStatus.CREATED).body(jogo);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> updateJogo(@PathVariable int id, @RequestBody Jogo jogo) {
        try {
            jogo.setIdJogo(id);
            jogoDAO.update(jogo);
            return ResponseEntity.ok(jogo);
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteJogo(@PathVariable int id) {
        try {
            jogoDAO.delete(id);
            return ResponseEntity.noContent().build();
        } catch (SQLException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
