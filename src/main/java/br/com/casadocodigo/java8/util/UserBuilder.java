package br.com.casadocodigo.java8.util;

import java.util.Arrays;
import java.util.List;

public class UserBuilder {

    public static List<User> getUserList() {
        User[] user = new User[5];
        user[0] = new User("Danilo Almeida", 150, true);
        user[1] = new User("Diogo Almeida", 120, true);
        user[2] = new User("Daniele Almeida", 90);
        user[3] = new User("Ana Lucia", 120);
        user[4] = new User("Aldi Alves", 100);

        return Arrays.asList(user);
    }
}
