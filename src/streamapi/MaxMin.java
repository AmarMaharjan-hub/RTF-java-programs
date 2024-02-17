package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MaxMin {
    //Java program to find the maximum and minimum values in a list of integers using streams.

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23,23,43,5,2,23,56,4,7,42,3,234,32,234,5,2,3,32,243,2);

        System.out.println("List of numbers : " + numbers);

        int max = numbers.stream().reduce(Math::max).orElse(0);
//        int max = numbers.stream().max(Integer::compare).orElse(0);

        int min = numbers.stream().reduce(Math::min).orElse(0);
//        int min = numbers.stream().min(Integer::compare).orElse(0);

        System.out.println("Maximum value of the list is: " + max);
        System.out.println("Minimum value of the list is: " + min);

    }
}
