package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.List;
import java.util.function.Consumer;

// default methods
public class Cap4 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

        // interface consumer
        Consumer<User> showMessage = user -> System.out.println("before print names");

        Consumer<User> printName = user -> System.out.println(user.getName());

        users.forEach(showMessage.andThen(printName));

        // method removeIf
        users.removeIf(user -> user.getPoints() > 160);

        System.out.println("RemoveIf");
        users.forEach(user -> System.out.println(user.getName()));
    }
}
