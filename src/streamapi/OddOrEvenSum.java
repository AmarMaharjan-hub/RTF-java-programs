package streamapi;

import java.util.Arrays;
import java.util.List;

public class OddOrEvenSum {
    //Java program to calculate the sum of all even, odd numbers in a list using streams.

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(23,23,43,5,2,23,56,4,7,42,3,234,32,234,5,2,3,32,243);

        System.out.println("List of numbers : " + numbers);

        int evenSum = numbers.stream().filter(i -> i%2 == 0).reduce(Integer::sum).orElse(0);

        int oddSum = numbers.stream().filter(i -> i%2 == 1).reduce(Integer::sum).orElse(0);

        System.out.println("Sum of even numbers of list is : " + evenSum);
        System.out.println("sum of odd numbers of list is : " + oddSum);
//        System.out.println(numbers.stream().reduce(Integer::sum));
    }
}
