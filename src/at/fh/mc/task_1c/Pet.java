package at.fh.mc.task_1c;

import javax.xml.bind.annotation.*;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Date;

/**
 *
 */

@XmlRootElement(name = "pet")
@XmlType(propOrder = {"mName", "mTyp", "mID", "mBirthday", "mVaccinations"})
public class Pet {
    @XmlElement(name = "name")
    String mName;

    @XmlAttribute(name = "nickName")
    String mNickName;

    @XmlElement(name = "birthday")
    Date mBirthday;

    @XmlElement(name = "type")
    Type mTyp; // enum cat, dog, mouse and bird

    @XmlElementWrapper(name = "vaccinations")
    @XmlElement(name = "vaccination")
    String[] mVaccinations;

    @XmlElement(name = "id")
    String mID;


    enum Type{
        CAT, DOG, MOUSE, BIRD
    }

    public Pet(String _name, String _nickName, Date _birthday, Type _typ, String[] _vaccinations, String _id){
        mName = _name;
        mNickName = _nickName;
        mBirthday = _birthday;
        mTyp = _typ;
        mVaccinations = _vaccinations;
        mID = _id;
    }

    public String petToString(){
        String s = "Name: " + mName + "\nNickname: " + mNickName + "\nBirthday: " + mBirthday + "\nType: " + mTyp + "\nVaccinations: " + Arrays.toString(mVaccinations) + "\nID: "+ mID;
        return s;
    }
}
