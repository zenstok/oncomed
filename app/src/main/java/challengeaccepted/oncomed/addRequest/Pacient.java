package challengeaccepted.oncomed.addRequest;

import java.util.List;

public class Pacient {
    private String lastName;
    private String firstName;
    private String CNP;
    private String telephone;
    private String email;
    private List<Drug> drugs;

    public Pacient(String lastName, String firstName, String CNP, String telephone, String email, List<Drug> drugs) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.CNP = CNP;
        this.telephone = telephone;
        this.email = email;
        this.drugs = drugs;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getCNP() {
        return CNP;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
