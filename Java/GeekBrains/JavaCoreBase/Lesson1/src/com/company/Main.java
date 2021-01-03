package com.company;

public class Main {
        public static void main(String[] args) {
            // 1 и 2 задача
            byte a = 0;             // целые числа, 1 байт,диапазон допустимых значений от -128 до 127
            short b = 1;            // целые числа, 2 байта, диапазон допустимых значений от -32768 до 32767
            int c = 2000;              // целые числа, 4 байта, диапазон допустимых значений от -2147483648 до 2147483647
            long d = 3;             // целые числа, 8 байтов, диапазон допустимых значений от -9223372036854775808 до 9223372036854775807
            float e = 4;            // вещественные числа, 4 байта, диапазон допустимых значений от ~1,4*10^(-45) до ~3,4*10^(38)
            double f = 5;           // вещественные числа, 8 байтов, диапазон допустимых значений от ~4,9*10^(-324)  до ~1,8*10^(308)
            char g = 6;             // символ Unicode, 2 байта
            boolean h = true;       // значение истина/ложь, 1 байт

            System.out.println(calculation(c,c,c,c));
            System.out.println(comparisonTwoNumber(a,b));
            comparisonConsolExit(d);
            System.out.println(comparisonOneNumber(d));

            String name = "Колючка";
            consolExit(name);
            leapYear (c);
        }
        // 3 задача
        private static int calculation (int a,int b,int c,int d ) {
            return  (a * (b + (c / d)));
        }
        // 4 задача
        private static boolean comparisonTwoNumber (byte a, short b){
            return (a+b) > 10 && (a+b) < 20;
        }
        // 5 задача
        private static void comparisonConsolExit (long d){
            if (d>=0) System.out.println("Положительное число");
            else System.out.println("Отрицательное число");
        }
        // 6 задача
        private static boolean comparisonOneNumber (long d) {
            return d < 0;
        }
        // 7 задача
        private static void consolExit(String name){
            System.out.println("Привет, "+name+"!");
        }
        // 8 задача
        private static void leapYear (int year){
            if ((year % 4 == 0  && year % 100 != 0 ) || year % 400 == 0)
                System.out.println("Год високосный");
            else  System.out.println("Год обычный");
        }
    }