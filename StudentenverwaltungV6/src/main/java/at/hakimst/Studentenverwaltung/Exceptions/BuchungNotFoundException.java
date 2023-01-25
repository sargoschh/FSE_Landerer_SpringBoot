package at.hakimst.Studentenverwaltung.Exceptions;

public class BuchungNotFoundException extends Exception {

    public BuchungNotFoundException() {
        super("Buchung nicht gefunden!");
    }
}
