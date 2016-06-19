package ni.com.armalagon.factura;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import ni.com.armalagon.util.DateUtils;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Periodo {
    private final int anio, mes;
    private final String formatoCadena; // MMMyyyy
    private final int formatoNumerico;
    private final int totalSemana;

    public Periodo(int anio, int mes) {
        this.anio = anio;
        this.mes = mes;
        formatoNumerico = anio*100 + mes;
        formatoCadena = (mes < 10 ? "0" : "") + String.valueOf(mes) + String.valueOf(anio);
        totalSemana = DateUtils.totalSemana(DateUtils.crearPrimerDia(anio, mes));
    }

    public int getAnio() {
        return anio;
    }

    public int getMes() {
        return mes;
    }

    public String getFormatoCadena() {
        return formatoCadena;
    }

    public int getFormatoNumerico() {
        return formatoNumerico;
    }

    public int getTotalSemana() {
        return totalSemana;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(31, 17).append(formatoNumerico).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Periodo))
            return false;
        Periodo other = (Periodo) obj;
        return new EqualsBuilder().append(formatoNumerico, other.formatoNumerico).isEquals();
    }

    @Override
    public String toString() {
        return new StringBuilder(Periodo.class.getName()).append("[").append(formatoNumerico).append("]").toString();
    }

    public static Periodo crear(final Date fecha) {
        Calendar cal = GregorianCalendar.getInstance();
        cal.setTime(fecha);
        return new Periodo(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1);
    }

    public static Periodo crear(int periodo) {
        int anio = periodo/100;
        int mes = periodo - anio*100;
        return new Periodo(anio, mes);
    }

    public static Periodo crear(String periodo) {
        int anio = Integer.parseInt(StringUtils.right(periodo, 4));
        int mes = Integer.parseInt(StringUtils.left(periodo, 2));
        return new Periodo(anio, mes);
    }
}
