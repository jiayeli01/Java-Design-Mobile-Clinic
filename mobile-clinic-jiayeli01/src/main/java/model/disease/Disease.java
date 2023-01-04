package model.disease;



public class Disease {
    String description;
    boolean infectious;

    public Disease(String d, boolean i){
        description = d;
        infectious = i;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInfectious() {
        return infectious;
    }

    public void setInfectious(boolean infectious) {
        this.infectious = infectious;
    }

}
