package com.library.LMS;

import java.util.ArrayList;
import java.util.List;

import static com.library.lms.LibraryLogger.logInfo;

public class PatronManagement {
    private List<Patron> patrons;

    public PatronManagement() {
        patrons = new ArrayList<>();
    }

    public void setPatrons(List<Patron> patrons) {
        this.patrons = patrons;
    }

    public List<Patron> getPatrons() {
        return patrons;
    }

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public void removePatron(int patronId) {
        patrons.removeIf(patron -> patron.getPatronId() == patronId);
    }

    public void updatePatron(int patronId, Patron updatedPatron) {
        for (int i = 0; i < patrons.size(); i++) {
            if (patrons.get(i).getPatronId() == patronId) {
                patrons.set(i, updatedPatron);
                return;
            }
        }
        logInfo("Patron not found.");
    }

    public void listPatrons() {
        if (patrons.isEmpty()) {
            logInfo("No patrons in the system.");
            return;
        }
        for (Patron patron : patrons) {
            logInfo("Name: " + patron.getName() + ", Email: " + patron.getEmail());
        }
    }

    public Patron findPatronById(int patronId) {
        for (Patron patron : patrons) {
            if (patron.getPatronId() == patronId) {
                return patron;
            }
        }
        return null;
    }
}
