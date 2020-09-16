package com.homework;
import java.util.Scanner;

    public class Module1 {
        public static void main() {
            Scanner sc = new Scanner(System.in);
            int task = sc.nextInt();
            int x;
            int y;
            switch(task) {
                case 1:
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task1(x, y));
                    break;
                case 2:
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task2(x, y));
                    break;
                case 3:
                    int chickens = sc.nextInt();
                    int cows = sc.nextInt();
                    int pigs = sc.nextInt();
                    System.out.println(Task3(chickens, cows, pigs));
                    break;
                case 4:
                    int prob = sc.nextInt();
                    int prize = sc.nextInt();
                    int pay = sc.nextInt();
                    System.out.println(Task4(prob, prize, pay));
                    break;
                case 5:
                    float a = (float)sc.nextInt();
                    float b = (float)sc.nextInt();
                    float c = (float)sc.nextInt();
                    System.out.println(Task5(a, b, c));
                    break;
                case 6:
                    char ch = sc.next().charAt(0);
                    System.out.println(Task6(ch));
                    break;
                case 7:
                    x = sc.nextInt();
                    System.out.println(Task7(x));
                    break;
                case 8:
                    x = sc.nextInt();
                    y = sc.nextInt();
                    System.out.println(Task8(x, y));
                    break;
                case 9:
                    sc.nextLine();
                    String one = sc.nextLine();
                    System.out.println(Task9(one));
                    break;
                case 10:
                    x = sc.nextInt();
                    y = sc.nextInt();
                    int z = sc.nextInt();
                    System.out.println(Task10(x, y, z));
            }

        }

        public static int Task1(int x, int y) {
            int f = x % y;
            return f;
        }

        public static float Task2(int x, int y) {
            float s = (float)((double)(x * y) * 0.5D);
            return s;
        }

        public static int Task3(int x, int y, int z) {
            int legs_chickens = 2;
            int legs_cows = 4;
            int legs_pigs = 4;
            int s = legs_chickens * x + legs_cows * y + legs_pigs * z;
            return s;
        }

        public static boolean Task4(int x, int y, int z) {
            boolean flag;
            if (x * y > z) {
                flag = true;
            } else {
                flag = false;
            }

            return flag;
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
            String[] var3 = list;
            int var4 = list.length;

            for(int var5 = 0; var5 < var4; ++var5) {
                String value = var3[var5];
                s = (int)((double)s + Math.pow((double)Integer.parseInt(value), 3.0D));
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