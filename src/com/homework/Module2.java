package com.homework;
import java.util.Arrays;
import java.util.Scanner;

public class Module2 {
    public static void main() {

        System.out.print("Input number a task: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        String str;
        int a;
        switch (task) {
            case 1 -> {
                str = sc.next();
                a = sc.nextInt();
                for (String value : Task1(str, a)) {
                    System.out.print(value);
                }
            }
            case 2 -> {
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task2(str));
            }
            case 3 -> {
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task3(str));
            }
            case 4 -> {
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task4(str));
            }
            case 5 -> {
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task5(str));
            }
            case 6 -> System.out.println();
            case 7 -> System.out.println();
            case 8 -> System.out.println();
            case 9 -> System.out.println();
            case 10 -> System.out.println();
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
    public static int Task2(String str){
        String[] list = str.split(" ");
        int[] answer = new int[list.length];
        for (int i=0;i<list.length;i++){
            answer[i] = Integer.parseInt(list[i]);
        }
        int max = answer[0];
        int min = answer[0];
        for(int i = 0; i != answer.length; i ++){
            if(answer[i] > max){
                max = answer[i];
            }
            if(answer[i] < min){
                min = answer[i];
            }
        }
        return max-min;
    }
    public static boolean Task3(String str){
        String[] list = str.split(" ");
        int[] answer = new int[list.length];
        int s=0;
        for (int i=0;i<list.length;i++){
            answer[i] = Integer.parseInt(list[i]);
            s += Integer.parseInt(list[i]);
        }
        return s % list.length==0;
    }
    public static String Task4(String str){
        String[] list = str.split(" ");
        int[] answer = new int[list.length];
        answer[0]=answer[0] = Integer.parseInt(list[0]);
        for (int i=1;i<list.length;i++){
            answer[i] = Integer.parseInt(list[i])+answer[i-1];
        }
        return Arrays.toString(answer);
    }
    public static float Task5(String str){
        float fl = Float.parseFloat(str);
        return fl%1%1;
    }

}
