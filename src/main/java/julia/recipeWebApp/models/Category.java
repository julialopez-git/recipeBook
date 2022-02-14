package julia.recipeWebApp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter @Setter
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;
    /*mappedBy = name of the property in the other class.*/
    @ManyToMany(mappedBy = "categories")
    private Set<Recipe> recipes;
}
