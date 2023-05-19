import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder


@Entity
@Table(name = "users")
public class User {
//    У пользователя в таблице должны храниться имя, логин, пароль, дата и время создания профиля, а также дата и время модификации профиля и доступные роли.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @NotNull
    private int userId;
    @Column
    @NotNull
    private String name;
    @Column
    @NotNull
    private String login;
    @Column
    @NotNull
    private String password;
    @Column(name = "data_creation")
    private LocalDateTime created = LocalDateTime.now();
    @Column(name = "data_modification")
    private LocalDateTime modified;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "Users_Functional",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "functional_id")}
    )
    private List<Functional> functionalList;

    public User(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", login='" + login + '\'' +
                ", functionalList=" + functionalList +
                '}';
    }
}
