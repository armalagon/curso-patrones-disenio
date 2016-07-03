package ni.com.armalagon.ui;

import java.util.Date;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import ni.com.armalagon.dao.DAOFactory;
import ni.com.armalagon.factura.Semana;
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
public class MainApp implements Observer {
    private Observable sujeto;
    private List<Novedad> novedades;

    public MainApp(Observable sujeto) {
        this.sujeto = sujeto;
        this.sujeto.addObserver(this);
    }

    public void mostrarTodo() {
        for (Novedad novedad : novedades) {
            System.out.printf("Novedad[nss=%d,semanas=%s]%n", novedad.getNss(), novedad.getSemana());
        }
    }

    @Override
    public void update(Observable observable, Object obj) {
        if (observable instanceof NovedadService) {
            NovedadService novedadService = (NovedadService) observable;
            System.out.println("Se recibe notificacion...");
            try {
                novedades = novedadService.buscarTodos();
                mostrarTodo();
            } catch (ServiceException e) {
                e.printStackTrace();
            }
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
        MainApp app = null;
        NovedadService novedadService = null;

        System.out.println("Consulta al esquema PUBLIC...");
        daoFactory = DAOFactory.crearPublicDAOFactory(url);
        novedadService = new NovedadService(daoFactory);
        app = new MainApp(novedadService);

        Novedad nov = new Novedad();
        nov.setNss(12345678);
        nov.setIdTipoNovedad(1);
        nov.setFechaNovedad(new Date());
        nov.setPeriodo(201607);
        nov.setSemana(new Semana(true, false, true, false, true));

        try {
            novedadService.guardar(nov);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
}
