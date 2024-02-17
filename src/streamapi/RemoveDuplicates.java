package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    //Java program to remove duplicate elements from a list using streams

    public static void main(String[] args) {
        List< Integer > nums = Arrays.asList(10, 23, 22, 23, 24, 24, 33, 15, 26, 15);

        List<Integer> filtered = nums.stream().distinct().collect(Collectors.toList());

        System.out.println("Distinct numbers of the list : " + filtered);
    }

}
