package ni.gob.inss.sie;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import ni.gob.inss.sie.util.CalendarBuilder;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class CalendarBuilderTest {
    private enum SaturdayType {
        FIRST, LAST, SECOND, THIRD, FOURTH, FIFTH
    }

    private Calendar calFecha;
    private CalendarBuilder builder;

    @Before
    public void config() {
        // La fecha siempre es el 1ro de junio de 2016
        calFecha = GregorianCalendar.getInstance();
        calFecha.set(2016, Calendar.JUNE, 1);
    }

    @After
    public void limpiar() {
        calFecha = null;
        builder = null;
    }

    @Test
    public  void calcularPrimerSabado() {
        // Junio
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(4, getDay(builder, SaturdayType.FIRST));

        // Julio
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(2, getDay(builder, SaturdayType.FIRST));

        // Agosto
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(6, getDay(builder, SaturdayType.FIRST));

        // Marzo
        calFecha.add(Calendar.MONTH, -5);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(5, getDay(builder, SaturdayType.FIRST));
    }

    @Test
    public void calcularUltimoSabado() {
        // Junio
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(25, getDay(builder, SaturdayType.LAST));

        // Julio
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(30, getDay(builder, SaturdayType.LAST));

        // Agosto
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(27, getDay(builder, SaturdayType.LAST));

        // Marzo
        calFecha.add(Calendar.MONTH, -5);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(26, getDay(builder, SaturdayType.LAST));
    }

    @Test
    public void calcularNSabado() {
        // Junio
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(18, getDay(builder, SaturdayType.THIRD));

        // Julio
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(30, getDay(builder, SaturdayType.FIFTH));

        // Agosto
        calFecha.add(Calendar.MONTH, 1);
        builder = CalendarBuilder.of(calFecha.getTime());
        assertEquals(13, getDay(builder, SaturdayType.SECOND));
    }

    @Test(expected = IllegalArgumentException.class)
    public void junioNoTiene5Semanas() {
        builder = CalendarBuilder.of(calFecha.getTime());
        builder.toSaturday(5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ningunMesTiene6Semanas() {
        builder = CalendarBuilder.of(calFecha.getTime());
        builder.toSaturday(6);
    }

    private int getDay(CalendarBuilder value, SaturdayType type) {
        switch (type) {
        case FIRST:
            value.firstSaturday();
            break;
        case SECOND:
            value.toSaturday(2);
            break;
        case THIRD:
            value.toSaturday(3);
            break;
        case FOURTH:
            value.toSaturday(4);
            break;
        case FIFTH:
            value.toSaturday(5);
            break;
        case LAST:
            value.lastSaturday();
            break;
        default:
        }

        return value.build().get(Calendar.DAY_OF_MONTH);
    }
}
