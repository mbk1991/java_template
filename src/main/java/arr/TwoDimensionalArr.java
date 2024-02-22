package main.java.arr;

import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class TwoDimensionalArr {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int currX = 0;
        int currY = 0;
        int d = 0;

        int [][] arr = makeRandomSquareArr(10);

        printArr(arr);
        while(true){
            String input = sc.next();
//            int input = System.in.read();
            System.out.println(input);

            if(input.equals("exit")){
                System.out.println("exit!");
                break;
            }

            if(input.equals("w")){ //상
                if(currY == 0) continue;
                currX = currX + dx[0];
                currY = currY + dy[0];
                printArr(arr,currX,currY);
            }
            if(input.equals("s")){ //하
                if(currY == arr.length-1) continue;
                currX = currX + dx[1];
                currY = currY + dy[1];
                printArr(arr,currX,currY);
            }
            if(input.equals("a")){ //좌
                if(currX == 0) continue;
                currX = currX + dx[2];
                currY = currY + dy[2];
                printArr(arr,currX,currY);
            }
            if(input.equals("d")){ //우
                if(currX == arr[0].length-1) continue;
                currX = currX + dx[3];
                currY = currY + dy[3];
                printArr(arr,currX,currY);
            }
        }
    }

    public static int[][] makeRandomSquareArr(int n){
        int[][] arr = new int[n][n];
        Random rd = new Random();
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                arr[i][j] = rd.nextInt(2);
            }
        }
        return arr;
    }

    public static void printArr(int[][] arr){
        System.out.println("*--".repeat(arr.length));
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println("*--".repeat(arr.length));
    }

    static void printArr(int[][] arr, int currX, int currY){
        System.out.println("*--".repeat(arr.length));
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[0].length; j++){
                if(i == currY && j == currX) System.out.print("(");
                System.out.print(arr[i][j] + "\t");
                if(i == currY && j == currX) System.out.print(")");
            }
            System.out.println();
        }
        System.out.println("*--".repeat(arr.length));
    }

    static int printPoint(int[][] arr, int x, int y){
        return arr[y][x];
    }
}
