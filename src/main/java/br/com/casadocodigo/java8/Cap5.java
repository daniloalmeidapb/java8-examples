package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.Comparator;
import java.util.List;

// order java 8
public class Cap5 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

        //users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        users.sort(Comparator.comparing(user -> user.getName()));
        users.forEach(user -> System.out.println(user.getName()));

        users.sort(Comparator.comparingInt(user -> user.getPoints()));
        users.forEach(user -> System.out.println(user.getPoints()));
    }
}
