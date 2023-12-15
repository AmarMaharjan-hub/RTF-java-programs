package newjavaprograms.customAnnotations;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CreatingAnnotations {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Instrument instrument = new Instrument();

        for(Method method: instrument.getClass().getDeclaredMethods()){
            if(method.isAnnotationPresent(RunNow.class)){
                method.invoke(instrument);
            }
        }

        InstName annotation = instrument.getClass().getAnnotation(InstName.class);
        System.out.println(annotation.name());

    }


}
