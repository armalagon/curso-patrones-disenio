package ni.com.armalagon.factura;

import java.util.Date;

import ni.com.armalagon.modelo.Plaza;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public abstract class ValidacionNovedadDecorator extends Novedad {
    protected Novedad novedad;

    public ValidacionNovedadDecorator(Novedad novedad) {
        this.novedad = novedad;
    }

    @Override
    public int getNss() {
        return novedad.getNss();
    };

    @Override
    public Date getFechaMovimiento() {
        return novedad.getFechaMovimiento();
    }

    @Override
    public Periodo getPeriodo() {
        return novedad.getPeriodo();
    }

    @Override
    public Plaza getPlaza() {
        return novedad.getPlaza();
    }
}
