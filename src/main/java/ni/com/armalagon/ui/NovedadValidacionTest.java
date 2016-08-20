package ni.com.armalagon.ui;

import java.util.Calendar;
import java.util.GregorianCalendar;

import ni.com.armalagon.factura.*;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class NovedadValidacionTest {

    public static void main(String... args) {
        Calendar fecha = GregorianCalendar.getInstance();
        fecha.add(Calendar.MONTH, 1);

        Novedad novedad = new Alta();
        novedad.setNss(16146068);
        //novedad.setFechaMovimiento(new Date());
        novedad.setFechaMovimiento(fecha.getTime());
        novedad.setPeriodo(Configuracion.getInstance().getPeriodo());
        novedad.setPlaza(null);

        Novedad novedadDecorator = new PlazaNoDebeEstarActiva(novedad);
        //novedadDecorator = new PlazaDebeEstarActiva(novedadDecorator);

        System.out.println("Movimiento: " + novedadDecorator.getNombreMovimiento());
        try {
            novedadDecorator.validar();
        } catch (NovedadException e) {
            e.printStackTrace();
        }
    }
}
