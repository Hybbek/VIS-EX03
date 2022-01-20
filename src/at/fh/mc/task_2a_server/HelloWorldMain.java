package at.fh.mc.task_2a_server;

import javax.xml.ws.Endpoint;

/**
 * this class is used to put the HelloWorld web service online via the endpoint class
 */
public class HelloWorldMain {

    /**
    * main-method: creates a HelloWorld object which is used as a web service via the endpoint class
    * @param _args = startup arguments you can pass to this method; not used
    */
    public static void main(String[] _args){
        //create a new HelloWorld object which is used as a web service
        HelloWorld wsHelloWorld = new HelloWorld();

        //put the web service online using the endpoint class
        Endpoint endpoint = Endpoint.publish("http://localhost:8081/HelloWorld",wsHelloWorld);

        //DEBUG print out server status
        System.out.println("Server up and running...");
    }
}