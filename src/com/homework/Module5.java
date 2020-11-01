package com.homework;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.Scanner;


public class Module5 {
    public static void main() {
        System.out.print("Введите номер задачи: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int x;
        String str;
        switch (task) {
            case 1 -> {
                sc.nextLine();
                System.out.print("Введите строку или \"зашифрованную строку\": ");
                str = sc.nextLine();
                System.out.println(Task1(str));
            }
            case 2 -> {
                sc.nextLine();
                System.out.print("Введите имя фигуры [Rook Knight Bishop Queen King Pawn],\nначальную и конечную клетки через пробелы: ");
                str = sc.nextLine();
                System.out.println(Task2(str));
            }
            case 3 -> {
                sc.nextLine();
                System.out.print("Введите незавершенное слово и его конечную форму через пробел: ");
                str = sc.nextLine();
                System.out.println(Task3(str));
            }
            case 4 -> {
                sc.nextLine();
                System.out.print("Введите числа через пробел: ");
                str = sc.nextLine();
                System.out.println(Task4(str));
            }
            case 5 -> {
                sc.nextLine();
                System.out.print("Введите слова через пробел: ");
                str = sc.nextLine();
                System.out.println(Task5(str));
            }
            case 6 -> {
                sc.nextLine();
                System.out.print("Введите номер карты: ");
                str = sc.nextLine();
                System.out.println(Task6(str));
            }
            case 7 -> {
                System.out.print("Введите число от 0 до 999: ");
                x = sc.nextInt();
                System.out.println(Task7(x));
            }
            case 8 -> {sc.nextLine();
                System.out.print("Введите строку: ");
                str = sc.nextLine();
                System.out.println(Task8(str));}
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
            //Декодируем
            int[] dec = Arrays.stream(str.split("\s")).mapToInt(Integer::parseInt).toArray();
            s=String.valueOf((char)dec[0]);
            for (int i=1;i<dec.length;i++){
                s+=String.valueOf((char) (dec[i]+(int)(s.charAt(i-1))));
            }
        }
        return s;
    }
    public static boolean Task2(String str){
        String[] value = str.toLowerCase().split("\s");
        int x = ((int) (value[1].charAt(0)))-96;
        int y = Integer.parseInt(String.valueOf(value[1].charAt(1)));
        int X = ((int) (value[2].charAt(0)))-96;
        int Y = Integer.parseInt(String.valueOf(value[2].charAt(1)));
        int[] delta = {Math.abs(X-x),Math.abs(Y-y)};

        //Rook Knight Bishop Queen King Pawn
        if ((x>0 && x<9) && (y>0 && y<9)){
            switch (value[0]) {
                case "rook" -> {
                    if (delta[0] == 0 && delta[1] != 0 || delta[1] == 0 && delta[0] != 0) return true;
                    else return false;
                }
                case "knight" -> {
                    if (delta[0] == 3 && delta[1] == 1) return true;
                    else return false;
                }
                case "bishop" -> {
                    if (delta[0] == delta[1]) return true;
                    else return false;
                }
                case "queen" -> {
                    if ((delta[0] == 0 && delta[1] != 0 || delta[1] == 0 && delta[0] != 0) || delta[0] == delta[1])
                        return true;
                    else return false;
                }
                case "king" -> {
                    if (delta[0] == delta[1] && delta[0] == 1 || (delta[0] == 0 && delta[1] == 1 || delta[1] == 0 && delta[0] == 1))
                        return true;
                    else return false;
                }
                case "pawn" -> {
                    if (delta[0] == 1) return true;
                    else return false;
                }
            }
        }
        return false;
    }
    public static boolean Task3(String str){
        System.out.println("Pass");
        return  false;
    }
    public static int Task4(String str){
        int[] val = Arrays.stream(str.split("\s")).mapToInt(Integer::parseInt).toArray();
        int sum=0;
        for (int num:val){
            sum+=num;
        }
        LinkedList<Integer> num = new LinkedList<>();
        while (!(String.valueOf(sum).length()==1)) {
            int len = String.valueOf(sum).length();
            for (int i = 0; i < len; i++) {
                num.add(sum % 10);
                sum /= 10;
            }
            int bugger = 1;
            for (int integer : num) {
                bugger *= integer;
            }
            sum = bugger;
            num.clear();
        }
        return sum;
    }
    public static String Task5(String str){
        String[] worlds = str.split("\s");
        String answer=worlds[0];
        Set<String> ru = new HashSet<>(Arrays.asList("а", "у", "о", "ы", "и", "э", "я", "ю", "е", "ё"));
        Set<String> en = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "y"));
        String[] line = worlds[0].toLowerCase().split(" ");
        Set<String> end = new HashSet<>(Arrays.asList(line[line.length-1].split("")));
        for (int i=1;i< worlds.length;i++){
            //Массив символов слова
            Set<String> end1 = new HashSet<>(Arrays.asList(worlds[i].split("")));
            //Определяем язык и находим пересечение гласных
            if (end.toArray()[0].toString().matches("[а-я]") && end1.toArray()[0].toString().matches("[а-я]")){
                end.retainAll(ru);
                end1.retainAll(ru);
            }
            else if (end.toArray()[0].toString().matches("[a-z]") && end1.toArray()[0].toString().matches("[a-z]")){
                end.retainAll(en);
                end1.retainAll(en);
            }
            if (end.equals(end1)){
                answer+="\s"+worlds[i];
            }
        }
        return answer;
    }
    public static boolean Task6(String num){
        if (num.length()>=14 && num.length()<=19) {
            int num_control = Integer.parseInt(String.valueOf(num.charAt(num.length() - 1)));
            num = num.substring(0, num.length() - 1);
            String num_reverse = (new StringBuilder(num).reverse()).toString();
            String[] num_arr = num_reverse.split("");
//        String num_x2="";
            int num_sum = 0;
            for (int i = 0; i < num_arr.length; i++) {
                if ((i + 1) % 2 == 0) {
//               num_x2+=num_arr[i];
                    num_sum += Integer.parseInt(num_arr[i]);
                } else {
                    if ((Integer.parseInt(num_arr[i]) * 2) / 10 == 0) {
//                    num_x2+= String.valueOf(Integer.parseInt(num_arr[i])*2);
                        num_sum += Integer.parseInt(num_arr[i]) * 2;
                    } else {
//                    num_x2+= String.valueOf((Integer.parseInt(num_arr[i])*2/10)+(Integer.parseInt(num_arr[i])*2%10));
                        num_sum += (Integer.parseInt(num_arr[i]) * 2 / 10) + (Integer.parseInt(num_arr[i]) * 2 % 10);
                    }
                }
            }
            return num_control == 10 - num_sum % 10;
        }
        else return false;
    }
    public static String Task7(int x){
        int hundred = x/100;
        int ten = x/10%10;
        int unit = x%10;
        String num = "";
        String zero = "ноль";
        LinkedHashMap<Integer,String> ones = new LinkedHashMap<>() {{
            put(1, "один");
            put(2, "два");
            put(3, "три");
            put(4, "четыре");
            put(5, "пять");
            put(6, "шесть");
            put(7, "семь");
            put(8, "восемь");
            put(9, "девять");
        }};
        LinkedHashMap<Integer,String> tens = new LinkedHashMap<>() {{
            put(0, "десять");
            put(1, "одиннадцать");
            put(2, "двенадцать");
            put(3, "тринадцать");
            put(4, "четырнадцать");
            put(5, "пятнадцать");
            put(6, "шестнадцать");
            put(7, "семнадцать");
            put(8, "восемнадцать");
            put(9, "девятнадцать");
        }};
        LinkedHashMap<Integer,String> twenties = new LinkedHashMap<>() {{
            put(2, "двадцать");
            put(3, "тридцать");
            put(4, "сорок");
            put(5, "пятьдесят");
            put(6, "шестьдесят");
            put(7, "семьдесят");
            put(8, "восемьдесят");
            put(9, "девяносто");
        }};
        LinkedHashMap<Integer,String> hundreds = new LinkedHashMap<>() {{
            put(1, "сто");
            put(2, "двести");
            put(3, "триста");
            put(4, "четыреста");
            put(5, "пятьсот");
            put(6, "шестьсот");
            put(7, "семьсот");
            put(8, "восемьсот");
            put(9, "девятьсот");
        }};
        if (hundred>0){
            num+=hundreds.get(hundred)+"\s";
        }
        if (ten==1){
            num+=tens.get(unit)+"\s";
        }
        else if (ten>1){
            num+=twenties.get(ten)+"\s";
        }
        if (unit>0 && ten!=1){
            num+=ones.get(unit);
        }
        if (x==0){
            num=zero;
        }

        return num;
    }
    public static String Task8(String str){
//        Cейчас так, в будущем попробую расписать алгоритм без библиотек. Подписывайтесь на канал и следите за обновлениями)
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] hashBytes = messageDigest.digest(str.getBytes(StandardCharsets.UTF_8));
        BigInteger noHash = new BigInteger(1, hashBytes);
        String hashStr = noHash.toString(16);
        return hashStr;
    }
}
