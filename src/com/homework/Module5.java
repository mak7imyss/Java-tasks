package com.homework;
import java.util.*;

import java.util.Scanner;

public class Module5 {
    public static void main() {
        System.out.print("Введите номер задачи: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int x, y;
        String str, str1;
        switch (task) {
            case 1 -> {
                sc.nextLine();
                System.out.print("Введите строку или \"зашифрованную строку\": ");
                str = sc.nextLine();
                System.out.println(Task1(str));
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
    public static String Task1(String str){
        String s;
        if (str.matches("[a-zA-Z]*")){
            //Кодируем
            s=String.valueOf((int)str.charAt(0));
            for (int i=1;i<str.length();i++){
                s+="\s"+((int)str.charAt(i)-(int)str.charAt(i-1));
            }
        }
        else{
            //декодируем
            int[] dec = Arrays.stream(str.split("\s")).mapToInt(Integer::parseInt).toArray();
            s=String.valueOf((char)dec[0]);
            for (int i=1;i<dec.length;i++){
                s+=String.valueOf((char) (dec[i]+(int)(s.charAt(i-1))));
            }
        }
        return s;
    }
}
