package main.java.recursive.squereRecursive;

import main.java.arr.TwoDimensionalArr;

public class Solutiono_5_3_2 {
    private static class Count{
        public final int zero;
        public final int one;

        public Count(int zero, int one){
            this.zero = zero;
            this.one = one;
        }

        public Count add(Count other){
            return new Count(zero+other.zero, one+other.one);
        }
    }

    private static Count count(int offsetX, int offsetY, int size, int[][] arr){
        int h= size/2;
        for(int x = offsetX; x<offsetX+size; x++){
            for(int y = offsetY; y<offsetY+size; y++){
                if(arr[y][x]!= arr[offsetY][offsetX]){
                    return count(offsetX,offsetY,h,arr)
                            .add(count(offsetX+h, offsetY, h, arr))
                            .add(count(offsetX, offsetY+h,h,arr))
                            .add(count(offsetX+h,offsetY+h,h,arr));
                    }
                }
            }

        if(arr[offsetY][offsetX]==1){
            return new Count(0,1);
        }
        return new Count(1,0);
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


    public static void main(String[] args){

//        int[][] arr = TwoDimensionalArr.makeRandomSquareArr(32);

        int[][] arr = { {1,1,0,0,},
                        {1,1,0,0,},
                        {0,0,0,0,},
                        {0,0,0,0,} };

        TwoDimensionalArr.printArr(arr);

        Count cnt = count(0,0,arr.length,arr);
        System.out.println(cnt.zero);
        System.out.println(cnt.one);


        int[] answer = count2(0,0,arr.length,arr);

        System.out.println(answer[0]);
        System.out.println(answer[1]);


    }
}
