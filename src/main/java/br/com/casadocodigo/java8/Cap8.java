package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserFactoryUtil;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// more operations with streams
public class Cap8 {
    public static void main(String[] args) {
        List<User> users = UserFactoryUtil.getUserList();

        users.stream()
                .filter(user -> user.getPoints() > 100)
                .sorted(Comparator.comparing(User::getName))
                .forEach(System.out::println);

        // peek
        users.stream()
                .filter(user -> user.getPoints() > 100)
                .peek(System.out::println)
                .findAny();

        users.stream()
                .sorted(Comparator.comparing(User::getName))
                .peek(System.out::println)
                .findAny();

        // reduction operation
        Optional<User> max = users.stream()
                .max(Comparator.comparing(User::getPoints));
        User maxPoint = max.get();
        System.out.println(maxPoint);

        User max1 = users.stream()
                .max(Comparator.comparing(User::getPoints))
                .get();
        System.out.println(max1);

        int total = users.stream()
                .mapToInt(User::getPoints)
                .sum();
        System.out.println(total);

        int multiply = users.stream()
                .mapToInt(User::getPoints)
                .reduce(1, (a, b) -> a * b);
        System.out.println(multiply);

        boolean anyModerator = users.stream()
                .anyMatch(User::isModerator);
        System.out.println(anyModerator);

        boolean allModerator = users.stream()
                .allMatch(User::isModerator);
        System.out.println(allModerator);

        boolean noneModerator = users.stream()
                .noneMatch(User::isModerator);
        System.out.println(noneModerator);
    }
}
