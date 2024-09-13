package br.uel.gamehub;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final JogoService jogoService;

    public HomeController(JogoService jogoService) {
        this.jogoService = jogoService;
    }

    @GetMapping("/")
    public String home(Model model) throws SQLException {
        // Carregar a lista de jogos
        List<Jogo> jogos = jogoService.listarTodos();
        model.addAttribute("jogos", jogos); // Adiciona a lista ao modelo
        return "index"; // Nome do template Thymeleaf
    }
}
