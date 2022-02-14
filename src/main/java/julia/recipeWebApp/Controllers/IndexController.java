package julia.recipeWebApp.Controllers;

import julia.recipeWebApp.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
@Slf4j
public class IndexController {
    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String getIndex(Model model){
        model.addAttribute("recipes", recipeService.getRecipes());
        return "index";
    }

}
