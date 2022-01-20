package at.fh.mc.task_2a_service;

import at.fh.mc.task_2a_server.DummyData;
import at.fh.mc.task_2a_server.HelloWorld;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

@WebService(endpointInterface="at.fh.mc.task_2a_service.ISimpleInterface")
public class HelloWorldService implements ISimpleInterface{
    @Override
    @WebMethod
    public String saySomething() {
        return "Hello World";
    }

    @Override
    @WebMethod
    public DummyData getDummyData(String _name) {
        return new DummyData(_name, System.currentTimeMillis());
    }

    public static void main(String[] _args){
        HelloWorldService test = new HelloWorldService();
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/HelloWorldService",test);

        System.out.println("Server up and running...");
    }
}
