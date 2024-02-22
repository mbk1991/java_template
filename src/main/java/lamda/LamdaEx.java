package main.java.lamda;

import java.util.function.Predicate;

public class LamdaEx {

    public static void main(String[] args){

        int result = plus('9','4',c->Character.isDigit((char)c));
        System.out.println("result = " + result);


        MyFunctionalInterface mfi = ()->System.out.println("MyFunctionalInterface!!");

        mfi.test();
        mfi.test2();
        MyFunctionalInterface.test3();


    }


    public static int plus(char a, char b, Predicate p){
        if (p.test(a) && p.test(b)) {
            return  (a-'0') + (b-'0');
        }
        return -1;
    }
}

@FunctionalInterface
interface MyFunctionalInterface{
    void test();

    default void test2(){
        System.out.println("hi! I am default method!");
    }

    static void test3(){
        System.out.println("hi! I am static method!");
    }
}