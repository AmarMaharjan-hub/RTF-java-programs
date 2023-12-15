package newjavaprograms.cleancodefunction;

public class FunctionArguments {
    public class Niladic{
        private String name;
        private String address;
        private String email;

        public String getName(){
            return name;
        }
        public void display(){
            System.out.println(name);
        }
        public void provideDummyValue(){
            name = "Richard";
            address = "Lock road";
            email = "richard@gmail.com";
        }
    }
    public class Monadic{
        private String name;
        private String address;
        private String email;

        public void setName(String name){
            this.name = name;
        }

        public String getNameByEmail(String email){
            return name;
        }

        public int getReverse(int number){
            int reverse = 0;
            for(int i=0; i<number; i++){
                int temp = number % 10;
                reverse = reverse * 10 + temp;
            }
            return reverse;
        }
//        public void getReverse(int number){
//            int reverse = 0;
//            for(int i=0; i<number; i++){
//                int temp = number % 10;
//                reverse = reverse * 10 + temp;
//            }
//            number = reverse;
//        }

        public void terminateIfMaxUserReached(int userNumber){
            if(userNumber >= 100){
                System.out.println("System terminated");
            }
        }

    }
    public class Dyadic{

        public void copyArray(int[] source, int[] destination){
            //The argument should be in natural order
        }

        public void searchElement(int[] array, int value){//declare array as global
            //search element
        }

    }
    public class Tryadic{
//        avoid tryadic as far as possible
    }
}
