package at.fh.mc.task_1c_1d;

import org.eclipse.persistence.jaxb.MarshallerProperties;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.*;
import javax.xml.transform.stream.StreamSource;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * this class uses "the-elegant-approach" of parsing an Java-Object to XML
 * or vice versa. In order to do this the Java-Object which has to be converted is annotated
 * with JAXB annotations.
 */
public class ElegantExtractor {

    /**
     * main-method: creates a Pet object which gets parsed to XML or vice versa.
     * @param _args = startup arguments you can pass to this method; not used
     */
    public static void main(String[] _args) throws ParseException, JAXBException {

        //needed for JSON convertion
        System.setProperty("javax.xml.bind.JAXBContextFactory","org.eclipse.persistence.jaxb.JAXBContextFactory");

        //variables used to instantiate Pet object
        Date birthday = new SimpleDateFormat("dd/MM/yyyy").parse("10/02/1940");
        String[] vaccs = {"cat flue", "feline distemper", "rabies", "leucosis"};

        //create new Pet object
        Pet pet = new Pet("Thomas", "Tom", birthday, Pet.Type.CAT, vaccs, "123456789");

        //entry point to the JAXB API; provides a new instance of the JAXBContext;
        //the class pet should be recognized by the new JAXBContext
        JAXBContext jc = JAXBContext.newInstance(new Class[]{Pet.class});

        ///////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////Java <-> XML/////////////////////////////////////////////////////
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        //create marshaller object that can be used to convert java content into XML
        Marshaller mXML = jc.createMarshaller();
        mXML.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_XML);
        mXML.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT , Boolean.TRUE);

        //output-stream for the marshaller
        StringWriter osXML = new StringWriter();

        //marshal the created Pet object into the output-stream osXML
        mXML.marshal(pet, osXML);

        //save the XML serialization to a string
        String dataXML = osXML.getBuffer().toString();

        //DEBUG print out XML serialization after it has been marshallerd form the Pet object
        System.out.println("--------------------XML Ausgabe----------------------");
        System.out.println(dataXML+"\n");

        //create unmarshaller object that can be used to convert XML into java content
        Unmarshaller umXML = jc.createUnmarshaller();
        umXML.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_XML);

        //unmarshal above saved XML  serialization to java content
        Pet resXML = (Pet)umXML.unmarshal (new StringReader(dataXML));

        //DEBUG print out the deserialization of the XML data
        System.out.println("--------------------String Ausgabe--------------------");
        System.out.println(resXML.petToString()+"\n");

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //////////////////////////////////////////Java <-> JSON/////////////////////////////////////////////////////
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////

        //create marshaller object that can be used to convert java content into JSON
        Marshaller mJSON = jc.createMarshaller();
        mJSON.setProperty(MarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        mJSON.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        //output-stream for the marshaller
        StringWriter osJSON = new StringWriter();

        //marshal the created Pet object into the output-stream osJSON
        mJSON.marshal(pet, osJSON);

        //save the JSON serialization to a string
        String dataJSON = osJSON.toString();

        //DEBUG print out JSON serialization after it has been marshallerd form the Pet object
        System.out.println("--------------------JSON Ausgabe--------------------");
        System.out.println(dataJSON+"\n");

        //create unmarshaller object that can be used to convert JSON into java content
        Unmarshaller umJSON = jc.createUnmarshaller();
        umJSON.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);

        //unmarshal above saved JSON serialization to java content
        Pet resJSON = (Pet)umJSON.unmarshal(new StringReader(dataJSON));

        //DEBUG print out the deserialization of the JSON data
        System.out.println("--------------------String Ausgabe--------------------");
        System.out.println(resJSON.petToString()+"\n");

        /////////////////////////////JSON -> Java (Without Root-Element)////////////////////////////////////////////

        String JSONWithoutRoot ="{\n" +
        "\"nickName\" : \"Tom\",\n" +
        "\"name\" : \"Thomas\",\n" +
        "\"birthday\" : \"1940-02-10T13:51:30.673+01:00\",\n" +
        "\"type\" : \"CAT\",\n" +
        "\"vaccinations\" : {\n" +
        "\"vaccination\" : [\"cat flu\", \"feline distemper\", \"rabies\", \"leucosis\"]\n" +
        "},\n" +
        "\"id\" : 123456789 " +
        "}";

         //create unmarshaller object that can be used to convert JSON wi into java content
        Unmarshaller umJSONWithoutRoot = jc.createUnmarshaller();
        umJSONWithoutRoot.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        umJSONWithoutRoot.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, Boolean.FALSE);
        
        StreamSource stream = new StreamSource(new StringReader(JSONWithoutRoot));
        
        //unmarshal above saved JSON string without root to java content
        JAXBElement<Pet> petContainer = umJSONWithoutRoot.unmarshal(stream, Pet.class);

        
        Pet petWithoutRoot = petContainer.getValue();

        //DEBUG print out the deserialization of the JSON data
        System.out.println("--------------String Ausgabe ohne root----------------");
        System.out.println(petWithoutRoot.petToString());
    }
}
