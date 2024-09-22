package br.uel.gamehub.controller;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.time.LocalDateTime;
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

import br.uel.gamehub.dao.CarrinhoDAO;
import br.uel.gamehub.dao.CompraDAO;
import br.uel.gamehub.dao.ItemCompraDAO;
import br.uel.gamehub.dao.JogoDAO;
import br.uel.gamehub.model.Carrinho;
import br.uel.gamehub.model.Compra;
import br.uel.gamehub.model.ItemCompra;
import br.uel.gamehub.model.Jogo;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraDAO compraDAO;
    private final CarrinhoDAO carrinhoDAO;
    private final ItemCompraDAO itemCompraDAO;
    private final JogoDAO jogoDAO; // Adicionando o JogoDAO para recuperar o Jogo

    public CompraController(CompraDAO compraDAO, CarrinhoDAO carrinhoDAO, ItemCompraDAO itemCompraDAO, JogoDAO jogoDAO) {
        this.compraDAO = compraDAO;
        this.carrinhoDAO = carrinhoDAO;
        this.itemCompraDAO = itemCompraDAO;
        this.jogoDAO = jogoDAO;
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

    @PostMapping("/realizar/{clienteId}")
    public ResponseEntity<Compra> realizarCompra(@PathVariable int clienteId) {
        try {
            // Recupera os itens do carrinho do cliente
            List<Carrinho> itensCarrinho = carrinhoDAO.findByClienteId(clienteId);
            if (itensCarrinho.isEmpty()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null); // Carrinho vazio
            }

            // Calcula o preço total da compra
            BigDecimal precoTotal = BigDecimal.ZERO;
            for (Carrinho item : itensCarrinho) {
                // Recupera o Jogo a partir do JogoDAO
                Jogo jogo = jogoDAO.read(item.getIdJogo());
                BigDecimal precoItem = jogo.getPreco().multiply(BigDecimal.valueOf(item.getQtd()));
                precoTotal = precoTotal.add(precoItem);
            }

            // Cria a compra
            Compra compra = new Compra();
            compra.setIdCliente(clienteId);
            compra.setPreco(precoTotal);
            compra.setDataHoraCompra(LocalDateTime.now());
            compraDAO.create(compra);

            // Adiciona os itens do carrinho à tabela de itens de compra
            for (Carrinho item : itensCarrinho) {
                // Recupera o Jogo a partir do JogoDAO
                Jogo jogo = jogoDAO.read(item.getIdJogo());

                ItemCompra itemCompra = new ItemCompra();
                itemCompra.setItemIdComp(compra.getIdCompra());
                itemCompra.setItemIdJogo(item.getIdJogo());
                itemCompra.setItemNomeJogo(jogo.getNome());
                itemCompra.setItemPrecoJogo(jogo.getPreco().doubleValue()); // Converte BigDecimal para double
                itemCompra.setItemQtd(item.getQtd());

                itemCompraDAO.create(itemCompra);
            }

            // Limpa o carrinho após a compra
            carrinhoDAO.clearCarrinhoByClienteId(clienteId);

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
