package main.java.recursive.memoization;

import java.util.Arrays;

public class Memoization {
        static int recursiveCnt = 0;
        //fibonacci 20
        //no memoization -> recursiveCnt = 21891
        // memoization -> recursiveCnt = 39
    public static void main(String[] args){

        long[] mem = new long[101];
        Arrays.fill(mem,-1);

        long startTime = System.currentTimeMillis();
        System.out.println("start ms: " + startTime);
        System.out.println(recursive(20,mem));
        long endTime = System.currentTimeMillis();
        System.out.println("end ms: " + endTime);
        System.out.println("diff: " + (endTime - startTime));

        System.out.println("recursiveCnt = " + recursiveCnt);

    }

    private static long recursive(int n,long[] mem){
        recursiveCnt++;

        if(n < 0 || 100 < n){
            return -1;
        }
        //exit condition
            if(n == 0 || n == 1){
                return n;
            }
        //memoization
            if(mem[n] != -1){
                return mem[n];
            }
        //recurrence relation
        return mem[n] = recursive(n-1, mem) + recursive(n-2, mem);
    }
}
