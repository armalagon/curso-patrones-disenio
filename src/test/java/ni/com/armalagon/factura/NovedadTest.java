package ni.com.armalagon.factura;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

import org.junit.Before;
import org.junit.Ignore;
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
    @Ignore
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

    @Test
    @Ignore
    public void intercambiarAlgoritmo() {
        alta.calcularSemana();
        log(alta);

        logger.info("Alta como baja");
        alta.setSemanaCalculable(new SemanaBaja());
        alta.calcularSemana();
        log(alta);

        logger.info("Alta como descanso");
        alta.setSemanaCalculable(new SinCalculoSemana());
        alta.calcularSemana();
        log(alta);
    }

    @Test
    public void sobreescribirCalculo() {
        alta.calcularSemana();
        log(alta);
        logger.info("Se modifican las semanas");
        alta.setSemana(new Semana(false, false, true, true, true));
        log(alta);
        // Se sobreescribe el valor anterior
        // Error, no se debe permitir esto
        alta.calcularSemana();
        log(alta);
    }
}
