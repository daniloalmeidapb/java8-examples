package br.com.casadocodigo.java8.util;

public class User {
    private String name;
    private int points;
    private boolean moderator;

    public User() {
    }

    public User(String name, int points) {
        this.name = name;
        this.points = points;
        this.moderator = false;
    }

    @Override
    public String toString() {
        return String.format("%s %s", "User:", getName());
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public boolean isModerator() {
        return moderator;
    }

    public void becomeModerator() {
        this.moderator = true;
    }
}
