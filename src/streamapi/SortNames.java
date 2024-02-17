package streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class SortNames {
    //Java program to sort a list of strings in alphabetical order, ascending and descending using streams

    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Hans", "Mako", "Haku", "Lily", "Jack", "Jim", "Michael");

        System.out.println("List of names : " + names);

        List<String> ascending = names.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

        List<String> descending = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        System.out.println("List in ascending order: " + ascending);

        System.out.println("List in descending order: " + descending);
    }
}
