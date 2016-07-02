package ni.com.armalagon.ui;

import java.util.List;

import ni.com.armalagon.dao.DAOFactory;
import ni.com.armalagon.modelo.Novedad;
import ni.com.armalagon.service.novedad.NovedadService;
import ni.com.armalagon.service.novedad.ServiceException;
import ni.com.armalagon.sql.JdbcUrl;
import ni.com.armalagon.sql.PostgreSQLUrl;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class MainApp {

    public static void printAll(NovedadService novedadService) {
        try {
            List<Novedad> novedades = novedadService.buscarTodos();
            for (Novedad novedad : novedades) {
                System.out.printf("Novedad[nss=%d,semanas=%s]%n", novedad.getNss(), novedad.getSemana());
            }
        } catch (ServiceException e) {
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
        printAll(new NovedadService(daoFactory));

        System.out.println("Consulta al esquema FACTURA...");
        daoFactory = DAOFactory.crearFacturaDAOFactory(url);
        printAll(new NovedadService(daoFactory));
    }
}
