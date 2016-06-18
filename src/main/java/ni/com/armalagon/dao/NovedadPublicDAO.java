package ni.com.armalagon.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ni.com.armalagon.factura.Semana;
import ni.com.armalagon.modelo.Novedad;
import ni.com.armalagon.sql.JdbcUrl;
import ni.com.armalagon.sql.JdbcUtils;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class NovedadPublicDAO implements NovedadDAO {
    private static final String SQL_TODOS = "select * from public.novedad";

    private JdbcUrl url;

    public NovedadPublicDAO(JdbcUrl url) {
        this.url = url;
    }

    @Override
    public Novedad buscarPorId(Integer id) throws DAOException {
        return null;
    }

    @Override
    public List<Novedad> buscarTodos() throws DAOException {
        List<Novedad> novedades = new ArrayList<>();

        try (
                Connection cnn = JdbcUtils.open(url);
                Statement stmt = cnn.createStatement();
                ) {
            try (ResultSet rs = stmt.executeQuery(SQL_TODOS)) {
                while (rs.next()) {
                    novedades.add(mapear(rs));
                }
            }
        } catch (SQLException sqlExc) {
            throw new DAOException("Ha ocurrido un error durante el acceso a la tabla public.novedad", sqlExc);
        }

        return novedades;
    }

    @Override
    public List<Novedad> buscarPorNss(Integer nss) throws DAOException {
        return null;
    }

    @Override
    public Novedad mapear(ResultSet rs) throws DAOException {
        Novedad novedad = new Novedad();

        try {
            novedad.setId(rs.getInt("id"));
            novedad.setNss(rs.getInt("nss"));
            novedad.setIdTipoNovedad(rs.getInt("tipo_novedad"));
            novedad.setFechaNovedad(rs.getDate("fecha_novedad"));
            novedad.setPeriodo(rs.getInt("periodo"));
            novedad.setSemana(new Semana(
                    rs.getBoolean("semana1")
                    , rs.getBoolean("semana2")
                    , rs.getBoolean("semana3")
                    , rs.getBoolean("semana4")
                    , rs.getBoolean("semana5")));
        } catch (SQLException e) {
            throw new DAOException("Ha ocurrido un error durante el mapeo de las columnas de la entidad Novedad");
        }
        return novedad;
    }
}
