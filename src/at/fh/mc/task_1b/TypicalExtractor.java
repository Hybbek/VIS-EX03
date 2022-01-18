package at.fh.mc.task_1b;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.util.ArrayList;

/**
 * this class uses a stream-based parser to extract information from a XML fragment
 * and places the information in a corresponding Java container class (=creates a Wind object).
 */
public class TypicalExtractor{

    /**
     * main-method: fetches the relevant information of the XML fragment and creates a Wind
     * Object with the fetched information.
     * @param _args = startup arguments you can pass to this method; not used
     */
    public static void main(String[] _args) {

        //create new wind object
        Wind wind = new Wind();

        try {
            //instanziate stream-based parser
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();

            //create-configure new defaultHandler with followed methods
            DefaultHandler handler = new DefaultHandler(){

                //variable to hold fetched inforamtion
                String mTemp = "";

                @Override
                public void characters(char[] ch, int start, int length) throws SAXException {
                    //store defaultHandler's read characters to variable
                    mTemp = new String(ch, start, length);
                }

                @Override
                public void endElement(String _uri, String _localName, String _qName) throws SAXException {
                    //check which XML-ENDTAG was read by the defualtHandler
                    //set defualtHandler's read characters to appropriate object-field
                    if(_qName.equalsIgnoreCase("speed")){
                        wind.setSpeed(Double.parseDouble(mTemp));
                    }else if(_qName.equalsIgnoreCase("deg")){
                        wind.setDegrees(Integer.parseInt(mTemp));
                    }
                }
                //REMARK: public void startDocument() not needed
                //REMARK: startElement(...) not needed
            };

            //parse XML fragment via SAXParser and above created defaultHandler
            sp.parse(new File("./data/wind.xml"), handler);

            //DEBUG print out object fields after the object was created
            System.out.println("--New Wind object created--");
            System.out.println("speed: " + wind.getSpeed());
            System.out.println("degree: " + wind.getDeg());

        } catch (Exception _e) {
            _e.printStackTrace();
        }
    }
}
