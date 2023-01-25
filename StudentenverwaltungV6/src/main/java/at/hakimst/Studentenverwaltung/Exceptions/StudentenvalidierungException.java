package at.hakimst.Studentenverwaltung.Exceptions;

public class StudentenvalidierungException extends Exception {
    public StudentenvalidierungException(String message) {
        super("Datenfelder des anzulegenden Studenten nicht gültig: " + message);
    }
}
