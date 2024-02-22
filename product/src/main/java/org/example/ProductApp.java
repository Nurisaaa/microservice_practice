package org.example;

import java.util.HashMap;
import java.util.Map;

public class ProductApp {
    public static void main( String[] args ) {


    }

    public static boolean isPalindrome(int x) {
        if (x<0)
            return false;
        int copyNumber = 0;
        int counter = x;
        while(counter != 0){
            copyNumber = copyNumber * 10 + counter%10;
            counter = counter /10;
        }
        return copyNumber  == x;
    }

    public static int[] bubbleSort(int[] massive){
        return new int[7];
    }
}
