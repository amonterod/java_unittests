package com.unittesting;

public class Factorial {

    public int getResult(int number) {
        if (number < 0) {
            throw new NumberFormatException("Non negative numbers are allowed");
        }
        if (number == 1 || number == 0) {
            return 1;
        } else {
            return number * getResult(number - 1);
        }
    }

    public static void main(String[] args) {
        Factorial fac = new Factorial();
        System.out.println(fac.getResult(10));
    }
    
}
