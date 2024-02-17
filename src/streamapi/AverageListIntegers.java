package streamapi;

import java.util.ArrayList;
import java.util.List;
import java.math.*;

public class AverageListIntegers {
    //Java Program to calculate the average of a list of integers using stream

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            numbers.add(i);
        }

//        double average =(double) numbers.stream().reduce(0, (i,j) -> i+j) / numbers.size();

        //this is better
        double average = numbers.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);

        System.out.println("Average : " + average);
    }
}
