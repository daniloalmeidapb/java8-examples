package br.com.k19.java8.cap5;

import br.com.k19.java8.util.User;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// order java 8
public class Cap5 {
    public static void main(String[] args) {
        User user1 = new User("Danilo Almeida", 150);
        User user2 = new User("Diogo Almeida", 120);
        User user3 = new User("Daniele Almeida", 190);
        List<User> users = Arrays.asList(user1, user2, user3);

        //users.sort((u1, u2) -> u1.getName().compareTo(u2.getName()));
        users.sort(Comparator.comparing(user -> user.getName()));
        users.forEach(user -> System.out.println(user.getName()));

        users.sort(Comparator.comparingInt(user -> user.getPoints()));
        users.forEach(user -> System.out.println(user.getPoints()));
    }
}
