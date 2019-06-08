package challengeaccepted.oncomed.addRequest;

import java.util.List;

public class Request {
    Pacient pacient;
    Volunteer volunteer;
    List<Drug> drugs;

    public Request(Pacient pacient, Volunteer volunteer, List<Drug> drugs) {
        this.pacient = pacient;
        this.volunteer = volunteer;
        this.drugs = drugs;
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

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }
}
