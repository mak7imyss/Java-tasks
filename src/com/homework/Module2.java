package com.homework;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Module2 {
    public static void main() {

        System.out.print("Input number a task: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        String str, str1;
        int a;
        switch (task) {
            case 1 -> {
                System.out.print("Введите через пробел слово и число повторений символов:");
                str = sc.next();
                a = sc.nextInt();
                for (String value : Task1(str, a)) {
                    System.out.print(value);
                }
            }
            case 2 -> {
                System.out.print("Введите через пробел массив чисел: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task2(str));
            }
            case 3 -> {
                System.out.print("Введите через пробел массив чисел: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task3(str));
            }
            case 4 -> {
                System.out.print("Введите через пробел массив чисел: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task4(str));
            }
            case 5 -> {
                System.out.print("Введите число: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task5(str));
            }
            case 6 -> {
                System.out.print("Введите число: ");
                a = sc.nextInt();
                System.out.println(Task6(a));
            }
            case 7 -> {
                System.out.print("Введите 5 чисел: ");
                sc.nextLine();
                str = sc.nextLine();
                System.out.println(Task7(str));
            }
            case 8 -> {
                sc.nextLine();
                System.out.print("Введите через пробел пару слов: ");
                str = sc.next();
                str1 = sc.next();
                System.out.println(Task8(str, str1));
            }
            case 9 -> {
                // Немного изменил задание, сделав одну функцию, которая возвращает название требуемой функции из задания, но суть та же
                System.out.print("Введите через пробел слово и префикс(суффикс): ");
                sc.nextLine();
                str = sc.next();
                str1 = sc.next();
                System.out.println(Task9(str,str1));
            }
            case 10 -> {
                System.out.print("Введите номер шага: ");
                a = sc.nextInt();
                System.out.println(Task10(a));
            }
        }

    }
    public static String[] Task1(String str, int a) {
        String[] list = str.split("");
        String[] answer = new String[str.length()*a];
        for (int i=0;i<str.length()*a;i++){
            answer[i] = list[i/a];

        }
        //можно было проще, просто вывести элементы массива по порядку, но мне захотелось хранить значения для выхода
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
    public static int Task5(String str){
        int index = str.indexOf(".");
        if (index!=-1){
            return Integer.parseInt(str.substring(index+1,index+2));
        }
        else{
            return 0;
        }
    }
    public static int Task6(int a){
        int[] f = new int[Math.abs(a)+1];
        f[0] = 0;
        if (a!=0) f[1] = 1;
        for (int i = 2; i <= Math.abs(a); ++i) {
            f[i] = f[i - 1] + f[i - 2];
            }
        if (a<0) f[Math.abs(a)]= (int) (Math.pow(-1,(a+1))*f[Math.abs(a)]);
        //условие не дает полного понимая что должно получиться, числа Фибоначчи считаеются с 0, который принимается за 0 порядок и 3 число будет 2 (0{0} 1{1} 1{2} [2]{3} 3{4} 5 8 ...)
        //https://ru.wikipedia.org/wiki/%D0%A7%D0%B8%D1%81%D0%BB%D0%B0_%D0%A4%D0%B8%D0%B1%D0%BE%D0%BD%D0%B0%D1%87%D1%87%D0%B8
        return f[Math.abs(a)];
    }
    public static boolean Task7(String str) {
        return str.length()<=5 && str.matches("[-+]?\\d+");
    }
    public static boolean Task8(String str, String str1){
        return (str.length()==0 && str1.length()==0) || (str.charAt(0)==str1.charAt(str1.length()-1)) && (str.charAt(str.length()-1)==str1.charAt(0));
    }
    public static String Task9(String str, String str1){
        String[] word = str1.split("-");
        if (str1.charAt(0)== '-'){
            String r = ".*"+word[1]+"$";
            if (Pattern.matches(r,str)){
                return "Suffix true";
            }
            else {
                return "Suffix false";
            }
        }
        else if (str1.charAt(str1.length()-1)=='-'){
            String r = "^"+word[0]+".*";
            if (Pattern.matches(r,str)){
                return "Prefix true";
            }
            else {
                return "Prefix false";
            }
        }
        return "N/a";
    }
    public static int Task10(int a){
        if (a%2!=0){
            return a + 2;
        }
        else if (a<0){
            return 0;
        }
        else{
            return a;
        }
    }
}
