package streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CountStrings {
    //Java program to count the number of strings in a list that start with specific letters using streams
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Hans", "Mako", "Haku", "Lily", "Jack", "Jim", "Michael");

        System.out.println("List of names: " + names);

        char starter = 'J';

        long count = names.stream().filter(i -> i.charAt(0) == starter).count();

        System.out.println("There are " + count + " names starting with letter " + starter + ".");
    }
}
