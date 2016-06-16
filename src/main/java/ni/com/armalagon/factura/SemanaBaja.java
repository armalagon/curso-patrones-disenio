package ni.com.armalagon.factura;

import java.util.Date;

import ni.com.armalagon.util.DateUtils;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SemanaBaja implements SemanaCalculable {

    @Override
    public Semana calcular(Date fechaMovimiento) {
        int noSemana = DateUtils.semanaDe(fechaMovimiento);
        return new Semana(
                1 <= noSemana
                , 2 <= noSemana
                , 3 <= noSemana
                , 4 <= noSemana
                , 5 <= noSemana
                );
    }
}
