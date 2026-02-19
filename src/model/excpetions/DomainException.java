package model.excpetions;

public class DomainException extends Exception {
    private static final long serialVersionUID = 1l;

    public DomainException(String msg) {
        super(msg);
    }
}
