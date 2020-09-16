package com.homework;
import java.util.Scanner;

import static com.homework.Module1.main;
import static com.homework.Module2.main;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number a module: ");
        int module = sc.nextInt();
        switch (module){
            case 1:
                Module1.main();
                break;
            case 2:
                Module2.main();
                break;
        };
    }
}
