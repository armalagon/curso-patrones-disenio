package ni.com.armalagon.service.novedad;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class ServiceException extends Exception {
    private static final long serialVersionUID = -3796574722737777900L;

    public ServiceException() {
        super("Ha ocurrido un error, por favor consulta el log para mayor informacion");
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable th) {
        super(th);
    }

    public ServiceException(String message, Throwable th) {
        super(message, th);
    }
}
