package julia.recipeWebApp.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("")
@Controller
public class IndexController {

    public IndexController() {
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String getIndex(){
        return "index";
    }
}
