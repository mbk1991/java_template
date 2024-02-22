package main.java.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx {

    public static void main(String[] args){

        int[] intArr = new int[]{1,2,3,4,5};
        Optional<Integer> any = Arrays.stream(intArr).boxed().sorted((a, b) -> b - a).min((a,b)->a-b);
        if(any.isPresent()){
            System.out.println(any.get());
        }else{
            System.out.println("null");
        }

    }
}
