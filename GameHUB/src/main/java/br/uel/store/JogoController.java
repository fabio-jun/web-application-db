package br.uel.store;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class JogoController {

    private final JogoDAO jogoDAO;

    @Autowired
    public JogoController(JogoDAO jogoDAO) {
        this.jogoDAO = jogoDAO;
    }

    @GetMapping("/jogos")
    public String listarJogos(Model model) {
        try {
            List<Jogo> jogos = jogoDAO.listarTodos();
            model.addAttribute("jogos", jogos);
        } catch (SQLException e) {
            model.addAttribute("error", "Erro ao buscar jogos do banco de dados");
            e.printStackTrace();
        }
        return "jogos";
    }
}
