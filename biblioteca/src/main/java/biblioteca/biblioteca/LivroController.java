@Controller
@RequestMapping("/livros")
public class LivroController {

    @GetMapping
    public String inicio(){
        return "livros/inicio";
    }
}