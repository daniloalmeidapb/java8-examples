package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// more operations with streams
public class Cap8 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

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

        // sum all points
        int total = users.stream()
                .mapToInt(User::getPoints)
                .sum();
        System.out.println(total);

        // multiply all points
        int multiply = users.stream()
                .mapToInt(User::getPoints)
                .reduce(1, (a, b) -> a * b);
        System.out.println(multiply);

        // return true if exist any moderator
        boolean anyModerator = users.stream()
                .anyMatch(User::isModerator);
        System.out.println(anyModerator);

        boolean allModerator = users.stream()
                .allMatch(User::isModerator);
        System.out.println(allModerator);

        boolean noneModerator = users.stream()
                .noneMatch(User::isModerator);
        System.out.println(noneModerator);

        // operations short circuit
        Random random = new Random();
        List<Integer> list = IntStream
                .generate(() -> random.nextInt())
                .limit(100) // short circuit
                .boxed()
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        IntStream.generate(new Fibonacci())
                .limit(10) // short circuit
                .forEach(System.out::println);

        int moreThan100 = IntStream
                .generate(new Fibonacci())
                .filter(f -> f > 100)
                .findFirst() // short circuit
                .getAsInt();
        System.out.println("More than 100: " + moreThan100);

        // flat map

    }
}

class Fibonacci implements IntSupplier {
    private int previous = 0;
    private int next = 1;

    @Override
    public int getAsInt() {
        next = next + previous;
        previous = next - previous;
        return previous;
    }
}
