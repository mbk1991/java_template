package main.java.recursive.hanoi;

import java.util.*;

public class Hanoi {
    HanoiBoard hanoiBoard;
    public static void main(String[] args){
        Hanoi hni = new Hanoi(5);
        System.out.println(hni.hanoiBoard.toString());
        hni.hanoi(hni.hanoiBoard.getSize(), 1, 3);
    }

    public Hanoi(int numberOfDisk){
        hanoiBoard = new HanoiBoard(numberOfDisk);
    }

    public void hanoi(int n, int from, int to){
        if(n==1){
            hanoiBoard.move(from,to);
            System.out.println(hanoiBoard.toString());

        }else{
            int empty = 6 - from - to;
            hanoi(n-1, from, empty);
            hanoi(1, from, to);
            hanoi(n-1,empty,to);
        }
    }


    class HanoiBoard{
        private int size;
        private Stack<Integer> column1 = new Stack<>();
        private Stack<Integer> column2 = new Stack<>();
        private Stack<Integer> column3 = new Stack<>();

        public HanoiBoard(int numberOfDisk){
            size = numberOfDisk;
            for(int i=numberOfDisk; i>=1; i--){
                column1.push(i);
            }
        }

        public int getSize(){
            return size;
        }

        public void move(int from, int to){
            if(!getColumn(to).empty()){
                if((int) getColumn(from).peek() <= (int) getColumn(to).peek()){
                   getColumn(to).push(getColumn(from).pop());
                }
            }else{
                getColumn(to).push(getColumn(from).pop());
            }
        }

        public Stack getColumn(int no){
            if(no == 1){
                return column1;
            }else if(no == 2){
                return column2;
            }else{
                return column3;
            }
        }

        @Override
        public String toString() {





            return "HanoiBoard{" +
                    "column1=" + column1 + "\t" +
                    ", column2=" + column2 + "\t" +
                    ", column3=" + column3 +
                    '}';
        }
    }
}
