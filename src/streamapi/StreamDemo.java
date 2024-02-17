package streamapi;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    static List<Integer> numbers = Arrays.asList(1,2,3,4,5);

    public static void main(String[] args) {
        /*First we'll see some examples of external/active iterator on a list.
        These are iterators that are responsible for iterating over the elements, and making sure that this iteration
        takes into account the total number of records, whether more records exist to be iterated.*/
        externalIteratorExamples();

        /*
        Now we move onto internal/passive iterator on a list.
        Internal Iterators manage the iterations in the background.
        This leaves the programmer to just declaratively code what is meant to be done
        with the elements of the Collection, rather than managing the iteration and
         making sure that all the elements are processed one-by-one.
        */
        internalIteratorExamples();


    }

    public static void externalIteratorExamples(){
        System.out.println("using for loop");
        for(int i=0; i<numbers.size(); i++){
            System.out.println(i);
        }

        System.out.println("using iterator");
        Iterator<Integer> values = numbers.iterator();
        while(values.hasNext()){
            System.out.println(values.next());
        }

        System.out.println("using enhanced for");
        for(Integer i : numbers){
            System.out.println(i);
        }
    }

    public static void internalIteratorExamples(){
        System.out.println("using for each");
        numbers.forEach(i -> System.out.println(i));

        System.out.println("using call by method reference in for each");
        numbers.forEach(System.out :: println);

        System.out.println("using stream");
        numbers.stream().forEach(System.out::println);
        System.out.println(
            numbers.stream().filter(i -> {
//                System.out.println(i);
//                return true;
                return i>3;
            }).findFirst().orElse(0)
        );
        List<Integer> greaterThanThree = numbers.stream().filter(i -> i>3).collect(Collectors.toList());
        System.out.println("Greater than three");
        for (Integer i : greaterThanThree) {
            System.out.println(i);
        }
    }

}
