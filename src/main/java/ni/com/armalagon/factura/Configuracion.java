package ni.com.armalagon.factura;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Configuracion {
    private static final Configuracion INSTANCE = new Configuracion();

    private final ConcurrentMap<Integer, Periodo> cachePeriodos;

    private Configuracion() {
        cachePeriodos = new ConcurrentHashMap<>();

        System.out.println("Llenar el cache con los 12 meses de este anio");
        Calendar cal = GregorianCalendar.getInstance();
        int periodo = -1;
        for (int i = 1; i <= 12; i++) {
            periodo = cal.get(Calendar.YEAR)*100 + i;
            Periodo objPeriodo = Periodo.crear(periodo);
            cachePeriodos.put(periodo, objPeriodo);
        }
    }

    public Periodo getPeriodo(int periodo) {
        return cachePeriodos.putIfAbsent(periodo, Periodo.crear(periodo));
    }

    public Periodo getPeriodo(final Date fecha) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);

        int periodo = cal.get(Calendar.YEAR)*100 + cal.get(Calendar.MONTH) + 1;
        return getPeriodo(periodo);
    }

    public Periodo getPeriodo(int anio, int mes) {
        int periodo = anio*100 + mes;
        return getPeriodo(periodo);
    }

    public static Configuracion getInstance() {
        return INSTANCE;
    }
}
