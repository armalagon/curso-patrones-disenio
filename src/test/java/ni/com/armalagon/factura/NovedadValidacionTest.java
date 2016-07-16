package ni.com.armalagon.factura;

import java.util.Date;

import org.junit.Test;

import ni.com.armalagon.modelo.Plaza;

/**
 *
 * @author aalaniz
 * @version 1.0
 * @since 1.0
 */
public class NovedadValidacionTest {
    private Novedad novedad;

    public void config(int tipoMovimiento) {
        switch (tipoMovimiento) {
            case 1:
                novedad = new Alta();
                break;
            case 2:
                novedad = new Baja();
                break;
            case 3:
                novedad = new ModificacionSalario();
                break;
            case 8:
                novedad = new Salida();
                break;
            case 9:
                novedad = new Descanso();
                break;
            default:
                System.out.println("Tipo no soportado");
        }

        novedad.setNss(16146068);
        novedad.setFechaMovimiento(new Date());
        novedad.setPeriodo(Configuracion.getInstance().getPeriodo());
        novedad.setPlaza(null);
    }

    @Test
    public void plazaDebeSerNulaInactiva() throws NovedadException {
        config(1);

        try {
            novedad.validar();
            // El asegurado esta INACTIVO en la nomina
            novedad.setPlaza(new Plaza(18, 26, 16146068, false));
            novedad.validar();
        } catch (NovedadException exc) {
            throw exc;
        }
    }

    @Test(expected = NovedadException.class)
    public void altaConPlazaActiva() throws NovedadException {
        config(1);

        try {
            // Plaza activa
            novedad.setPlaza(new Plaza(18, 26, 16146068, true));
            novedad.validar();
        } catch (NovedadException exc) {
            exc.printStackTrace();
            throw exc;
        }
    }

    @Test(expected = NovedadException.class)
    public void bajaConPlazaInactiva() throws NovedadException {
        config(2);

        try {
            // Plaza no existe
            novedad.validar();
        } catch (NovedadException exc) {
            exc.printStackTrace();
            throw exc;
        }
    }
}
