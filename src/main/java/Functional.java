import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

    @ManyToMany(mappedBy = "functionalList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<User> userList;

    public Functional(String functional) {
        this.functional = functional;
    }
}
