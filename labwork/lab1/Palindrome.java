package com.labwork.lab1;

public class Palindrome {
    public static void main(String[] args) {
        //Тестовое предложение
        String s= "java Palindrome madam racecar apple kayak song noon";
        System.out.println("Слово Реверс Палиндром");
        for (String word: s.split("\s")){
            //Вывод изначальгого слова, его реверс и провенрка на полиндром
            System.out.print(word+"\s"+reverseString(word)+"\s"+isPalindrome(word));
            System.out.println();
        }
    }
    public static String reverseString(String s){
        //Реверс слова путем добавления перебранных символов от конца к началу
        StringBuilder reverse = new StringBuilder();
        for (int i=s.length()-1;i>=0;i--){
            reverse.append(s.charAt(i));
        }
        return reverse.toString();
    }
    public static boolean isPalindrome(String s){
        //Проверка на полиндром путем сравнени 2 половин слова
        if (s.length()%2==0) return s.substring(0,(s.length()/2)).equals(reverseString(s.substring((s.length()/2),s.length())));
        else return s.substring(0,(s.length()/2)).equals(reverseString(s.substring((s.length()/2)+1,s.length())));
    }
}