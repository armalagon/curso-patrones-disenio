package ni.com.armalagon.dao;

import ni.com.armalagon.dao.novedad.NovedadDAO;
import ni.com.armalagon.dao.novedad.NovedadFacturaDAO;
import ni.com.armalagon.sql.JdbcUrl;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
class FacturaDAOFactory implements DAOFactory {
    private final JdbcUrl url;

    public FacturaDAOFactory(JdbcUrl url) {
        this.url = url;
    }

    @Override
    public NovedadDAO crearNovedadDAO() {
        return new NovedadFacturaDAO(url);
    }
}
