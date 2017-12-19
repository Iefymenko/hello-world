package com.efimenko.annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

/**
 * Created by DSK20 on 17.12.2015.
 */
public class VoodooPeople {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Voodoo voodoo = new Voodoo();
        voodoo.name = "dummy";

        System.out.println(voodoo);
        enrich(voodoo);
        System.out.println(voodoo);
        try {
            invoke(voodoo);
        }
        catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    static void enrich(Object obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        Field[] declaredField = clazz.getDeclaredFields();
        for (Field field : declaredField) {
            Generate generate = field.getAnnotation(Generate.class);
            if (generate != null) {
                int count = generate.count();
                Object currentValue = field.get(obj);
                if (currentValue instanceof String) {
                    String value = "";
                    StringBuilder stringBuilder = new StringBuilder();
                    for (int i = 0; i < count; i++) {
                        stringBuilder.append((char) (i + 65));
                    }
                    field.set(obj, stringBuilder.toString());

                }
            }
            Reverse reverse = field.getAnnotation(Reverse.class);
            if (reverse != null) {
                Object currentValue = field.get(obj);
                if (currentValue instanceof String) {
                    String value = new StringBuilder((String) currentValue).reverse().toString();
                    field.set(obj, value);

                }
            }

        }

    }

    static void invoke(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class clazz = obj.getClass();

        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            Invoke invokeAnnotation = method.getAnnotation(Invoke.class);
            if (invokeAnnotation != null) {
                method.invoke(obj);
            }
        }

    }
}
