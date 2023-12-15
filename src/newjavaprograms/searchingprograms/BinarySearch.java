package newjavaprograms.searchingprograms;

import java.util.Arrays;

public class BinarySearch {
    public static void main(String[] args) {
        BinarySearch object1 = new BinarySearch();
        int[] numbers = {0,1,2,3,4,5,6,7,8,9,10};
        int search=10;
        if(object1.contains(numbers,0, numbers.length-1, search)){
            System.out.println(search + " is present in the array");
        }else{
            System.out.println(search + " is not present in the array");
        }
    }

    public boolean contains(int[] array,int startIndex, int endIndex, int searchValue){

        int midddleIndex = (endIndex-startIndex)/2 + startIndex;
        if(searchValue == array[midddleIndex]){
            return true;
        }
        if(startIndex == endIndex){
            return false;
        }
        if(searchValue > array[midddleIndex]){
            return contains(array, midddleIndex+1, endIndex, searchValue);
        }
        if(searchValue < array[midddleIndex]){
            return contains(array, startIndex, midddleIndex-1, searchValue);
        }
        return false;
    }
}
