package ni.com.armalagon.factura;

/**
 *
 * @author aalaniz
 * @version 1.0
 * @since 1.0
 */
public class NovedadException extends Exception {
    private static final long serialVersionUID = -1842329981914765206L;

    public NovedadException() {
        super("La novedad no es valida");
    }

    public NovedadException(String error) {
        super(error);
    }

    public NovedadException(Throwable th) {
        super(th);
    }

    public NovedadException(String error, Throwable th) {
        super(error, th);
    }
}
