package ni.com.armalagon.sql;

import java.util.List;

import ni.com.armalagon.dao.DAOException;
import ni.com.armalagon.dao.DAOFactory;
import ni.com.armalagon.dao.NovedadDAO;
import ni.com.armalagon.modelo.Novedad;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SieApp {

    public static void printAll(JdbcUrl url, DAOFactory daoFactory) {
        NovedadDAO novedadDAO = null;
        List<Novedad> novedades = null;

        novedadDAO = daoFactory.crearNovedadDAO();
        try {
            novedades = novedadDAO.buscarTodos();
            for (Novedad novedad : novedades) {
                System.out.printf("Novedad[nss=%d,semanas=%s]%n", novedad.getNss(), novedad.getSemana());
            }
        } catch (DAOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String... args) {
        JdbcUrl url = new PostgreSQLUrl.Builder()
                .database("sie")
                .user("champu")
                .password("champu")
                .addProperty("ApplicationName", "sie")
                .build();
        System.out.println("************ url: " + url.getUrl());

        DAOFactory daoFactory = null;

        System.out.println("Consulta al esquema PUBLIC...");
        daoFactory = DAOFactory.crearPublicDAOFactory(url);
        printAll(url, daoFactory);

        System.out.println("Consulta al esquema FACTURA...");
        daoFactory = DAOFactory.crearFacturaDAOFactory(url);
        printAll(url, daoFactory);
    }
}
