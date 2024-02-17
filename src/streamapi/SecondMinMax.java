package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SecondMinMax {
    //Java program to find the second smallest and largest elements in a list of integers using streams

    public static void main(String[] args) {
        List< Integer > nums = Arrays.asList(1, 17, 54, 14, 14, 33, 45, -11);

        System.out.println("List of numbers: " + nums);

        int secondMax = nums.stream()
                .filter(i -> i < nums.stream()
                        .max(Integer::compare)
                        .orElse(0))
                .max(Integer::compare)
                .orElse(0);

//        int secondMax = nums.stream()
//                .distinct()
//                .sorted()
//                .skip(1)
//                .findFirst()
//                .orElse(0);

        int secondMin = nums.stream()
                .filter(i -> i > nums.stream()
                        .min(Integer::compare)
                        .orElse(0))
                .min(Integer::compare)
                .orElse(0);

//        int secondMin = nums.stream()
//                .distinct()
//                .sorted(Comparator.reverseOrder())
//                .skip(1)
//                .findFirst()
//                .orElse(0);

        System.out.println("Second max value in list : " + secondMax);

        System.out.println("Second min value in list : " + secondMin);
    }
}
