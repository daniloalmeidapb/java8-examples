package br.com.k19.java8.cap3;

// functional interface
public class Cap3 {
    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println(i);
            }
        }).start();

        Validator<String> validatorCEP = value -> value.matches("[0-9]{5}-[0-9]{3}");

        System.out.println(validatorCEP.validate("58057-590"));
    }
}

@FunctionalInterface
interface Validator<T> {
    boolean validate(T t);
}
