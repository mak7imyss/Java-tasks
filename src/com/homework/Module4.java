package com.homework;
import java.util.*;

public class Module4 {
    public static void main() {
        System.out.print("Введите номер задачи: ");
        Scanner sc = new Scanner(System.in);
        int task = sc.nextInt();
        int x,y;
        String str, str1;
        switch (task) {
            case 1 -> {
                System.out.print("Введите количествр слов: ");
                x = sc.nextInt();
                System.out.print("Введите количествр символов в строке: ");
                y = sc.nextInt();
                sc.nextLine();
                System.out.print("Введите строку: ");
                str = sc.nextLine();
                System.out.println(Task1(x,y,str));
            }
            case 2 -> {
                sc.nextLine();
                System.out.print("Введите беспорядочную очередь из скобок: ");
                str = sc.nextLine();
                System.out.println(Task2(str));
            }
            case 3 -> {
                sc.nextLine();
                System.out.print("Введите строку (CamelCase или snake_case): ");
                str = sc.nextLine();
                System.out.println(Task3(str));
            }
            case 4 -> {
                sc.nextLine();
                System.out.print("Введите значения через пробел (Начало смены, конец смены, ставка, множитель): ");
                str = sc.nextLine();
                System.out.println(Task4(str));
            }
            case 5 -> {
                sc.nextLine();
                System.out.print("Введите значения через пробел (Вес [kilos/pounds] и Рост [meters/inches]): ");
                str = sc.nextLine();
                System.out.println(Task5(str));
            }
            case 6 -> {
                System.out.print("Введите число: ");
                x = sc.nextInt();
                System.out.println(Task6(x));

            }
            case 7 -> {
                sc.nextLine();
                System.out.print("Введите строку: ");
                str = sc.nextLine();
                System.out.println(Task7(str));
            }
            case 8 -> {
                sc.nextLine();
                System.out.print("Введите первую строку: ");
                str = sc.nextLine();
                System.out.print("Введите вторую строку: ");
                str1 = sc.nextLine();
                System.out.println(Task8(str,str1));
            }
            case 9 -> {
                sc.nextLine();
                System.out.print("Введите 1 число: ");
                str = sc.nextLine();
                System.out.print("Введите 2 число: ");
                str1 = sc.nextLine();
                System.out.println(Task9(str,str1));

            }
            case 10 -> {
                sc.nextLine();
                System.out.print("Введите строку: ");
                str = sc.nextLine();
                System.out.print("Введите символ конца строки: ");
                str1 = sc.nextLine();
                System.out.println(Task10(str,str1));
            }
        }
    }
    public static StringBuilder Task1(int x, int y, String str){
        String[] word = str.split("\s");
        StringBuilder page = new StringBuilder("");
        int s=0;
        for (String value: word){
            s+=value.length();
            if (s<=y){
                page.append(value);
                page.append("\s");
            }
            else{
                page.append("\n");
                page.append(value);
                page.append("\s");
                s=value.length();
            }
        }
        return page;
    }
    public static String Task2(String str){
        LinkedList<String> result = new LinkedList<>();
        String[] brackets = str.split("");
        StringBuilder group = new StringBuilder();
        int j=0,k=0;
        for (String bracket : brackets) {
            group.append(bracket);
            if (bracket.equals("(")) {
                j++;
            } else if (bracket.equals(")")) {
                k++;
                if (j == k) {
                    result.add(group.toString());
                    group.setLength(0);
                    j = k = 0;
                }
            }

        }
        return result.toString();
    }
    public static StringBuilder Task3(String str){
        StringBuilder line = new StringBuilder(str);
        String now;
        for (int i=0; i<line.length();i++){
            now = String.valueOf(line.toString().charAt(i));
            if (now.equals("_")){
                line.deleteCharAt(i);
                line.setCharAt(i, line.toString().toUpperCase().charAt(i));
            }
            else if (now.equals(now.toUpperCase())){
                line.insert(i,"_");
                line.setCharAt(i+1, line.toString().toLowerCase().charAt(i+1));
            }
        }
        return line;
    }
    public static float Task4(String str){
        String[] price = str.split(" ");
        Float[] hours = new Float[4];
        for (int i=0;i<4;i++){
            hours[i] = Float.parseFloat(price[i]);
        }
        float count=0;
        //Крайне тупая логика, но особо думать не хотелось.
        // Проверяем рамки и суммируем с часовой ставкой за конкретный час.

        if (hours[0] >= 9 && hours[1]<17){
            count = (hours[1]-hours[0])*hours[2];
        }
        else {
            if (Math.abs(hours[1]-hours[0])%1==0){
                for (float i=hours[0]; i<hours[1];i++){
                    if (i>=9 && i<17){
                        count+=hours[2];
                    }
                    else {
                        count+=hours[2]*hours[3];
                    }
                }
            }
            else {
                for (float i=hours[0]/1; i<hours[1]/1;i++){
                    if (i>=9 && i<17){
                        count+=hours[2];
                    }
                    else {
                        count+=hours[2]*hours[3];
                    }
                }
                if (hours[0]>=9 && hours[0]<17){
                    count+=hours[0]%1;
                }
                else {
                    count+=(hours[0]%1)*hours[3];
                }
                if (hours[1]>=9 && hours[1]<17){
                    count+=hours[1]%1;
                }
                else {
                    count+=(hours[1]%1)*hours[3];
                }
            }

            }

        return count;
    }
    public static String Task5(String str){
        String[] imb = str.split(" ");
        if (imb[1].equals("pounds")){
            imb[0]=String.valueOf(Float.parseFloat(imb[0])/2.20462);
        }
        if (imb[3].equals("inches")){
            imb[2]=String.valueOf(Float.parseFloat(imb[2])*0.0254);
        }
        float index = (float) (Float.parseFloat(imb[0])/Math.pow(Float.parseFloat(imb[2]),2));
        StringBuilder summary = new StringBuilder();
        if (index<18.5){
            return summary.append(String.format("%.1f", index)).append(" ").append("Недобор веса").toString();
        }
        else if (index>=25){
            return summary.append(String.format("%.1f", index)).append(" ").append("Избыточный вес").toString();
        }
        else {
            return summary.append(String.format("%.1f", index)).append(" ").append("Нормальный вес").toString();
        }
    }
    public static int Task6(int x){
        LinkedList<Integer> num = new LinkedList<>();
        int score = 0;
        while (!(String.valueOf(x).length()==1)) {
            int len = String.valueOf(x).length();
            for (int i = 0; i < len; i++) {
                num.add(x % 10);
                x /= 10;
            }
            int bugger = 1;
            for (Integer integer : num) {
                bugger *= integer;
            }
            x = bugger;
            score++;
            num.clear();
        }
        return score;
    }
    public static StringBuilder Task7(String str){
        StringBuilder line = new StringBuilder();
        LinkedHashMap<String, Integer> scorer = new LinkedHashMap<>();
        for (int i=0; i<str.length();i++){
            if (scorer.containsKey(String.valueOf(str.charAt(i)))){
                scorer.put(String.valueOf(str.charAt(i)),scorer.get(String.valueOf(str.charAt(i)))+1);
            }
            else{
                scorer.put(String.valueOf(str.charAt(i)),1);
            }
        }
        for (String key : scorer.keySet()){
            if (scorer.get(key)>1) {
                line.append(key).append("*").append(scorer.get(key));
            }
            else{
                line.append(key);
            }
        }
        return line;
    }
    public static boolean Task8(String str, String str1){
        Set<String> ru = new HashSet<>(Arrays.asList("а", "у", "о", "ы", "и", "э", "я", "ю", "е", "ё"));
        Set<String> en = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "y"));
        String[] line = str.toLowerCase().split(" ");
        String[] line1 = str1.toLowerCase().split(" ");
        //Массив символов последнего слова
        Set<String> end = new HashSet<>(Arrays.asList(line[line.length-1].split("")));
        Set<String> end1 = new HashSet<>(Arrays.asList(line1[line1.length-1].split("")));
        //Определяем язык и находим пересечение гласных
        if (end.toArray()[0].toString().matches("[а-я]") && end1.toArray()[0].toString().matches("[а-я]")){
            end.retainAll(ru);
            end1.retainAll(ru);
        }
        else if (end.toArray()[0].toString().matches("[a-z]") && end1.toArray()[0].toString().matches("[a-z]")){
            end.retainAll(en);
            end1.retainAll(en);
        }
        return end.equals(end1);
    }
    public static boolean Task9(String str, String str1){
        for (int i=0;i<10;i++) {
            if (str.matches(".*["+i+"]{3}.*") && str1.matches(".*["+i+"]{2}.*"))
                return true;
        }
        return false;
    }
    public static int Task10(String str, String str1){
        Set<Character> count = new HashSet<>();
        boolean run = false;
        int f=0;
        for (int i=0;i<str.length();i++){
            boolean equals = String.valueOf(str.charAt(i)).equals(str1);
            if (equals && f==0){
                run = true;
                f++;
            }
            else if (equals){
                run=false;
                f=0;
            }
            if (!count.toString().matches(String.valueOf(str.charAt(i))) && run && !str1.equals(String.valueOf(str.charAt(i)))){
                count.add(str.charAt(i));
            }
        }
        return count.size();
    }
}