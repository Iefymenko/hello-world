package com.efimenko.annotation;

/**
 * Created by DSK20 on 17.12.2015.
 */
public class Voodoo {
    @Reverse
    @Generate(count = 20)
    public String name;

    public String toString() {
        return name;
    }
    @Invoke
    public void Print() {
        System.out.println(this);
    }
}
