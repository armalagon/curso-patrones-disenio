package ni.gob.inss.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class JdbcUtils {

    private static Connection create(JdbcUrl config, String user, String password) {
        try {
            Class.forName(config.getDriverClassName());
            Connection cnn = null;

            if (user == null && password == null) {
                if (config.getProperties() == null || config.getProperties().isEmpty()) {
                    cnn = DriverManager.getConnection(config.getUrl());
                } else {
                    cnn = DriverManager.getConnection(config.getUrl(), config.getProperties());
                }
            } else {
                cnn = DriverManager.getConnection(config.getUrl(), user, password);
            }
            return cnn;
        } catch (ClassNotFoundException e) {
            throw new JdbcException("No se puedo cargar la clase del driver");
        } catch (SQLException e) {
            throw new JdbcException(e);
        }
    }

    public static Connection open(JdbcUrl config) {
        return create(config, null, null);
    }

    public static Connection open(JdbcUrl url, String user, String password) {
        return create(url, user, password);
    }

    public static void close(AutoCloseable cnn) {
        if (cnn != null) {
            try {
                cnn.close();
            } catch (Exception e) {
                throw new JdbcException("Ha ocurrido un error al tratar de cerrar la conexion", e);
            }
        }
    }

    public static void close(AutoCloseable... sqlObjects) {
        for (AutoCloseable obj : sqlObjects) {
            try {
                obj.close();
            } catch (Exception e) {
                throw new JdbcException("Ha ocurrido un error al tratar de cerrar la conexion de un objeto sql", e);
            }
        }
    }
}
