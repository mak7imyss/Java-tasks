package com.homework;
    import javax.swing.table.TableRowSorter;
    import java.util.Arrays;
    import java.util.HashSet;
    import java.util.Scanner;
    import java.util.Set;
    import java.util.regex.Pattern;

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
            case 7 -> {}
            case 8 -> {}
            case 9 -> {}
            case 10 -> {}

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
        Set<String> set1 = new HashSet<String>(Arrays.asList(str.split(" ")));
        System.out.println(set1);
        Set<String> set2 = new HashSet<String>(Arrays.asList(str1.split(" ")));
        System.out.println(set2);
        return set1.size() == set2.size();
    }

}
