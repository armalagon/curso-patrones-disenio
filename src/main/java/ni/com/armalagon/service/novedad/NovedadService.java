package ni.com.armalagon.service.novedad;

import java.util.List;
import java.util.Observable;

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
public class NovedadService extends Observable {
    private final DAOFactory daoFactory;
    private final NovedadDAO novedadDAO;

    public NovedadService(DAOFactory daoFactory) {
        this.novedadDAO = daoFactory.crearNovedadDAO();
        this.daoFactory = daoFactory;
    }

    public DAOFactory getDaoFactory() {
        return daoFactory;
    }

    private void datoModificado() {
        setChanged();
        notifyObservers();
    }

    public void guardar(Novedad novedad) throws ServiceException {
        try {
            novedadDAO.insertar(novedad);
            datoModificado();
        } catch (DAOException exc) {
            throw new ServiceException("No se pudo guardar el movimiento", exc);
        }
    }

    public List<Novedad> buscarTodos() throws ServiceException {
        try {
            return novedadDAO.buscarTodos();
        } catch (DAOException exc) {
            throw new ServiceException("No se pudo obtener la lista de los movimientos", exc);
        }
    }
}














