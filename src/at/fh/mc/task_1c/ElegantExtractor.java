package at.fh.mc.task_1c;

import java.lang.reflect.Type;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 */
public class ElegantExtractor {

   /* enum animals implements Type{
            CAT, DOG, MOUSE, BIRD
        }*/
    /**
     *
     * @param _args
     */
    public static void main(String[] _args) throws ParseException {

        Date birthday = new SimpleDateFormat("dd/mm/yyyy").parse("10/02/1940");
        String[] vaccs = {"cat flue", "feline distemper", "rabies", "leucosis"};
        Pet pet = new Pet("Thomas", "Tom", birthday, Pet.Type.CAT, vaccs, "123456789");
        System.out.println(pet.petToString());
    }
}
