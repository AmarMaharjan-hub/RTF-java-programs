package newjavaprograms.dynamicprogrammingtechniques;

import java.util.HashMap;

public class FibonacciTopDownApproach {
    /*
    In the top-down approach we use recursive function to iterate from the highest point to the lowest
    For each value of the index gained we store it, so that we don't iterate for next usage

    if num=5, then:

                                        (5-1)+(5-2)
                                    /               \
                            (4-1)+(4-2)             (3-1)+(3-2)
                            /        \              /
                    (3-1)+(3-2)     (2-1)+(2-2)   (2-1)+(2-2)
                        /
                (2-1)+(2-2)

    Here, (3-1)+(3-2) is being done twice, and (2-1)+(2-2) is being done thrice which can be solved faster if the values
    were stored.
    Without dynamic programming technique num=5 takes 15 recursion
    and 9 recursion if it is used.
     */

    static int count = 0;
    static HashMap<Integer, Integer> memorized = new HashMap<>();

    public static void main(String[] args) {
        int num = 10;
        System.out.println("Fibonacci of " + num + " is :" + fibonacci(num));
        System.out.println(count);
        System.out.println(memorized);
    }

    public static int fibonacci(int num){
        count++;
        if(num <= 1){
            return num;
        }
        if(memorized.containsKey(num)){
            return memorized.get(num);
        }
        memorized.put(num,fibonacci(num-1) + fibonacci(num-2));
        return memorized.get(num);
//        return fibonacci(num - 1) + fibonacci(num - 2);
    }
}

