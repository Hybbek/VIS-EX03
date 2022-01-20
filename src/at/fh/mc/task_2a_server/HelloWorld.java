package at.fh.mc.task_2a_server;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * this class is a simple web service that offers two methods as web service methods.
 */
@WebService
public class HelloWorld {

    /**
     * this method can say something if it gets called
     * @return = this mehtod returns a string saying "Hello World"
     */
    @WebMethod
    public String saySomething(){return "Hello World";}

    /**
     * this method can be used to get some dummy data
     * @param _txt = some text to store in the dummy data
     * @return = this method returns a new DummyData Object with initialized name and time
     */
    @WebMethod
    public DummyData getDummyData(String _txt){return new DummyData(_txt, System.currentTimeMillis());}
}