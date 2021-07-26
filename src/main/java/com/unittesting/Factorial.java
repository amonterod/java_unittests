package com.unittesting;

public class Factorial {

    public int getResult(int number) {
        if (number == 1) {
            return number;
        } else {
            return number * getResult(number - 1);
        }
    }

    public static void main(String[] args) {
        Factorial fac = new Factorial();
        System.out.println(fac.getResult(10));
    }
    
}
