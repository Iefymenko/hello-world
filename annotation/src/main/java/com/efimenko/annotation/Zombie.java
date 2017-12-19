package com.efimenko.annotation;

/**
 * Created by DSK20 on 17.12.2015.
 */
public class Zombie {
    String name;
    @Joker(max = 5)
    double speed;
    @Joker(max = 200)
    int kills;

    @Override
    public String toString() {
        return "Zombie{" +
                "name='" + name + '\'' +
                ", speed=" + speed +
                ", kills=" + kills +
                '}';
    }
}
