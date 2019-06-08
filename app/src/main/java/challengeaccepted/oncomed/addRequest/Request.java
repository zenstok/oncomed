package challengeaccepted.oncomed.addRequest;

import java.util.List;

public class Request {
    String date;
    Pacient pacient;
    Volunteer volunteer;
    Drug drug;
    int quantity;
    String status;

    public Request() {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Request(String date, Pacient pacient, Volunteer volunteer, Drug drug, int quantity) {
        this.date = date;
        this.pacient = pacient;
        this.volunteer = volunteer;
        this.drug = drug;
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Volunteer getVolunteer() {
        return volunteer;
    }

    public void setVolunteer(Volunteer volunteer) {
        this.volunteer = volunteer;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
}
