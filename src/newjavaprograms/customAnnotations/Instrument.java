package newjavaprograms.customAnnotations;

@InstName(name="Piano")
public class Instrument {

    public void play(){
        System.out.println("Playing instrument");
    }

    @RunNow
    public void tune(){
        System.out.println("Tuning instrument");
    }

    public static void main(String[] args) {
        Instrument instrument = new Instrument();

        instrument.play();
        instrument.tune();
    }


}
