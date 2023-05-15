import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {


        UserDAO userDAO = new UserDAOImpl();
        FuncionalDAO funcionalDAO = new FuncionalDAOImpl();

        Functional f1 = new Functional("Разработчик");
        Functional f2 = new Functional("Аналитик");
        Functional f3 = new Functional("Тестировщик");
        Functional f4 = new Functional("Менеджер");
        Functional f5 = new Functional("Дизайнер");
        Functional f6 = new Functional("По умолчанию");

        funcionalDAO.createFuncional(f1);
        funcionalDAO.createFuncional(f2);
        funcionalDAO.createFuncional(f3);
        funcionalDAO.createFuncional(f4);
        funcionalDAO.createFuncional(f5);
        funcionalDAO.createFuncional(f6);



        userDAO.createUser(new User(1, "Ivan", "NeDurak", "1234", LocalDateTime.now(), LocalDateTime.now(),  new ArrayList<Functional>(Arrays.asList(f1, f3))));
        userDAO.createUser(new User(2, "Alena", "PriMudraya", "3939", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<Functional>(Arrays.asList(f2, f4))));
        userDAO.createUser(new User(3, "Koshey", "Immortal", "666666",  LocalDateTime.now(), LocalDateTime.now(),new ArrayList<Functional>(Arrays.asList(f1, f3))));

//        Получать список пользователей из БД (без ролей);
        userDAO.getAllUsers().forEach(System.out::println);
//        Получать конкретного пользователя (с его ролями) из БД;
        System.out.println(userDAO.getUserById(1));
//        Получать список пользователей по конкретной роли;
        userDAO.getUserByFunc(f1).forEach(System.out::println);
//        Удалять пользователя в БД;
        userDAO.deleteUserById(3);
//        Добавлять нового пользователя с ролями в БД;
        userDAO.createUser(new User(3, "Koshey", "Immortal", "666666", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<Functional>(Arrays.asList(f1, f3))));
//        Редактировать существующего пользователя в БД.
        userDAO.updateUser(new User(3, "Zmey", "Gorinich", "7777", LocalDateTime.now(), LocalDateTime.now(), new ArrayList<Functional>(Arrays.asList(f1, f3))), 3);

        userDAO.getAllUsers().forEach(System.out::println);
    }
}
