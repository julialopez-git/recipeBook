package julia.recipeWebApp.Controllers;

import julia.recipeWebApp.models.Category;
import julia.recipeWebApp.models.UnitOfMeasure;
import julia.recipeWebApp.repositories.CategoryRepository;
import julia.recipeWebApp.repositories.UnitOfMeasureRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@RequestMapping("")
@Controller
public class IndexController {
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping({"/", "/index", "/index.html"})
    public String getIndex(){
        Optional<Category> categoryOptional =  categoryRepository.findByDescription("Vegan");
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        System.out.println("Category id is " + categoryOptional.get().getId());
        System.out.println("Uom id is " + uomOptional.get().getId());
        return "index";
    }

}
