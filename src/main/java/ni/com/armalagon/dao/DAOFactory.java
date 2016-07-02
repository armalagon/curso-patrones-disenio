package ni.com.armalagon.dao;

import ni.com.armalagon.dao.novedad.NovedadDAO;
import ni.com.armalagon.sql.JdbcUrl;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public interface DAOFactory {
    NovedadDAO crearNovedadDAO();

    static DAOFactory crearDAOFactory(JdbcUrl url, String schema) {
        if ("public".equals(schema)) {
            return new PublicDAOFactory(url);
        } else if ("factura".equals(schema)) {
            return new FacturaDAOFactory(url);
        } else {
            throw new IllegalArgumentException("No existe una implementacion del DAOFactory para el esquema especificado");
        }
    }

    static DAOFactory crearPublicDAOFactory(JdbcUrl url) {
        return crearDAOFactory(url, "public");
    }

    static DAOFactory crearFacturaDAOFactory(JdbcUrl url) {
        return crearDAOFactory(url, "factura");
    }
}
