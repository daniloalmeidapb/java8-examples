package br.com.k19.java8.cap2;

import br.com.k19.java8.util.User;

import java.util.Arrays;
import java.util.List;

// lambda
class Cap2 {
    public static void main(String[] args) {
        User user1 = new User("Danilo Almeida", 150);
        User user2 = new User("Diogo Almeida", 120);
        User user3 = new User("Daniele Almeida", 190);

        List<User> users = Arrays.asList(user1, user2, user3);

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
