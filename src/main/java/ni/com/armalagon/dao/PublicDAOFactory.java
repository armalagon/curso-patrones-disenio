package ni.com.armalagon.dao;

import ni.com.armalagon.sql.JdbcUrl;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class PublicDAOFactory implements DAOFactory {
    private JdbcUrl url;

    public PublicDAOFactory(JdbcUrl url) {
        this.url = url;
    }

    @Override
    public NovedadDAO crearNovedadDAO() {
        return new NovedadPublicDAO(url);
    }
}
