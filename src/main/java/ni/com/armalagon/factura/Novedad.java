package ni.com.armalagon.factura;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public abstract class Novedad {
    private static final Logger logger = Logger.getLogger(Novedad.class.getName());

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
        if (semanaCalculable == null) {
            throw new IllegalArgumentException("Se requiere la implementacion del calculo de las semanas");
        }
        this.calculoSemana = semanaCalculable;
    }

    public void calcularSemana() {
        if (calculoSemana == null) {
            throw new IllegalStateException("Se requiere la implementacion del calculo de las semanas");
        }

        if (calculoSemana instanceof SemanaAutomatica) {
            logger.info("Se realiza calculo de las semanas");
            semana = calculoSemana.calcular(fechaMovimiento);
        } else if (calculoSemana instanceof SemanaManual) {
            logger.info("La semana es manual, no se realiza ningun calculo");
        }
    }
}
