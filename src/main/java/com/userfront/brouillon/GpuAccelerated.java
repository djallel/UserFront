package com.userfront.brouillon;

public interface GpuAccelerated extends Drawable {
    default void draw() {
        System.out.println("Drawing with GPU Aacceleration");
    }
}
