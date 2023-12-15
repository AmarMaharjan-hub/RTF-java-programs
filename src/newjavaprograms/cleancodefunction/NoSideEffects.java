package newjavaprograms.cleancodefunction;

public class NoSideEffects {
    String name;

    boolean nameChanged = false;
    public void updateName(String name){
        this.name = name;
    }

    public boolean checkName(String name){
        if(name.equals(this.name)){
            return true;
        }
        return false;
    }

    public void checkNameBad(String name){
        if(!name.equals(this.name)){
            this.name = name;
            nameChanged = true;//avoid hidden operations
        }
    }
}
