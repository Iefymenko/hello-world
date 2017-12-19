package com.efimenko.annotation;

import java.lang.reflect.Field;
import java.util.Random;

public class ReflectionTest {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Zombie zombie = new Zombie();
        zombie.kills = 10;
        zombie.name = "Oleg";
        zombie.speed = 25;

        System.out.println(zombie);
        service(zombie);
        System.out.println(zombie);
    }

    static void service(Object obj) throws IllegalAccessException {
        Random random = new Random();

        Class clazz = obj.getClass();
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            Joker annotation = field.getAnnotation(Joker.class);
            if (annotation != null) {
                int max = annotation.max();
                int generatedValue = random.nextInt(max);
                Object currentValue = field.get(obj);
                if (currentValue instanceof Double) {
                    Double value = (Double) currentValue;
                    field.set(obj, value * generatedValue);
                } else if (currentValue instanceof Integer) {
                    Integer value = (Integer) currentValue;
                    field.set(obj, value * generatedValue);
                }
            }
        }

    }
}