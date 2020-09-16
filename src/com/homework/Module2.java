package com.homework;
import java.util.Arrays;
import java.util.Scanner;

public class Module2 {
    public static void main() {
        System.out.println();
        System.out.print("Input number a task: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        String str;
        int a;
        switch(task) {
            case 1:
                str = sc.next();
                a = sc.nextInt();
                for (String value:Task1(str,a)){
                    System.out.print(value);
                };
                break;
            case 2:
                System.out.println();
                break;
            case 3:
                System.out.println();
                break;
            case 4:
                System.out.println();
                break;
            case 5:
                System.out.println();
                break;
            case 6:
                System.out.println();
                break;
            case 7:
                System.out.println();
                break;
            case 8:
                System.out.println();
                break;
            case 9:
                System.out.println();
                break;
            case 10:
                System.out.println();
                break;
        }

    }
    public static String[] Task1(String str, int a) {
        String[] list = str.split("");
        String[] answer = new String[str.length()*a];
        for (int i=0;i<str.length()*a;i++){
            answer[i] = list[i/a];

        }
        //можно было проще, просто вывести жлементы массива по порядку, но мне захотелось хранить значения для выхода
        return answer;
    }
}
