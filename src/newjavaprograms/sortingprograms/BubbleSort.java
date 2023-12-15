package newjavaprograms.sortingprograms;

public class BubbleSort {

    public int[] sort(int[] array){
        int length = array.length;
        for(int i=0; i<length-1;i++){
            for(int j=0; j<length-i-1; j++){
                if(array[j]>array[j+1]){
                    int temporary = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temporary;
                }
            }
        }

        return array;
    }

    public static void main(String[] args) {
        BubbleSort object1 = new BubbleSort();
        int[] array = {21,43,65,23,5,8,32};
        array = object1.sort(array);
        for(int element: array){
            System.out.println(element);
        }
    }
}
