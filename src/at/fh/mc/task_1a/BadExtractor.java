package at.fh.mc.task_1a;

/**
 * this class uses the String class with its methods to extract information from a XML fragment
 * and places the information in a corresponding Java container class (=creates a WGS84 object).
 */
public class BadExtractor {
    //XML fragment to fetch information from

    /**
     * main-method: fetches the relevant information of the XML fragment and creates a WSG84
     * Object with the fetched information.
     * @param args = startup arguments you can pass to this method; not used
     */
    public static void main(String[] _args) {
        //XML fragment to fetch information from
        String XMLFragment = "<wgs84>\r\n<latitude>48.31</latitude>\r\n<longitude>14.29</longitude>\r\n</wgs84>";        

        //save fetched information
        double latitude = Double.parseDouble(XMLFragment.substring(19, 24));
        double longitude = Double.parseDouble(XMLFragment.substring(48, 53));

        //create WSG84 object with the fetched information
        WGS84 wsg84Object = new WGS84(latitude, longitude);

        //DEBUG print out object fields after the object was created
        System.out.println("--New WSG84 object created--");
        System.out.println("latitude: " + wsg84Object.getLatitude());
        System.out.println("longitude: " + wsg84Object.getLongitude());
    }
}
