package com.homework;
import java.util.Scanner;

    public class Module1 {
        public static void main() {
            System.out.print("Input number a task: ");
            Scanner sc = new Scanner(System.in);
            int task = sc.nextInt();
            int x;
            int y;
            switch (task) {
                case 1 -> {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task1(x, y));
                }
                case 2 -> {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task2(x, y));
                }
                case 3 -> {
                    int chickens = sc.nextInt();
                    int cows = sc.nextInt();
                    int pigs = sc.nextInt();
                    System.out.println(Task3(chickens, cows, pigs));
                }
                case 4 -> {
                    int prob = sc.nextInt();
                    int prize = sc.nextInt();
                    int pay = sc.nextInt();
                    System.out.println(Task4(prob, prize, pay));
                }
                case 5 -> {
                    float a = (float) sc.nextInt();
                    float b = (float) sc.nextInt();
                    float c = (float) sc.nextInt();
                    System.out.println(Task5(a, b, c));
                }
                case 6 -> {
                    char ch = sc.next().charAt(0);
                    System.out.println(Task6(ch));
                }
                case 7 -> {
                    x = sc.nextInt();
                    System.out.println(Task7(x));
                }
                case 8 -> {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task8(x, y));
                }
                case 9 -> {
                    sc.nextLine();
                    String one = sc.nextLine();
                    System.out.println(Task9(one));
                }
                case 10 -> {
                    x = sc.nextInt();
                    y = sc.nextInt();
                    int z = sc.nextInt();
                    System.out.println(Task10(x, y, z));
                }
            }

        }
        public static int Task1(int x, int y) {
            return x % y;
        }
        public static float Task2(int x, int y) {
            return (float) ((x * y) * 0.5D);
        }
        public static int Task3(int x, int y, int z) {
            int legs_chickens = 2;
            int legs_cows = 4;
            int legs_pigs = 4;
            return legs_chickens * x + legs_cows * y + legs_pigs * z;
        }
        public static boolean Task4(int x, int y, int z) {
             return x * y > z;
        }
        public static String Task5(float a, float b, float c) {
            String operator;
            if (a - b == c) {
                operator = "-";
            } else if (a + b == c) {
                operator = "+";
            } else if (a * b == c) {
                operator = "*";
            } else if (a / b == c) {
                operator = "/";
            } else {
                operator = "none";
            }

            return operator;
        }
        public static int Task6(char ch) {
            return ch;
        }
        public static int Task7(int x) {
            int s = 0;

            for(int i = x; i > 0; --i) {
                s += i;
            }

            return s;
        }
        public static int Task8(int x, int y) {
            return x + y - 1;
        }
        public static int Task9(String one) {
            String[] list = one.split(" ");
            int s = 0;
            for (String value : list) {
                s += (int) Math.pow(Integer.parseInt(value), 3.0D);
            }

            return s;
        }
        public static boolean Task10(int a, int b, int c) {
            int s = a;

            for(int i = 0; i < b; ++i) {
                s += a;
                a = s;
            }

            boolean flag = false;
            if (s % c == 0) {
                flag = true;
            }

            return flag;
        }
}