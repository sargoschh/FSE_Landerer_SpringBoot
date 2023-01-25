package at.hakimst.Studentenverwaltung.Exceptions;

public class KursNotFoundException extends Exception {
    public KursNotFoundException() {
        super("Kurs nicht gefunden!");
    }
}
