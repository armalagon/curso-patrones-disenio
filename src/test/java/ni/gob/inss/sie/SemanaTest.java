package ni.gob.inss.sie;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ni.com.armalagon.factura.Semana;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class SemanaTest {
    private Semana semana;

    @Test
    public void calculoConSemanasCotizadas() {
        semana = new Semana(false, false, true, false, true);
        assertEquals(3, semana.getPrimeraSemana());
        assertEquals(5, semana.getUltimaSemana());

        semana = new Semana(true, false, true, false, false);
        assertEquals(1, semana.getPrimeraSemana());
        assertEquals(3, semana.getUltimaSemana());

        semana = new Semana(false, true, true, false, false);
        assertEquals(2, semana.getPrimeraSemana());
        assertEquals(3, semana.getUltimaSemana());

        semana = new Semana(false, false, true, true, false);
        assertEquals(3, semana.getPrimeraSemana());
        assertEquals(4, semana.getUltimaSemana());
    }

    @Test
    public void calculoConUnaSemana() {
        semana = new Semana(false, false, true, false, false);
        assertEquals(3, semana.getPrimeraSemana());
        assertEquals(3, semana.getUltimaSemana());

        semana = new Semana(false, false, false, false, true);
        assertEquals(5, semana.getPrimeraSemana());
        assertEquals(5, semana.getUltimaSemana());
    }

    @Test
    public void calculoSinSemana() {
        semana = new Semana(false, false, false, false, false);
        assertEquals(0, semana.getPrimeraSemana());
        assertEquals(0, semana.getUltimaSemana());
    }
}
