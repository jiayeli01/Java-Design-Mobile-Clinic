package model.encounter;

public class VitalSigns {
    Double temperature;
    Double pulseRate;
    Double rateOfBreath;
    Double bloodPressure;

    public VitalSigns(double t, double p, double r, double b){
        temperature = t;
        pulseRate = r;
        rateOfBreath = r;
        bloodPressure = b;
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getPulseRate() {
        return pulseRate;
    }

    public void setPulseRate(Double pulseRate) {
        this.pulseRate = pulseRate;
    }

    public Double getRateOfBreath() {
        return rateOfBreath;
    }

    public void setRateOfBreath(Double rateOfBreath) {
        this.rateOfBreath = rateOfBreath;
    }

    public Double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(Double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }
}
