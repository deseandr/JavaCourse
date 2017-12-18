package com.courses;

public class Main {
    public static void main(String[] s) {
        ArrayVector def = new ArrayVector();
        def.vec(5.0);
        def.vec(2.0);
        def.vec(7.0);

        System.out.println("Вектор :");
        for (int i = 0; i < def.getSize(); i++) {
            System.out.print(def.getElement(i));
            System.out.println(" ");
        }


    }
}