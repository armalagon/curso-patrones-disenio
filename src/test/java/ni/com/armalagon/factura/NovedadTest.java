package ni.com.armalagon.factura;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class NovedadTest {
    private static final Logger logger = Logger.getLogger(NovedadTest.class.getName());

    private SimpleDateFormat format;
    private Novedad alta;
    private Novedad baja;
    private Novedad modif;
    private Novedad salida;
    private Novedad descanso;

    public NovedadTest() {
        format = new SimpleDateFormat("dd/MM/yyyy");
    }

    @Before
    public void config() {
        alta = new Alta();
        initNovedad(alta);

        baja = new Baja();
        initNovedad(baja);

        modif = new ModificacionSalario();
        initNovedad(modif);

        salida = new Salida();
        initNovedad(salida);

        descanso = new Descanso();
        initNovedad(descanso);
    }

    private void initNovedad(Novedad nov) {
        nov.setNss(16146068);
        nov.setFechaMovimiento(new Date());
    }

    private void log(Novedad nov) {
        logger.info("*****" + nov.getNombreMovimiento() + "[fecha=" + format.format(nov.getFechaMovimiento())
                + ",semana=" + nov.getSemana() + "]");
    }

    @Test
    public void noCambiarAlgoritmo() {
        alta.calcularSemana();
        log(alta);

        baja.calcularSemana();
        log(baja);

        modif.calcularSemana();
        log(modif);

        salida.calcularSemana();
        log(salida);

        descanso.calcularSemana();
        log(descanso);
    }
}
