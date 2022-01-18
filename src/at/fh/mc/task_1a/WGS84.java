package at.fh.mc.task_1a;

/**
 * this class is used to store the fetched information of an XML fragment in its class-fields
 */
public class WGS84 {
    //class-fields
    private double mLatitude;
    private double mLongitude;

    /**
     * constructor to create a new WSG84 object with initialized class fields
     * @param _latitude = fetched information of the XML fragment to initialize class-field
     * @param _longitude = fetched information of the XML fragment to initialize class-field
     */
    public WGS84(double _latitude, double _longitude) {
        this.mLatitude = _latitude;
        this.mLongitude = _longitude;
    }

    /**
     * getter-method, this method is used to get the stored information out of the class-field mLattitude
     * @return this method returns the value stored in the class-field mLattitude
     */
    public double getLatitude() {return mLatitude;}

    /**
     * getter-method, this method is used to get the stored information out of the class-field mLongitude
     * @return this method returns the value stored in the class-field mLongitude
     */
    public double getLongitude() {return mLongitude;}
}