package ni.com.armalagon.factura;

import java.util.Date;
import java.util.logging.Logger;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SinSemana implements SemanaCalculable, SemanaAutomatica {
    private static final Logger logger = Logger.getLogger(SinSemana.class.getName());

    @Override
    public Semana calcular(Date fechaMovimiento) {
        logger.info("Sin semanas cotizadas");
        return new Semana(false, false, false, false, false);
    }
}
