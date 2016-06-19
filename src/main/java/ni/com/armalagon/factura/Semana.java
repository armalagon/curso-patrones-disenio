package ni.com.armalagon.factura;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Semana {
    private final boolean semana1;
    private final boolean semana2;
    private final boolean semana3;
    private final boolean semana4;
    private final boolean semana5;
    private int primeraSemana;
    private int ultimaSemana;

    public Semana(boolean semana1, boolean semana2, boolean semana3, boolean semana4, boolean semana5) {
        this.semana1 = semana1;
        this.semana2 = semana2;
        this.semana3 = semana3;
        this.semana4 = semana4;
        this.semana5 = semana5;
        calcularSemanas();
    }

    public boolean isSemana1() {
        return semana1;
    }

    public boolean isSemana2() {
        return semana2;
    }

    public boolean isSemana3() {
        return semana3;
    }

    public boolean isSemana4() {
        return semana4;
    }

    public boolean isSemana5() {
        return semana5;
    }

    public int getPrimeraSemana() {
        return primeraSemana;
    }

    public int getUltimaSemana() {
        return ultimaSemana;
    }

    private void calcularSemanas() {
        String tramaSemanas = (semana1 ? "1" : "0") + (semana2 ? "1" : "0") + (semana3 ? "1" : "0")
            + (semana4 ? "1" : "0") + (semana5 ? "1" : "0");

        primeraSemana = tramaSemanas.indexOf('1') + 1;
        ultimaSemana = tramaSemanas.lastIndexOf("1") + 1;
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(7, 51)
                .append(semana1)
                .append(semana2)
                .append(semana3)
                .append(semana4)
                .append(semana5).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Semana))
            return false;
        Semana other = (Semana) obj;
        return new EqualsBuilder()
                .append(semana1, other.semana1)
                .append(semana2, other.semana2)
                .append(semana3, other.semana3)
                .append(semana4, other.semana4)
                .append(semana5, other.semana5).isEquals();
    }

    @Override
    public String toString() {
        return new StringBuilder(Semana.class.getName())
                .append("[")
                .append(semana1 ? "1" : "0")
                .append(semana2 ? "1" : "0")
                .append(semana3 ? "1" : "0")
                .append(semana4 ? "1" : "0")
                .append(semana5 ? "1" : "0")
                .append("]").toString();
    }
}
