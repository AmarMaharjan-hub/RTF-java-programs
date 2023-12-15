package newjavaprograms.dynamicprogrammingtechniques;

public class FibonacciBottomUPApproach {

    /*
        In bottom up approach the problem is solved from the bottom and calculating the value moving upwards
        This removes recursion and decreases space needed
    */

    public static void main(String[] args) {
        int num = 10;
        System.out.println("Fibonacci of " + num + " is :" + fibonacci(num));
    }

    public static int fibonacci(int num){
        int previous = 1;
        int sum = 0;
        for(int i=0; i<num; i++){
            int temp = sum;
            sum += previous;
            previous = temp;
        }

        return sum;
    }
}
