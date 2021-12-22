package com.click13.Mathe;

public class Prime {
    public static boolean isPrimeNumber(int number){
        for (int i=2;i<number;i++){
            if(number%i==0){
                return false;
            }
        }
        return true;
    }
    public static int[] isPrimeNumber(int[] array){
        int[] out = new int[array.length];

        for(int i=0;i<array.length;i++){
            if (isPrimeNumber(array[i])){
                out[i] = array[i];
            }
        }
        return out;
    }
}
