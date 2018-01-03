package br.com.casadocodigo.java8;

import br.com.casadocodigo.java8.util.User;
import br.com.casadocodigo.java8.util.UserBuilder;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

// partitioning, grouping and paralleling
public class Cap9 {
    public static void main(String[] args) {
        List<User> users = UserBuilder.getUserList();

        Map<Integer, List<User>> point = users
                .stream()
                .collect(Collectors.groupingBy(User::getPoints));
        System.out.println("Grouping by point");
        System.out.println(point);

        Map<Boolean, List<User>> moderetor = users
                .stream()
                .collect(Collectors.partitioningBy(User::isModerator));
        System.out.println("Partitioning by moderator");
        System.out.println(moderetor);

        Long sum = LongStream.range(0, 1_000_000_000)
                .parallel()
                .filter(x -> x % 2 == 0)
                .sum();
        System.out.println("Paralleling");
        System.out.println(sum);
    }
}
