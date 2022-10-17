import java.util.ArrayList;

public class User extends Person{
    public User(String id, String name, String surname,  String country) {
        super(name, surname, id, country);
    }

    @Override
    public String getClassName() {
        return "User";
    }
}

