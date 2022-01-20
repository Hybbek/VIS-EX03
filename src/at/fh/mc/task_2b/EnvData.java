package at.fh.mc.task_2b;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "main")
@XmlType(propOrder = {"mTemp", "mFeelsLike", "mTempMin", "mTempMax", "mPressure", "mHumidity"})
public class EnvData {

    @XmlElement(name = "temp")
    private double mTemp;

    @XmlElement(name = "feels_like")
    private double mFeelsLike;

    @XmlElement(name = "temp_min")
    private double mTempMin;

    @XmlElement(name = "temp_max")
    private double mTempMax;

    @XmlElement(name = "pressure")
    private int mPressure;

    @XmlElement(name = "humidity")
    private int mHumidity;

    public EnvData(){}

    public EnvData(double _temp, double _feelsLike, double _tempMin, double _tempMax, int _pressure, int _humidity){
        mTemp = _temp;
        mFeelsLike = _feelsLike;
        mTempMin = _tempMin;
        mTempMax = _tempMax;
        mPressure = _pressure;
        mHumidity = _humidity;
    }

    public String envDataToString(){
        String s = "Temperature: " + mTemp + "\nFeels like: " + mFeelsLike + "\nMin temperature: " + mTempMin + "\nMax temperature: " + mTempMax + "\nPressure: " + mPressure + "\nHumidity: " + mHumidity;
        return s;
    }

}
