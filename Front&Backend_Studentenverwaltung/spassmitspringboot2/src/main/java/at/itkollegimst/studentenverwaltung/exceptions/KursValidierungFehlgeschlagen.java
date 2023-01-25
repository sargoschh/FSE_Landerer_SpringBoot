package at.itkollegimst.studentenverwaltung.exceptions;

public class KursValidierungFehlgeschlagen extends Exception {

    private FormValidierungExceptionDTO errors;

    public KursValidierungFehlgeschlagen(String message) {
        super(message);
    }

    public KursValidierungFehlgeschlagen(FormValidierungExceptionDTO errors) {
        this.errors = errors;
    }

    public FormValidierungExceptionDTO getErrorMap() {return errors; }
}
