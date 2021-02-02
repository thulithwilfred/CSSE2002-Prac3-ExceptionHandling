package com.UQ;

import jdk.swing.interop.SwingInterOpUtils;

import java.io.FileNotFoundException;
import java.util.Random;


public class PracFour {

    private static void makeException(ExceptionEnum type) {
        switch (type) {
            case NULL:
                throw new NullPointerException();

            case BOUNDS:
                throw new ArrayIndexOutOfBoundsException();

            case NONE:
                System.out.println("No Problems");
                break;

            case MISSING:
                try {
                    throw new FileNotFoundException();
                } catch (FileNotFoundException b) {
                    System.out.println("Caught File Not Found Exp");
                }
                break;

            case UNKNOWN:
                try {
                    throw new UnknownException();
                } catch (UnknownException k) {
                    System.out.println("Caught Unknown");
                }
                break;

            default:
                System.out.println("Peace");
        }
    }
    private static void f() {

        try {
            makeException(ExceptionEnum.NULL);
        } catch (NullPointerException e)  {
            System.out.println("Caught NullPointerExc");
        }

        try {
            makeException(ExceptionEnum.NONE);
        } catch (Exception a) {
            System.out.println("Nothing Here");
        }

        makeException(ExceptionEnum.MISSING);

        makeException(ExceptionEnum.UNKNOWN);

    }
    public static void main(String[] args) {
        f();


    Random random = new Random();
    for (int i = 0; i < 5; i++) {
        try {
            h(random);
        } catch (NullPointerException e) {
            System.out.println("Null Pointer");
            throw new NullPointerException();
        } catch (ArrayIndexOutOfBoundsException f) {
            System.out.println("Array Index Out of Bounds");
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    }

    private static void g(Random random) throws
            UnknownException, FileNotFoundException {
        int x = random.nextInt() % ExceptionEnum.values().length;
        int y = random.nextInt() % ExceptionEnum.values().length;
        try {
            makeException(ExceptionEnum.values()[x]);
            System.out.println("x = " + x);
            makeException(ExceptionEnum.values()[y]);
            System.out.println("y = " + y);
        } catch (NullPointerException |
                ArrayIndexOutOfBoundsException e) {
            System.out.println(e);
        }
    }

    private static void h(Random random) {
        try {
            g(random);
        } catch (NullPointerException | ArrayIndexOutOfBoundsException | FileNotFoundException | UnknownException e) {
            System.out.println(e);
        } finally {
            System.out.println("Reached here!");
        }

    }
}
