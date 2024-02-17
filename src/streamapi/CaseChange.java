package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CaseChange {
    //Java program to convert a list of Srings to uppercase or lowercase using streams.

    public static void main(String[] args) {
        List<String> values = Arrays.asList("Hello", "World", "Aggregate", "Operations", "streams");

        //true -> uppercase
        //fase -> lowercase
        boolean flag = true;

        List<String> result = values.stream().map(i -> flag ? i.toUpperCase() : i.toLowerCase()).collect(Collectors.toList());

        System.out.println("Lists in " + (flag ? "uppercase" : "lowercase") + " : ");
        System.out.println(result);
    }
}
