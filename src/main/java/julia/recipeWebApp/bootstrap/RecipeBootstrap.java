package julia.recipeWebApp.bootstrap;

import julia.recipeWebApp.models.*;
import julia.recipeWebApp.repositories.CategoryRepository;
import julia.recipeWebApp.repositories.RecipeRepository;
import julia.recipeWebApp.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private final RecipeRepository recipeRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;
    private final CategoryRepository categoryRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository, CategoryRepository categoryRepository) {
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getRecipes());
    }


    public List<Recipe> getRecipes(){
        List<Recipe> recipes = new ArrayList<>(1);

        /*-------------------------------- get UOM ------------------------------------- */
        Optional <UnitOfMeasure> optTeaspoon = unitOfMeasureRepository.findByDescription("Teaspoon");
        if(!optTeaspoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optTablespoon = unitOfMeasureRepository.findByDescription("Tablespoon");
        if(!optTablespoon.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optCup = unitOfMeasureRepository.findByDescription("Cup");
        if(!optCup.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optPinch = unitOfMeasureRepository.findByDescription("Pinch");
        if(!optPinch.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optOunce = unitOfMeasureRepository.findByDescription("Ounce");
        if(!optOunce.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optPound = unitOfMeasureRepository.findByDescription("Pound");
        if(!optPound.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        Optional <UnitOfMeasure> optBag = unitOfMeasureRepository.findByDescription("Bag");
        if(!optBag.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }
        /*-------------------------------- get OPTIONALS ------------------------------------- */
        UnitOfMeasure teaspoon = optTeaspoon.get();
        UnitOfMeasure tablespoon = optTablespoon.get();
        UnitOfMeasure cup = optCup.get();
        UnitOfMeasure pinch = optPinch.get();
        UnitOfMeasure ounce = optOunce.get();
        UnitOfMeasure pound = optPound.get();
        UnitOfMeasure bag = optBag.get();

        /*-------------------------------- get Categories ------------------------------------- */
        Optional<Category> optMexican = categoryRepository.findByDescription("Mexican");
        if(!optMexican.isPresent()){
            throw new RuntimeException("Category not found");
        }
        /*-------------------------------- get optional ------------------------------------- */
        Category mexican = optMexican.get();

        /*-------------------------------- Recipe ------------------------------------- */

        Recipe nachos = new Recipe();
        nachos.setDescription("Nachos");
        nachos.getCategories().add(mexican);
        nachos.setCookTime(15);
        nachos.setPrepTime(15);
        nachos.setDifficulty(Difficulty.EASY);
        nachos.setDirections("1.Preheat the oven to 350°F.\n" +
                "2. Make the taco spice blend: combine all of the spices (chili powder through cayenne) together in a small bowl.\n" +
                "3. Make the beef and bean topping: Heat the vegetable oil on medium high heat until it begins to shimmer. Add the ground beef to the pan and season it with all of the taco spice blend. As the meat cooks, use a spoon to break the meat up into crumbles. Cook for about 8 minutes until the meat has browned and drain the fat using a colander. Return the meat to the pan and add the refried beans and the water. Heat the mixture until the beans are smooth and warmed through. Reduce the heat to low and keep the beef-bean mixture warm while you prepare the chips.\n" +
                "\n" +
                "4. Toast the chips: On a 13x18-inch oven-safe platter or sheet pan, arrange the tortilla chips in a single layer, overlapping them slightly. Toast the chips in the preheated oven for 5 minutes, or just until you begin to smell their aroma.\n" +
                "\n" +
                "5. Assemble and bake the nachos: Carefully remove the pan from the oven and top with one half of the shredded cheeses. Allow the heat from the chips to melt the cheese slightly before topping the chips with the beef and bean mixture. Sprinkle the remaining cheese over the beef and return the pan to the oven for 5 minutes, or until the cheese has fully melted.\n" +
                "\n" +
                "6. Top and serve: Top the nachos with the pico de gallo, chopped cilantro, jalapeño slices, or any of your preferred toppings. Serve hot.\n");

        Notes nachosNotes = new Notes();
        nachosNotes.setRecipeNotes("No notes");
        nachosNotes.setRecipe(nachos);
        nachos.setNotes(nachosNotes);

        nachos.setServings(6);
        nachos.setSource("Simply Recipes");
        nachos.setUrl("https://www.simplyrecipes.com/recipes/nachos/");

        nachos.getIngredients().add(new Ingredient("Ground beef", 1.0, pound, nachos));
        nachos.getIngredients().add(new Ingredient("Vegetable oil", 1.0, teaspoon, nachos));
        nachos.getIngredients().add(new Ingredient("Refried beans", 2.0, cup, nachos));
        nachos.getIngredients().add(new Ingredient("Water", 0.25, cup, nachos));
        nachos.getIngredients().add(new Ingredient("Cheddar cheese", 4.0, ounce, nachos));
        nachos.getIngredients().add(new Ingredient("Pico de gallo", 1.0, cup, nachos));
        nachos.getIngredients().add(new Ingredient("Jalapeño", 1.0, null, nachos));
        nachos.getIngredients().add(new Ingredient("Pepper", 1.0, pinch, nachos));

        recipes.add(nachos);
        return recipes;
    }
}
