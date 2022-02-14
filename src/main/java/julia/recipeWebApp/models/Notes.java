package julia.recipeWebApp.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Notes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Recipe recipe;
    /*We use Lob to allow users to store more that the JPA default 255 characters*/
    @Lob
    private String recipeNotes;
}
