package julia.recipeWebApp.services;

import julia.recipeWebApp.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
