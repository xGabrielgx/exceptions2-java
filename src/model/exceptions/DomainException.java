package model.exceptions;

// se colocar RuntimeException o compilador não obriga você a tratar
// mas se vc extender a partir de Exception o compilador vai obrigar você a tratar.

public class DomainException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }
}
