import java.util.List;

public interface FuncionalDAO {
    //    необходимо спроектировать систему так, чтобы оставить возможность для добавления ролей
    void createFuncional(Functional functional);
    List<Functional> getAllFunctional();
}
