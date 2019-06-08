package challengeaccepted.oncomed.addRequest;

import java.util.List;

public class Request {
    String date;
    String comment;
    String status;
    String pacientFirstName;
    String pacientLastName;
    String paciendId;
    String volunteerName;
    String volunteerId;
    String drugName;
    String drugActiveSubstance;
    String drugConcentration;
    String drugId;
    int quantity;

    public Request() {

    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getPacientFirstName() {
        return pacientFirstName;
    }

    public void setPacientFirstName(String pacientFirstName) {
        this.pacientFirstName = pacientFirstName;
    }

    public String getPacientLastName() {
        return pacientLastName;
    }

    public void setPacientLastName(String pacientLastName) {
        this.pacientLastName = pacientLastName;
    }

    public String getPaciendId() {
        return paciendId;
    }

    public void setPaciendId(String paciendId) {
        this.paciendId = paciendId;
    }

    public String getVolunteerName() {
        return volunteerName;
    }

    public void setVolunteerName(String volunteerName) {
        this.volunteerName = volunteerName;
    }

    public String getVolunteerId() {
        return volunteerId;
    }

    public void setVolunteerId(String volunteerId) {
        this.volunteerId = volunteerId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String getDrugActiveSubstance() {
        return drugActiveSubstance;
    }

    public void setDrugActiveSubstance(String drugActiveSubstance) {
        this.drugActiveSubstance = drugActiveSubstance;
    }

    public String getDrugConcentration() {
        return drugConcentration;
    }

    public void setDrugConcentration(String drugConcentration) {
        this.drugConcentration = drugConcentration;
    }
}
