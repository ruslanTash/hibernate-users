import lombok.*;

import javax.persistence.*;
import java.util.List;


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

    @ManyToMany(mappedBy = "functionalList")
    private List<User> userList;

    public Functional(String functional) {
        this.functional = functional;
    }

    @Override
    public String toString() {
        return "Functional{" +
                "functionalId=" + functionalId +
                ", functional='" + functional + '\'' +
                '}';
    }
}
