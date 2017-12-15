package br.com.k19.java8.cap4;

import br.com.k19.java8.util.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

// default methods
public class Cap4 {
    public static void main(String[] args) {

        User user1 = new User("Danilo Almeida", 150);
        User user2 = new User("Diogo Almeida", 120);
        User user3 = new User("Daniele Almeida", 190);

        // interface Consumer
        List<User> users = Arrays.asList(user1, user2, user3);

        Consumer<User> showMessage = user -> System.out.println("before print names");

        Consumer<User> printName = user -> System.out.println(user.getName());

        users.forEach(showMessage.andThen(printName));

        // method removeIf
        List<User> userArrayList = new ArrayList<>();
        userArrayList.add(user1);
        userArrayList.add(user2);
        userArrayList.add(user3);

        userArrayList.removeIf(user -> user.getPoints() > 160);

        System.out.println("RemoveIf");
        userArrayList.forEach(user -> System.out.println(user.getName()));
    }
}
