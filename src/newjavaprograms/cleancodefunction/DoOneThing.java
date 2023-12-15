package newjavaprograms.cleancodefunction;

public class DoOneThing {

    int waterLevel;
    boolean mainSwitch = true;

    public boolean isWaterTankFull(){
        if(waterLevel >= 100){
//            Avoid doing multiple things
//            mainSwitch = false;
            return true;
        }else{
            return false;
        }
    }

    public void cleanPrimaryTank(){
        mainSwitch = false;
        System.out.println("clean primary tank");
    }

    public void preparationsForCleaningPrimaryTank(){
        waterLevel = 0;//of secondary tank
        mainSwitch = true;
        if(isWaterTankFull()){
            cleanPrimaryTank();
        }else{
            System.out.println("do nothing");
        }
//        if(waterLevel >= 100){
////            extractable operations
//            mainSwitch = false;
//            sout("clean primary tank");
//        }else{
//            System.out.println("do nothing");
//        }
    }

}
