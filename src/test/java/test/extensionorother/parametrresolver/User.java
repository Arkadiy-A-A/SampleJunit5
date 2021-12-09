package test.extensionorother.parametrresolver;

public class User {
    String FIO;
    String type;

    public User(String FIO, String type) {
        this.FIO = FIO;
        this.type = type;
    }

    @Override
    public String toString() {
        return "User{" +
                "FIO='" + FIO + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
