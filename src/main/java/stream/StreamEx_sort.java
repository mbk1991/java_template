package main.java.stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class StreamEx_sort {
    public static void main(String[] args) {
        Stream<Student> studentStream = Stream.of(
                new Student("A",3,100),
                new Student("B",3,99),
                new Student("C",1,54),
                new Student("D",1,87),
                new Student("E",2,96),
                new Student("F",2,30)
        );

//        studentStream.sorted(Comparator.comparing(Student::getBan, Comparator.reverseOrder()).thenComparing(Student::getName)).forEach(System.out::println);
//        studentStream.sorted().forEach(System.out::println);




    }

}

class Student implements Comparable<Student>{

    private String name;
    private int ban;
    private int totalScore;

    Student(String name, int ban, int totalScore){
        this.name = name;
        this.ban = ban;
        this.totalScore = totalScore;
    }

    public String toString(){
        return String.format("[%s, %d, %d]", name, ban, totalScore);
    }

    String getName(){
        return name;
    }
    int getBan(){
        return ban;
    }
    int totalScore(){
        return totalScore;
    }

    @Override
    public int compareTo(Student s) {
        return s.totalScore - this.totalScore;
    }
}
