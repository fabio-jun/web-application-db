package br.uel.gamehub;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogoController {

    private final JogoService jogoService;


    public JogoController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/jogos")
    public String listarJogos(Model model) throws SQLException {
        List<Jogo> jogos = jogoService.listarTodos();
        model.addAttribute("jogos", jogos);
        return "jogos"; // Retorna a página jogos.html
    }
}
