package Biblioteca;

import Model.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    @GetMapping("/inicio")
    public String inicio() { return "usuarios/inicio";}

    @GetMapping
    public String listar(Model model){
        model.addAttribute("usuarios",usuarios);
        return "usuarios/lista";
    }

    @PostMapping
    public String cadastrar(@ModelAttribute Usuario usuarios)
    {
        usuarios.add(usuarios);
        return "redirect:/livros";
    }

    @DeleteMapping("excluir/{indice}")
    public String excluir(@PathVariable int indice){
        if (indice >= 0 && indice < usuarios.size())
        {
            usuarios.remove(indice);
        }
        return "redirect:/emprestimos";
    }

}
