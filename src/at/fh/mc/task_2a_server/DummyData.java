package at.fh.mc.task_2a_server;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * this class is used to create DummyData objects, with it's JAXB annotations this class/object can
 * be serialized to a XML schema.
 */
@XmlRootElement
public class DummyData {
    //class fields
    @XmlElement
    String mText;

    @XmlElement
    long mTime;

    //in order to make this class mapable this public no-arg constructor is needed
    public DummyData(){}

    /**
     * constructor to create a new DummyData object with initialized class fields
     * @param _txt = some text to store
     * @param _time = some time vlaue to store
     */
    public DummyData(String _txt, long _time){
        mText = _txt;
        mTime = _time;
    }

    /**
     * to-string-method, this method is used to create a string representation of this class
     * @return this method return a string representation of this class
     */
    public String toString(){
        return "Dummy data from timestamp (" + mTime + ") --> " + mText;
    }
}