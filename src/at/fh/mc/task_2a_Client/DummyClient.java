package at.fh.mc.task_2a_Client;

import at.fh.mc.task_2a_server.HelloWorld;
import at.fh.mc.task_2a_server.HelloWorldService;

/**
 *
 */
public class DummyClient {

    public static void main(String[] _args){
       HelloWorldService serv = new HelloWorldService();
       HelloWorld soap = serv.getHelloWorldPort();
       System.out.println("server --> " + soap.saySomething());
    }
}
