package model.location;


public class Location {
    String address;
    SiteList siteList;

    public Location(String a){
        address = a;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public SiteList getSiteList() {
        return siteList;
    }

    public void setSiteList(SiteList siteList) {
        this.siteList = siteList;
    }

}
