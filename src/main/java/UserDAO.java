import java.util.List;

public interface UserDAO {
    //    Получать список пользователей из БД (без ролей);
    List<User> getAllUsers();

    //    Получать конкретного пользователя (с его ролями) из БД;
    User getUserById(int userId);

    //    Получать список пользователей по конкретной роли;
    List<User> getUserByFunc(Functional functional);

    //    Удалять пользователя в БД;
    void deleteUserById(int userId);

    //    Добавлять нового пользователя с ролями в БД;
    void createUser(User user);

    //    Редактировать существующего пользователя в БД.
    void updateUser(User user, int userId);
}
