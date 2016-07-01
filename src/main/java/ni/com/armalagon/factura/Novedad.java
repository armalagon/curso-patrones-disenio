package ni.com.armalagon.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public abstract class Novedad {
    protected String nombreMovimiento;
    protected int nss;
    protected Date fechaMovimiento;
    protected Semana semana;

    protected SemanaCalculable calculoSemana;

    public String getNombreMovimiento() {
        return nombreMovimiento;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public Date getFechaMovimiento() {
        return fechaMovimiento;
    }

    public void setFechaMovimiento(Date fechaMovimiento) {
        this.fechaMovimiento = fechaMovimiento;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }

    public void setSemanaCalculable(SemanaCalculable semanaCalculable) {
        this.calculoSemana = semanaCalculable;
    }

    public void calcularSemana() {
        if (calculoSemana == null) {
            throw new IllegalStateException("Se requiere la implementacion del calculo de las semanas");
        }

        if (calculoSemana instanceof SemanaAutomatica) {
            semana = calculoSemana.calcular(fechaMovimiento);
        } else if (calculoSemana instanceof SemanaManual) {
            // Se deja el ultimo valor
        }
    }
}
