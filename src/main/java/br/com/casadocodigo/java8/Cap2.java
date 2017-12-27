package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.List;

// lambda
class Cap2 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

        // java before 8
        for (User user : users) {
            System.out.println(user.getName());
        }

        System.out.println();

        // examples java 8 lambda
        users.forEach(user -> System.out.println(user.getName()));
        users.forEach(user -> user.becomeModerator());
    }
}
