package ni.com.armalagon.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class FechaMovimientoEnRango implements PeriodoValidable {

    @Override
    public void validar(Date fechaMovimiento, Periodo periodo) throws NovedadException {
        Periodo fechaMov2Periodo = Configuracion.getInstance().getPeriodo(fechaMovimiento);

        if (fechaMov2Periodo.compareTo(periodo) > 0) {
            throw new NovedadException("La fecha de movimiento no puede ser posterior al periodo de factura");
        }
    }
}
