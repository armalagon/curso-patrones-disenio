package ni.com.armalagon.factura;

import java.util.Date;
import java.util.logging.Logger;

import ni.com.armalagon.modelo.Plaza;

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
    protected Periodo periodo;
    protected Plaza plaza;

    // ------------------------------------------------------------------------
    // Algoritmos
    // ------------------------------------------------------------------------
    protected SemanaCalculable calculoSemana;
    protected PeriodoValidable validarPeriodo;

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

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }

    public Plaza getPlaza() {
        return plaza;
    }

    public void setPlaza(Plaza plaza) {
        this.plaza = plaza;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemanaCalculable(SemanaCalculable semanaCalculable) {
        this.calculoSemana = semanaCalculable;
    }

    public void setValidarPeriodo(PeriodoValidable validarPeriodo) {
        this.validarPeriodo = validarPeriodo;
    }

    private void algoritmoRequerido() {
        if (calculoSemana == null) {
            throw new IllegalStateException("Se requiere la implementacion del calculo de las semanas");
        }
    }

    public void calcularSemana() {
        algoritmoRequerido();
        if (calculoSemana instanceof SemanaAutomatica) {
            logger.info("Se realiza calculo de las semanas");
            semana = calculoSemana.calcular(fechaMovimiento);
        } else if (calculoSemana instanceof SemanaManual) {
            logger.info("La semana es manual, no se realiza ningun calculo");
        }
    }

    public void calcularSemana(Semana semana) {
        algoritmoRequerido();
        if (calculoSemana instanceof SemanaManual) {
            // Validar semana 5 en periodos de 4
            if (semana.isSemana5() && Configuracion.getInstance().getPeriodo(fechaMovimiento).getTotalSemana() == 4) {
                String error = "No se puede marcar la semana 5, el mes de la fecha de movimiento solo tiene 4 semanas";
                throw new IllegalArgumentException(error);
            }
            this.semana = semana;
        } else {
            logger.info("No se actualizan las semanas porque el calculo es automatico");
        }
    }

    public abstract void validar() throws NovedadException;
}
