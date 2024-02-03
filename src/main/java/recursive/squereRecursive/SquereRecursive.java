package main.java.recursive.squereRecursive;

import main.java.arr.TwoDimensionalArr;

public class SquereRecursive {

    public static void main(String[] args){
        int[][] arr = TwoDimensionalArr.makeRandomSquareArr(8);
        TwoDimensionalArr.printArr(arr);

        int[] answer = count2(0,0,arr.length,arr);

        System.out.println(answer[0]);
        System.out.println(answer[1]);
    }


    static int[] count2(int offsetX, int offsetY, int size, int[][] arr){
        for(int y=offsetY; y<offsetY+size; y++){
            for(int x=offsetX; x<offsetX+size; x++){
                if(arr[offsetY][offsetX] != arr[y][x]){
                    int[] tmpTwo = count2(offsetX, offsetY,size/2,arr);
                    int[] tmpOne = count2(offsetX+size/2, offsetY, size/2, arr);
                    int[] tmpThree = count2(offsetX, offsetY+size/2, size/2, arr);
                    int[] tmpFour = count2(offsetX+size/2, offsetY+size/2, size/2, arr);
                    return new int[]{tmpOne[0]+tmpTwo[0]+tmpThree[0]+tmpFour[0],tmpOne[1]+tmpTwo[1]+tmpThree[1]+tmpFour[1]};
                }
            }
        }

        if(arr[offsetY][offsetX] == 1){
            return new int[]{0,1};
        }
        return new int[]{1,0};
    }
}
