package Biblioteca;

import Model.Emprestimo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/emprestimos")
public class EmprestimoController {

    private List<Emprestimo> emprestimos = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio() { return "emprestimos/inicio";}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("emprestimos",emprestimos);
        return "emprestimos/lista";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Emprestimo emprestimos)
    {
        emprestimos.add(emprestimos);
        return "redirect:/livros";
    }

    @DeleteMapping("excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < emprestimos.size())
        {
            emprestimos.remove(indice);
        }
        return "redirect:/emprestimos";
    }

}
