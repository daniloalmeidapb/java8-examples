package br.com.casadocodigo.java8.util;

import java.util.Arrays;
import java.util.List;

public class UserFactoryUtil {

    public static List<User> getUserList() {
        User[] user = new User[3];
        user[0] = new User("Danilo Almeida", 150);
        user[1] = new User("Diogo Almeida", 120);
        user[2] = new User("Daniele Almeida", 190);

        return Arrays.asList(user);
    }
}
