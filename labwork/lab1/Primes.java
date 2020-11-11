package com.labwork.lab1;
import java.util.ArrayList;

public class Primes {

    public static void main(String[] args) {
        //Нахождение простых чисел меньше 100
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=2; i<100;i++){
            if (isPrime(i)) list.add(i);
        }
        System.out.println(list.toString());

    }
    public static boolean isPrime(int x){
        //Проверка на просто число
        for (int i=2;i<=Math.sqrt(x);i++){
            if (x%i==0) return false;
        }
        return true;
    }
}