package ni.com.armalagon.factura;

import java.util.Date;
import java.util.logging.Logger;

import ni.com.armalagon.util.DateUtils;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SemanaAlta implements SemanaCalculable, SemanaAutomatica {
    private static final Logger logger = Logger.getLogger(SemanaAlta.class.getName());

    @Override
    public Semana calcular(Date fechaMovimiento) {
        logger.info("Se realiza calculo de semana como Alta");
        int noSemana = DateUtils.semanaDe(fechaMovimiento);
        boolean periodo5Semanas = DateUtils.totalSemana(fechaMovimiento) == 5;
        return new Semana(
                1 >= noSemana
                , 2 >= noSemana
                , 3 >= noSemana
                , 4 >= noSemana
                , 5 >= noSemana && periodo5Semanas
                );
    }
}
