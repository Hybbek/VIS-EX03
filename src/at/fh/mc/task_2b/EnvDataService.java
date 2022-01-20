package at.fh.mc.task_2b;

import at.fh.mc.task_1c_1d.Pet;
import org.eclipse.persistence.jaxb.UnmarshallerProperties;

import javax.jws.WebService;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

@WebService(endpointInterface = "at.fh.mc.task_2b")
public class EnvDataService implements IEnvData {

    @Override
    public EnvData[] requestEnvironmentDataTypes() {
        return new EnvData[0];
    }

    public static String recWebContent(String _city) throws IOException {
        URL url = new URL("https://api.openweathermap.org/data/2.5/weather?q=Wien,at&units=metric&APPID=bf47dc531520384cf75fb4bb93a8488b");
        HttpURLConnection http = (HttpURLConnection) url.openConnection();

        int length = http.getContentLength();
        int resCode = http.getResponseCode();
        String mime = http.getContentType();

        Scanner s = new Scanner(http.getInputStream(), "UTF-8");
        s.useDelimiter("\\z");
        String content = s.next();
        s.close();

        int start = content.lastIndexOf("main")+6;
        int end = content.indexOf("visibility")-2;

        return content.substring(start,end);
    }

    public static EnvData stringToJSON(String _content) throws JAXBException {
        JAXBContext jc = JAXBContext.newInstance(new Class[]{EnvData.class});

        //create unmarshaller object that can be used to convert JSON wi into java content
        Unmarshaller um = jc.createUnmarshaller();
        um.setProperty(UnmarshallerProperties.MEDIA_TYPE, MediaType.APPLICATION_JSON);
        um.setProperty(UnmarshallerProperties.JSON_INCLUDE_ROOT, Boolean.FALSE);

        StreamSource stream = new StreamSource(new StringReader(_content));

        //unmarshal above saved JSON string without root to java content
        JAXBElement<EnvData> petContainer = um.unmarshal(stream, EnvData.class);

        EnvData data = petContainer.getValue();
        return data;
    }

    public static void main(String[] args) throws IOException, JAXBException {
        System.setProperty("javax.xml.bind.JAXBContextFactory","org.eclipse.persistence.jaxb.JAXBContextFactory");
        String s = recWebContent("Linz");
        System.out.println(stringToJSON(s).envDataToString());
        //System.out.println(s);
    }
}
