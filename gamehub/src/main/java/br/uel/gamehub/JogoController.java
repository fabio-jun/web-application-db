package br.uel.gamehub;

import java.sql.SQLException;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class JogoController {

    private final JogoService jogoService;
    private final CategoriaService categoriaService;

    public JogoController(JogoService jogoService, CategoriaService categoriaService) {
        this.jogoService = jogoService;
        this.categoriaService = categoriaService;
    }

    @GetMapping("/jogos")
    public String listarJogos(Model model) throws SQLException {
        List<Jogo> jogos = jogoService.listarTodos();
        model.addAttribute("jogos", jogos);
        return "exibir";
    }

    @GetMapping("/jogos/{id}")
    public String exibirDetalhes(@PathVariable("id") int id, Model model) throws SQLException {
        Jogo jogo = jogoService.buscarPorId(id);
        model.addAttribute("jogo", jogo);
        return "detalhes"; 
    }

    @GetMapping("/jogos/adicionar")
    public String exibirFormularioAdicao(Model model) throws SQLException {
        model.addAttribute("jogo", new Jogo()); 
        List<Categoria> categorias = categoriaService.listarTodas(); 
        model.addAttribute("categorias", categorias);  
        return "adicionar";  
    }


    @PostMapping("/jogos/adicionar")
    @PreAuthorize("hasRole('ADMIN')")
    public String salvarNovoJogo(@ModelAttribute Jogo novoJogo) throws SQLException {
        jogoService.salvarJogo(novoJogo); 
        return "redirect:/jogos";  
    }

    @PostMapping("/jogos/{id}/editar")
    @PreAuthorize("hasRole('ADMIN')")
    public String salvarAlteracoes(@PathVariable("id") int id, @ModelAttribute Jogo jogoAtualizado) throws SQLException {
        jogoAtualizado.setIdJogo(id); 
        jogoService.atualizarJogo(jogoAtualizado);
        return "redirect:/jogos/" + id; 
    }

    @GetMapping("/jogos/{id}/editar")
    public String exibirFormularioEdicao(@PathVariable("id") int id, Model model) throws SQLException {
        Jogo jogo = jogoService.buscarPorId(id); 
        List<Categoria> categorias = jogoService.buscarCategoriasPorJogo(id);  
        List<Categoria> todasCategorias = categoriaService.listarTodas();  
        model.addAttribute("jogo", jogo);
        model.addAttribute("categorias", categorias);  
        model.addAttribute("todasCategorias", todasCategorias);  
        return "detalhes"; 
    }



    @PostMapping("/jogos/{id}/remover")
    @PreAuthorize("hasRole('ADMIN')")
    public String removerJogo(@PathVariable("id") int id) throws SQLException {
        jogoService.removerJogo(id); 
        return "redirect:/jogos"; 
    }
}
