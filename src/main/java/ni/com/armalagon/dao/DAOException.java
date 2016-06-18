package ni.com.armalagon.dao;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class DAOException extends Exception {
    private static final long serialVersionUID = -7293981891143168866L;

    public DAOException() {
        super("Ha ocurrido un error durante el acceso a la base de datos");
    }

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable th) {
        super(th);
    }

    public DAOException(String message, Throwable th) {
        super(message, th);
    }
}
