package ni.com.armalagon.sql;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class JdbcException extends RuntimeException {
    private static final long serialVersionUID = 5947094034077199637L;

    public JdbcException() {
        super("Ha ocurrido un error durante el acceso a la base de datos. Revise el log para mayor informacion");
    }

    public JdbcException(String message) {
        super(message);
    }

    public JdbcException(String message, Throwable cause) {
        super(message, cause);
    }

    public JdbcException(Throwable cause) {
        super(cause);
    }
}
