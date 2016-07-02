package ni.com.armalagon.service.novedad;

import java.util.List;

import ni.com.armalagon.dao.DAOException;
import ni.com.armalagon.dao.DAOFactory;
import ni.com.armalagon.dao.novedad.NovedadDAO;
import ni.com.armalagon.modelo.Novedad;

/**
 *
 * @author aalaniz
 * @version 1.0
 * @since 1.0
 */
public class NovedadService {
    private final DAOFactory daoFactory;
    private final NovedadDAO novedadDAO;

    public NovedadService(DAOFactory daoFactory) {
        this.novedadDAO = daoFactory.crearNovedadDAO();
        this.daoFactory = daoFactory;
    }

    public List<Novedad> buscarTodos() throws ServiceException {
        try {
            return novedadDAO.buscarTodos();
        } catch (DAOException exc) {
            throw new ServiceException("No se pudo obtener la lista de los movimientos", exc);
        }
    }
}
