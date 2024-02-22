package main.java.fullsearch.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DFS_EX implements Comparable{
    public static void main(String[] args){

        System.out.println("A-".compareTo("F-"));

        List<Integer> list = new ArrayList<>();

        int[] arr = list.stream().mapToInt(Integer::intValue).toArray();

        Arrays.stream(arr).boxed().sorted((a,b)->a-b).forEach(System.out::println);
    }


    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
