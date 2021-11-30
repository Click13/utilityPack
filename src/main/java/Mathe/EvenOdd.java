package Mathe;

public class EvenOdd {

    public static boolean isEven(int n){
        return (n % 2 == 0);
    }

    public static boolean isOdd(int n){
        return !isEven(n);
    }
}
