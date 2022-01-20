package at.fh.mc.task_2a_service;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class DummyClientService {

    private static ISimpleInterface mSoap;

    public static void main(String[] _args) throws MalformedURLException{
        Service service = Service.create(new URL("http://localhost:8081/HelloWorldService?wsdl"),
        new QName("http://task_2a_service.mc.fh.at/", "HelloWorldServiceService"));
        mSoap = service.getPort(ISimpleInterface.class);
        System.out.println(mSoap.saySomething());
    }

    
}
