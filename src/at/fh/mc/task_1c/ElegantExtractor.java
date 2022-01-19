package at.fh.mc.task_1c;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;
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
    public static void main(String[] _args) throws ParseException, JAXBException {

        System.setProperty("javax.xml.bind.JAXBContextFactory","org.eclipse.persistence.jaxb.JAXBContextFactory");

        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/1940");
        String[] vaccs = {"cat flue", "feline distemper", "rabies", "leucosis"};


        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////Java -> XML//////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        Pet petXML = new Pet("Thomas", "Tom", birthday, Pet.Type.CAT, vaccs, "123456789");

        JAXBContext jc = JAXBContext.newInstance(new Class[]{Pet.class});

        Marshaller m = jc.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , Boolean.TRUE);

        StringWriter sw = new StringWriter();
        m.marshal(petXML, sw);

        String data = sw.getBuffer().toString();
        System.out.println("--------------------XML Ausgabe----------------------");
        System.out.println();
        System.out.println(data);
        System.out.println();
        System.out.println();

        Unmarshaller um = jc.createUnmarshaller();
        Pet res = (Pet)um.unmarshal (new StringReader(data));


        System.out.println("--------------------String Ausgabe--------------------");
        System.out.println();
        System.out.println(res.petToString());
        System.out.println();
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////Java -> JSON//////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        Pet petJSON = new Pet("Thomas", "Tom", birthday, Pet.Type.CAT, vaccs, "123456789");

        JAXBContext jcJSON = JAXBContext.newInstance(new Class[]{Pet.class});

        Marshaller mJSON = jcJSON.createMarshaller();
        mJSON.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        mJSON.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        StringWriter swJSON = new StringWriter();
        mJSON.marshal(petJSON, swJSON);

        String dataJSON = swJSON.toString();

        System.out.println("--------------------JSON Ausgabe--------------------");
        System.out.println();
        System.out.println(dataJSON);
        System.out.println();
        System.out.println();

        Unmarshaller umJSON = jcJSON.createUnmarshaller();
        umJSON.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);

        Pet resJSON = (Pet)umJSON.unmarshal(new StringReader(dataJSON));

        System.out.println("--------------------String Ausgabe--------------------");
        System.out.println();
        System.out.println(resJSON.petToString());

    }
}
