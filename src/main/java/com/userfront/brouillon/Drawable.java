package com.userfront.brouillon;

public interface Drawable {
    default void draw() {
        System.out.println("Drawing a drawable");
    }
}
