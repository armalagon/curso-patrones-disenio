package ni.com.armalagon.dao.novedad;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import ni.com.armalagon.dao.DAOException;
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
public class NovedadFacturaDAO implements NovedadDAO {
    private static final String SQL_TODOS = "select * from factura.novedad";
    private static final String SQL_INSERTAR = "insert into factura.novedad ("
            + "nss, tipo_novedad, fecha_novedad, periodo, "
            + "semana1, semana2, semana3, semana4, semana5) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private JdbcUrl url;

    public NovedadFacturaDAO(JdbcUrl url) {
        this.url = url;
    }

    @Override
    public Novedad insertar(Novedad novedad) throws DAOException {
        try (
                Connection cnn = JdbcUtils.open(url);
                PreparedStatement pstmt = cnn.prepareStatement(SQL_INSERTAR);
                ) {
            pstmt.setInt(1, novedad.getNss());
            pstmt.setInt(2, novedad.getIdTipoNovedad());
            pstmt.setDate(3, new java.sql.Date(novedad.getFechaNovedad().getTime()));
            pstmt.setInt(4, novedad.getPeriodo());
            pstmt.setBoolean(5, novedad.getSemana().isSemana1());
            pstmt.setBoolean(6, novedad.getSemana().isSemana2());
            pstmt.setBoolean(7, novedad.getSemana().isSemana3());
            pstmt.setBoolean(8, novedad.getSemana().isSemana4());
            pstmt.setBoolean(9, novedad.getSemana().isSemana5());
            pstmt.executeUpdate();
        } catch (SQLException sqlExc) {
            throw new DAOException("Ha ocurrido un error durante la insercion a la tabla factura.novedad", sqlExc);
        }
        return novedad;
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
