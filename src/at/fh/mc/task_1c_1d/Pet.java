package at.fh.mc.task_1c_1d;

import javax.xml.bind.annotation.*;
import java.util.Arrays;
import java.util.Date;

/**
 * this class is used to create Pet objects, with it's JAXB annotations this class/object can
 * be serialized to a XML schema.
 */
@XmlRootElement(name = "pet")
@XmlType(propOrder = {"mName", "mTyp", "mID", "mBirthday", "mVaccinations"})
public class Pet {
    //class fields
    @XmlElement(name = "name")
    private String mName;

    @XmlAttribute(name = "nickName")
    private String mNickName;

    @XmlElement(name = "birthday")
    private Date mBirthday;

    @XmlElement(name = "type")
    private Type mTyp; // enum cat, dog, mouse and bird

    @XmlElementWrapper(name = "vaccinations")
    @XmlElement(name = "vaccination")
    private String[] mVaccinations;

    @XmlElement(name = "id")
    private String mID;

    //enum to choose a defined Type while creating a new Pet object
    enum Type{
        CAT, DOG, MOUSE, BIRD
    }

    //in order to make this class mapable this public no-arg constructor is needed
    public Pet(){}

    /**
    * constructor to create a new Pet object with initialized class fields
    * @param _name = name of the pet
    * @param _nickName = nickName of the pet
    * @param _birthday = birthday of the pet
    * @param _typ = typ of the pet (cat, dog, mouse or bird)
    * @param _vaccinations = array of this pet's vaccinations
    * @param _id = id of the pet
    */
    public Pet(String _name, String _nickName, Date _birthday, Type _typ, String[] _vaccinations, String _id){
        mName = _name;
        mNickName = _nickName;
        mBirthday = _birthday;
        mTyp = _typ;
        mVaccinations = _vaccinations;
        mID = _id;
    }

    /**
     * to-string-method, this method is used to create a string representation of this class
     * @return this method return a string representation of this class
     */
    public String petToString(){
        String s = "Name: " + mName + "\nNickname: " + mNickName + "\nBirthday: " + mBirthday + "\nType: " + mTyp + "\nVaccinations: " + Arrays.toString(mVaccinations) + "\nID: "+ mID;
        return s;
    }
}
