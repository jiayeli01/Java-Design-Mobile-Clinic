package model.location;
import model.clinic.*;
import java.util.ArrayList;

public class SiteList {
    Clinic clinic;
    ArrayList<Site> sites;
    Location location;

    public SiteList(Clinic c){
        clinic = c;
        sites = new ArrayList<Site>();
    }

    public Site newSite(String n,Location l){
        Site site = new Site(n, l);
        sites.add(site);
        return site;
    }
    
    public int getSiteSize(){
        return sites.size();
    }

    public Site getSiteByIndex(int index){
        return sites.get(index);
    }

    public void infectiousRate(){
        for (Site s : sites){
            s.infectiousRate();
        }
    }
}
