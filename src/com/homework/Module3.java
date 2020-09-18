package com.homework;

import java.util.Scanner;

public class Module3 {
    public static void main() {
        System.out.println("Input number a task: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int a,b,c;
        switch(task) {
            case 1 -> {
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();
                System.out.println(Task1(a,b,c));
            }
            case 2 -> {}
            case 3 -> {}
            case 4 -> {}
            case 5 -> {}
            case 6 -> {}
            case 7 -> {}
            case 8 -> {}
            case 9 -> {}
            case 10 -> {}

        }

    }
    public static int Task1(int a,int b, int c){
        float D = b^2-4*a*c;
        if (D>0){
            return 2;
        }
        else if (D == 0){
            return 1;
        }
        else {
            return 0;
        }
    }
}
