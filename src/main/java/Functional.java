import lombok.*;
import javax.persistence.*;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "functional")
public class Functional {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "functional_id")
    private int functionalId;
    @Column(name = "functional")
    private String functional;
    @OneToMany(mappedBy = "functional", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<User> users;

    public Functional(String functional) {
        this.functional = functional;
    }
}
