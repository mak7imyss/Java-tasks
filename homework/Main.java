package com.homework;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите номер модуля: ");
        int module = sc.nextInt();
        switch (module)   {
            case 1 -> Module1.main();
            case 2 -> Module2.main();
            case 3 -> Module3.main();
            case 4 -> Module4.main();
            case 5 -> Module5.main();
        }
    }
}
