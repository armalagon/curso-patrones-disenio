package ni.com.armalagon.factura;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SinCalculoSemana implements SemanaCalculable, SemanaManual {
    private static final Logger logger = Logger.getLogger(SemanaBaja.class.getName());

    @Override
    public Semana calcular(Date fechaMovimiento) {
        logger.info("No se realiza calculo de semana");
        return null;
    }
}
