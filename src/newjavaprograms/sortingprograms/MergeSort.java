package newjavaprograms.sortingprograms;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        MergeSort object1 = new MergeSort();
//        int[] array = {21,43,65,23,5,8,32};// start 0, end 6, length 7
//        int[] array =  {10, 80, 30, 90, 40, 50, 70};
//        int[] array = {2,5,1,3,4,7,6,9,8};
//        int[] array = {9,8,7,6,5,4,3,2,1};
//        int[] array = {5,4,3,2,1,6,7,8,9};
//        int[] array = {6,7,8,9,5,4,3,2,1};
//        int[] array = {6,7,8,9,5,4,3,2,1,8};
        int[] array = {6,8,7,9,5,4,3,9,2,7};


        array = object1.mergeSort(array);

        System.out.println("\nMerged array: ");
        for(int element: array){
            System.out.print(element + ", ");
        }
    }

    public int[] mergeSort(int[] array){

        int[] leftBranch = null;
        int[] rightBranch = null;

        System.out.println("\nArray: " + Arrays.toString(array));

        //Breaking array down to leaf node.
        if(array.length != 1){
            leftBranch = new int[array.length/2];
            rightBranch = new int[array.length - array.length/2];
            System.arraycopy(array, 0, leftBranch, 0, leftBranch.length);
            System.arraycopy(array, leftBranch.length, rightBranch, 0, rightBranch.length);

            System.out.println("Branch: " + Arrays.toString(leftBranch) + "      " + Arrays.toString(rightBranch));

            leftBranch = mergeSort(leftBranch);
            rightBranch = mergeSort(rightBranch);
        }

        //merging array
        if(leftBranch != null && rightBranch != null){
            array = mergeArray(leftBranch, rightBranch);
        }

        return array;
    }

    public int[] mergeArray(int[] leftBranch, int[] rightBranch){

        System.out.println("\nReceived branch: " + Arrays.toString(leftBranch) + ", " + Arrays.toString(rightBranch));

        int[] mergedArray = new int[leftBranch.length + rightBranch.length];

        int leftIndex = 0;

        int rightIndex = 0;

        int mergedArrayIndex = 0;

        //Merge until one branch index reaches end
        while(leftIndex<leftBranch.length && rightIndex<rightBranch.length){

            if(leftBranch[leftIndex] <= rightBranch[rightIndex]){
                mergedArray[mergedArrayIndex] = leftBranch[leftIndex];
                leftIndex++;
            }else{
                mergedArray[mergedArrayIndex] = rightBranch[rightIndex];
                rightIndex++;
            }
            mergedArrayIndex++;

        }

        //if right branch finished first
        //Merge the left portion of left branch
        if(leftIndex<leftBranch.length) {
            System.arraycopy(leftBranch, leftIndex, mergedArray, mergedArrayIndex, mergedArray.length - mergedArrayIndex);
        }
        /*for(int i=leftIndex; i<leftBranch.length;i++){
            mergedArray[mergedArrayIndex] = leftBranch[i];
            mergedArrayIndex++;
        }*/

        //if left branch finished first
        //Merge the left portion of right branch
        if(rightIndex<rightBranch.length) {
            System.arraycopy(rightBranch, rightIndex, mergedArray, mergedArrayIndex, mergedArray.length - mergedArrayIndex);
        }
        /*for(int i=rightIndex; i<rightBranch.length; i++){
            mergedArray[mergedArrayIndex] = rightBranch[i];
            mergedArrayIndex++;
        }*/


        System.out.println("Merge: " + Arrays.toString(mergedArray));

        return mergedArray;
    }


}
