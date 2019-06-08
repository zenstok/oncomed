package challengeaccepted.oncomed.addRequest;

public class Drug {
    String activeSubstance;
    String name;
    int concentration;
    int treatmentPeriod;

    public String getActiveSubstance() {
        return activeSubstance;
    }

    public void setActiveSubstance(String activeSubstance) {
        this.activeSubstance = activeSubstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getConcentration() {
        return concentration;
    }

    public void setConcentration(int concentration) {
        this.concentration = concentration;
    }

    public int getTreatmentPeriod() {
        return treatmentPeriod;
    }

    public void setTreatmentPeriod(int treatmentPeriod) {
        this.treatmentPeriod = treatmentPeriod;
    }

    public Drug(String activeSubstance, String name, int concentration, int treatmentPeriod) {
        this.activeSubstance = activeSubstance;
        this.name = name;
        this.concentration = concentration;
        this.treatmentPeriod = treatmentPeriod;
    }
}
