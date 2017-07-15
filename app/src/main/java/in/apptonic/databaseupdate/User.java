package in.apptonic.databaseupdate;

/**
 * Created by lalitkumarsonawane on 15/07/17.
 */

public class User {
    String name;
    String surname;

    public User(){}

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
