package com.unittesting;

public class Factorial {

    public int getResult(int number) {
        if (number == 1) {
            return number;
        } else {
            return number * getResult(number - 1);
        }
    }
    
}
