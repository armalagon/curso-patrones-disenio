package ni.gob.inss.sie.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class DateUtils {

    public static int semanaDe(Date fechaMovimiento) {
        int cont = 0;
        Calendar sabado = CalendarBuilder.of(fechaMovimiento).firstSaturday().build();
        Calendar ultDiaMes = CalendarBuilder.of(fechaMovimiento).lastDayOfMonth().build();

        // Calcular los sabados anteriores a la fecha de novedad
        while (sabado.getTime().compareTo(fechaMovimiento) <= 0) {
            ++cont;
            sabado.add(Calendar.DAY_OF_MONTH, 7);
        }

        Calendar calFechaMovimiento = CalendarBuilder.of(fechaMovimiento).build();

        // Si la fecha de movimiento es diferente a un sabado, sumar uno
        // Si el sabado esta en el prox mes, no sumar uno
        if (calFechaMovimiento.get(Calendar.DAY_OF_WEEK) < Calendar.SATURDAY && sabado.compareTo(ultDiaMes) <= 0) {
            ++cont;
        }
        return cont;
    }

    public static int totalSemana(Date fechaMovimiento) {
        int cont = 4;

        Calendar sabado = CalendarBuilder.of(fechaMovimiento).toSaturday(4).build();
        Calendar ultDia = CalendarBuilder.of(fechaMovimiento).lastDayOfMonth().build();

        sabado.add(Calendar.DAY_OF_MONTH, 7);
        if (!sabado.after(ultDia)) {
            cont = 5;
        }
        return cont;
    }

    public static Date crearPrimerDia(int anio, int mes) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.set(anio, mes - 1, 1);
        return cal.getTime();
    }
}
