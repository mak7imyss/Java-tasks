package com.homework;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Module3 {
    public static void main() {
        System.out.print("Введите номер задачи: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        double a,b,c;
        int x;
        String str,str1;
        switch(task) {
            case 1 -> {
                System.out.print("Введите a,b,c: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();
                System.out.println(Task1(a,b,c));
            }
            case 2 -> {
                sc.nextLine();
                System.out.print("Введите строку для опредления индекса второго вхождения \"zip\": ");
                str = sc.nextLine();
                System.out.println(Task2(str));
            }
            case 3 -> {
                System.out.print("Введите число для определения его совершенности: ");
                x = sc.nextInt();
                System.out.println(Task3(x));
            }
            case 4 -> {
                sc.nextLine();
                System.out.print("Введите строку для действий, смысл которых мне не понятен: ");
                str = sc.nextLine();
                System.out.println(Task4(str));
            }
            case 5 -> {
                sc.nextLine();
                System.out.print("Введите шестнадцатеричный код или что-то типа того: ");
                str = sc.nextLine();
                System.out.println(Task5(str));
            }
            case 6 -> {
                sc.nextLine();
                System.out.print("Введите первый массив чисел: ");
                str = sc.nextLine();
                System.out.print("Введите второй массив чисел: ");
                str1 = sc.nextLine();
                System.out.println(Task6(str,str1));
            }
            case 7 -> {
                System.out.print("Введите положительное целое число: ");
                x = sc.nextInt();
                System.out.println(Task7(x));
            }
            case 8 -> {
                System.out.print("Введите последователньость 0 и 1: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task8(str));
            }
            case 9 -> {
                System.out.print("Введите число: ");
                x = sc.nextInt();
                System.out.println(Task9(x));
            }
            case 10 -> {
                System.out.print("Введите три числа: ");
                a = sc.nextInt();
                b = sc.nextInt();
                c = sc.nextInt();
                System.out.println(Task10(a,b,c));
            }

        }

    }

    public static int Task1(double a,double b, double c) {
        double D = Math.pow(b,2) - 4 * a * c;
        //Обычная проверка на дискриминант
        if (D < 0 || (a==0 && b==0)) {
            return 0;
        }
        else if (D == 0 || (a==0 && b!=0)) {
            return 1;
        }
        else {
            return 2;
        }
    }
    public static int Task2(String str){
        //поиск осуществляется с подстроки следующией за первым вхождением
        return str.indexOf("zip", str.indexOf("zip")+1);
    }
    public static boolean Task3(int x){
        //Вычисляем множители, их сумму и сравниваем
        int s=0;
        for (int i=1; i<x;i++){
            if (x%i==0){
                s+=i;
            }
        }
        return s == x;
    }
    public static String Task4(String str){
        StringBuilder strbuff = new StringBuilder(str);
        if (str.length()<3){
            return "Несовместимо";
        }
        else if (str.charAt(0)==str.charAt(str.length()-1)){
            return "Два-это пара";
        }
        else {
            strbuff.setCharAt(0,str.charAt(str.length()-1));
            strbuff.setCharAt(str.length()-1,str.charAt(0));
        }
        return String.valueOf(strbuff);

    }
    public static boolean Task5(String str){
        return str.matches("^#[0-9a-fA-F]{6}");
    }
    public static boolean Task6(String str, String str1){
        //есть ошибка при заполнении первым символом пробела, т.к. тогда пустую строка принимается за элемент множества
        Set<String> set1 = new HashSet<String>(Arrays.asList(str.split(" ")));
        Set<String> set2 = new HashSet<String>(Arrays.asList(str1.split(" ")));
        return set1.size() == set2.size();
    }
    public static boolean Task7(int x){
        int left, right, len=0,s;
        int n=(int) Math.pow(x,2);
        //len=(Math.ceil(Math.log10(x)))
        while (n>0){
            n/=10;
            len++;
        }
        n=(int) Math.pow(x,2);
        if (n%2==0){
            //Однаковая длинна
            left = (int) (n/Math.pow(10,len/2));
            right = (int) (n%Math.pow(10,len/2));
        }
        else{
            //Левая часть короче или 0
            left = (int) (n/Math.pow(10,len/2+1));
            right = (int) (n%Math.pow(10,len/2+1));
        }
        s=right+left;
        return x==s;
    }
    public static String Task8(String str){
        String[] arr = str.split("");
        boolean flag=false;
        int s=0,m=0;
        String last="";
        for (String i: arr){
            if (!i.equals(last)){
                if (s>m){
                    m=s;
                    s=1;
                }
            }
            else{
                s++;
            }
            last=i;

        }
        return "0".repeat(m);
    }
    public static int Task9(int x){
        for (double i=2;i<=Math.sqrt(x);i++){
            if (x%i==0){
                i=1;
                x++;
            }
        }
        return x;
    }
    public static boolean Task10(double x, double y, double z){
        if (x>y && x>z){
            return Math.sqrt(Math.pow(y,2)+Math.pow(z,2))==x;
        }
        else if (y>x && y>z){
            return Math.sqrt(Math.pow(x,2)+Math.pow(z,2))==y;
        }
        else if (z>y && z>x){
            return Math.sqrt(Math.pow(x,2)+Math.pow(y,2))==z;
        }
        else {
            return false;
        }
    }
}
