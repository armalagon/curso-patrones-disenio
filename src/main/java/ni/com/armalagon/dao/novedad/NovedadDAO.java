package ni.com.armalagon.dao.novedad;

import java.sql.ResultSet;
import java.util.List;

import ni.com.armalagon.dao.DAOException;
import ni.com.armalagon.modelo.Novedad;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public interface NovedadDAO {
    Novedad insertar(Novedad novedad) throws DAOException;

    Novedad buscarPorId(Integer id) throws DAOException;

    List<Novedad> buscarTodos() throws DAOException;

    List<Novedad> buscarPorNss(Integer nss) throws DAOException;

    Novedad mapear(ResultSet rs) throws DAOException;
}
