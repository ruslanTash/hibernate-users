import java.util.ArrayList;

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

        User user1 = new User("Ivan", "NeDurak", "1234");
        User user2 = new User("Alena", "PriMudraya", "3939");
        User user3 = new User("Koshey", "Immortal", "666666");

        userDAO.createUser(user1, new ArrayList<Functional>(funcionalDAO.getAllFunctional().subList(0, 2)));
        userDAO.createUser(user2, new ArrayList<Functional>(funcionalDAO.getAllFunctional().subList(2, 4)));
        userDAO.createUser(user3, new ArrayList<Functional>(funcionalDAO.getAllFunctional().subList(4, 6)));

//        Получать список пользователей из БД (без ролей);
        userDAO.getAllUsers().forEach(System.out::println);
//        Получать конкретного пользователя (с его ролями) из БД;
        System.out.println(userDAO.getUserById(1));
//        Получать список пользователей по конкретной роли;
        userDAO.getUserByFunc(f1).forEach(System.out::println);
//        Удалять пользователя в БД;
        userDAO.deleteUserById(user3);
//        Добавлять нового пользователя с ролями в БД;
        userDAO.createUser(new User("Koshey", "Immortal", "666666"), new ArrayList<Functional>(funcionalDAO.getAllFunctional().subList(4, 6)));
//        Редактировать существующего пользователя в БД.
        userDAO.updateUser(new User("Zmey", "Gorinich", "7777"), 3);

        userDAO.getAllUsers().forEach(System.out::println);
    }
}
