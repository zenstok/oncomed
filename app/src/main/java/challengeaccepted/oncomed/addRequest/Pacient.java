package challengeaccepted.oncomed.addRequest;

import java.util.List;

public class Pacient {
    private String name;
    private int age;
    private String CNP;
    private String telephone;
    private String email;
    private List<Drug> drugs;

    public Pacient(String name, int age, String CNP, String telephone, String email, List<Drug> drugs) {
        this.name = name;
        this.age = age;
        this.CNP = CNP;
        this.telephone = telephone;
        this.email = email;
        this.drugs = drugs;
    }

    public Pacient() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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
