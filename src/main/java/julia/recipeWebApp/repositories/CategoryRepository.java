package julia.recipeWebApp.repositories;

import julia.recipeWebApp.models.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
