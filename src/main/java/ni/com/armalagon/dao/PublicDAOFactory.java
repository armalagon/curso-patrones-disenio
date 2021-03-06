package ni.com.armalagon.dao;

import ni.com.armalagon.dao.novedad.NovedadDAO;
import ni.com.armalagon.dao.novedad.NovedadPublicDAO;
import ni.com.armalagon.sql.JdbcUrl;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
class PublicDAOFactory implements DAOFactory {
    private final JdbcUrl url;

    public PublicDAOFactory(JdbcUrl url) {
        this.url = url;
    }

    @Override
    public NovedadDAO crearNovedadDAO() {
        return new NovedadPublicDAO(url);
    }
}
