package julia.recipeWebApp.repositories;

import julia.recipeWebApp.models.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {

}
