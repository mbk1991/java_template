package main.java.jcf.collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CollectionEx {

    public static void main(String[] args){
        Collection<Integer> a = new ArrayList<>();
        Collection<Integer> b = new ArrayList<>(List.of(3,4,5,6,7));

        a.add(1);
        a.addAll(List.of(1,2,3,4,5));

        //교집합
        if(a.retainAll(b)){
            System.out.println(a.toString());
        }

        //차집합
        if(b.removeAll(a)){
            System.out.println(b.toString());
        }

        //합집합
        if(a.addAll(b)){
            System.out.println(a.toString());
        }

        if(a.isEmpty()){
            System.out.println("a가 비었음.");
        }else{
            System.out.println("a에 요소가 있음.");
        }

        if(a.containsAll(b)){
            System.out.println("a는 b를 포함");
        }else{
            System.out.println("a는 b를 포함하지 않음");
        }


        if(a.equals(b)){
            System.out.println("a와b가 일치");
        }else{
            System.out.println("a와b가 불일치");
        }

        int[] array = a.stream().mapToInt(i->(int)i).toArray();
        System.out.println(array.getClass());

    }
}
