package main.java.jcf.collection.list;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ListEx {
    public static void main(String[] args){
        Set<Integer> s = new TreeSet<>((a,b)->b-a);
        s.addAll(List.of(3,1,2,3,4,4,3,2,5,12,3,2534));

        System.out.println(s.toString());
    }
}
