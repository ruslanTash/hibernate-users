import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

@Entity
@Table(name = "user")
public class User {
//    У пользователя в таблице должны храниться имя, логин, пароль, дата и время создания профиля, а также дата и время модификации профиля и доступные роли.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String name;
    private String login;
    private String password;
    private LocalDateTime created;
    private LocalDateTime modified;
    @ManyToMany(cascade = CascadeType.PERSIST)
    private List<Functional> functionals;
}
