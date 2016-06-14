package ni.gob.inss.sie.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SinSemana implements SemanaCalculable {

    @Override
    public Semana calcular(Date fechaMovimiento) {
        return new Semana(false, false, false, false, false);
    }
}
