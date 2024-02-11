package main.java.lamda;

import java.util.function.Predicate;

public class LamdaEx {

    public static void main(String[] args){

        int result = plus('9','4',c->Character.isDigit((char)c));
        System.out.println("result = " + result);
    }


    public static int plus(char a, char b, Predicate p){
        if (p.test(a) && p.test(b)) {
            return  (a-'0') + (b-'0');
        }
        return -1;
    }
}
