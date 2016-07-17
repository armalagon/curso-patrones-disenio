package ni.com.armalagon.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public interface PeriodoValidable {
    void validar(Date fechaMovimiento, Periodo periodo) throws NovedadException;
}
