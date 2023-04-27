package GeoTargetingService;

public class Location {
    private String pincode;
    private String city;
    private String district;
    private String state;

    public Location(String pincode, String city, String district, String state) {
        this.pincode = pincode;
        this.city = city;
        this.district = district;
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
