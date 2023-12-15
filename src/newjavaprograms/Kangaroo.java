package newjavaprograms;

public class Kangaroo {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
        // Write your code here
        if(x1 != x2){
            int startDelta = x1<x2 ? x2-x1 : x1-x2;
            int velocityDifference = x1<x2 ? v1-v2 : v2-v1;

            if(velocityDifference<=0){
                return "NO";
            }
            if(startDelta % velocityDifference == 0){
                return "YES";
            }
        }
        if(v1 == v2){
            return "YES";
        }
        return "NO";

    }

//    public static void main(String[] args) {
//        System.out.println(kangaroo(2,4,2,2));
//    }
}
