package newjavaprograms.cleancodefunction;

public class OneLevelOfAbstraction {

    public void makeBreakfast(){

        serveTea();
        serveBread();

//        serveBread();
//        boilWater();
//        addIngerdients();
//        System.out.println("give tea to Dave");
//        System.out.println("give tea to Evad");
    }
    public void serveBread(){
        toastBread();
        System.out.println("give bread to Dave");
        System.out.println("give bread to Evad");
    }
    public void toastBread(){
        System.out.println("Bread Toasted");
    }
    public void serveTea(){
        brewTea();
        System.out.println("give tea to Dave");
        System.out.println("give tea to Evad");
    }
    public void brewTea(){
        boilWater();
        addIngerdients();
    }
    public void boilWater(){
        System.out.println("Water Boiled");
    }
    public void addIngerdients(){
        System.out.println("Ingredients Added");
    }

}
