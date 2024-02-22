package main.java.fullsearch.recursive;

public class RecursiveFullSearch {
    public static void main(String[] args){

//        System.out.println(power(2,10));

        String test = "012";



    }





    static int power(int n , int m){
        if(n == 0){
            return 1;
        }
        if(m == 0){
            return 1;
        }
        if(n == 1){
            return 1;
        }

        return power(n, m-1) * n;
    }




}
