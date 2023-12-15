package newjavaprograms.sortingprograms;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
//        int[] array =  {10, 80, 30, 90, 40, 50, 70};
//        int[] array = {2,5,1,3,4,7,6,9,8};
//        int[] array = {9,8,7,6,5,4,3,2,1};
//        int[] array = {5,4,3,2,1,6,7,8,9};
//        int[] array = {6,7,8,9,5,4,3,2,1};
//        int[] array = {6,7,8,9,5,4,3,2,1,8};
        int[] array = {6,8,7,9,5,4,3,9,2,7};

        QuickSort object1 = new QuickSort();
        array = object1.quickSort(array, 0, array.length-1, array[array.length-1]);
        for(int i : array){
            System.out.print(i + " ");
        }
    }

    public int[] quickSort(int[] array, int low,  int high, int pivot){

        int smallElementIndex = low-1;
        int temp = 0;

        for(int j=low; j<high; j++){

            if(array[j]>=pivot){
                continue;
            }
            if(array[j]<pivot){
                smallElementIndex++;
                temp = array[j];
                array[j] = array[smallElementIndex];
                array[smallElementIndex] = temp;
            }

        }
        System.out.println(Arrays.toString(array));
        temp = array[high];
        array[high] = array[smallElementIndex+1];
        array[smallElementIndex+1] = temp;

        //if smallest element found then don't go left
        if(smallElementIndex != low-1){
            //left sort
            array = quickSort(array,low,smallElementIndex,array[smallElementIndex]);
        }

        //if highest element found then don't go right
        if(high-1 != smallElementIndex) {
            //right sort
            array = quickSort(array, smallElementIndex + 2, high, array[high]);
        }

        return array;
    }
}
