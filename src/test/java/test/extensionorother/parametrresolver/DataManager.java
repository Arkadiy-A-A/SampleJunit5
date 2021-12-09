package test.extensionorother.parametrresolver;

import org.junit.jupiter.params.aggregator.ArgumentAccessException;

import java.util.ArrayList;
import java.util.List;

public class DataManager {


    private static DataManager INSTANCE = null;
    private List<User> userList = new ArrayList<>();


    private DataManager(){
        userList.add(new User("Иванов Иван Иванович", "ADMIN"));
        userList.add(new User("Петров Петя Петрович", "OPER"));
    }

    public static DataManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DataManager();
        }
        return INSTANCE;
    }


    public User getUserByType(String type) {
        return userList.stream()
                .filter(it -> it.type.equals(type))
                .findFirst()
                .orElseThrow(()-> new ArgumentAccessException("Заданный тип " + type + " некорректный"));
    }
}
