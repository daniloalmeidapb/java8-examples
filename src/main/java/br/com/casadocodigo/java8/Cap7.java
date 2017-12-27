package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// streams and collectors
public class Cap7 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

        // become moderator the teen first users
        users.sort(Comparator.comparingInt(User::getPoints).reversed());
        users.subList(0, 1).forEach(User::becomeModerator);

        // become moderator users with more than hundred points
        users.stream()
                .filter(user -> user.getPoints() > 100)
                .forEach(User::becomeModerator);
        users.stream()
                .filter(User::isModerator)
                .forEach(System.out::println);

        // get list
        List<User> moreThan100 = new ArrayList<>();
        users.stream()
                .filter(user -> user.getPoints() > 100)
                .forEach(moreThan100::add);

        // get list with collector toList
        List<User> moreThan100List = users.stream()
                .filter(user -> user.getPoints() > 100)
                .collect(Collectors.toList());
        moreThan100List.forEach(System.out::println);

        // get list with collector toSet
        Set<User> moreThan100Set = users.stream()
                .filter(user -> user.getPoints() > 100)
                .collect(Collectors.toSet());
        moreThan100Set.forEach(System.out::println);

        // stream with map
        IntStream points = users.stream()
                .mapToInt(User::getPoints);
        points.forEach(System.out::println);

        // get max points
        int maximum = users.stream()
                .mapToInt(User::getPoints)
                .max()
                .getAsInt();
        System.out.println(maximum);

        // get average
        double average = users.stream()
                .mapToInt(User::getPoints)
                .average()
                .getAsDouble();
        System.out.println(average);

        // get average with orElse
        double average2 = users.stream()
                .mapToInt(User::getPoints)
                .average()
                .orElse(0.0);
        System.out.println(average2);

        // get user max points
        Optional<User> maxUser = users.stream()
                .max(Comparator.comparing(User::getPoints));
        System.out.println(maxUser.orElse(null));

        User maxUser1 = users.stream()
                .max(Comparator.comparing(User::getPoints))
                .orElse(null);
        System.out.println(maxUser1);

        Optional<String> maxName = users.stream()
                .max(Comparator.comparing(User::getPoints))
                .map(User::getName);
        System.out.println(maxName.orElse(null));

        String maxName1 = users.stream()
                .max(Comparator.comparing(User::getPoints))
                .map(User::getName)
                .orElse(null);
        System.out.println(maxName1);
    }
}
