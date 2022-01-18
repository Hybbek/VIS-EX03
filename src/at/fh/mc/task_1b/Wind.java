package at.fh.mc.task_1b;

/**
 * this class is used to store the fetched information of an XML fragment in its class-fields
 */
public class Wind {
    //class-fields
    private double mSpeed;
    private int mDegrees;

    /**
    * getter-method, this method is used to get the stored information out of the class-field mSpeed
    * @return this method returns the value stored in the class-field mSpeed
    */
    public double getSpeed() {return mSpeed;}

    /**
    * getter-method, this method is used to get the stored information out of the class-field mDeg
    * @return this method returns the value stored in the class-field mDeg
    */
    public int getDeg() {return mDegrees;}

    /**
     * setter-method, this method is used to set the fetched information of the XML fragment
     * to the class-field mSpeed
     * @param _speed = information to store in the class-field mSpeed
     */
    void setSpeed(double _speed) {this.mSpeed = _speed;}

    /**
    * setter-method, this method is used to set the fetched information of the XML fragment
    * to the class-field mDegrees
    * @param _degrees = information to store in the class-field mDegrees
    */
    void setDegrees(int _degrees){this.mDegrees = _degrees;}
}
