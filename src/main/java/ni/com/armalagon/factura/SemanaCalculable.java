package ni.com.armalagon.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public interface SemanaCalculable {
    Semana calcular(Date fechaMovimiento);
}
