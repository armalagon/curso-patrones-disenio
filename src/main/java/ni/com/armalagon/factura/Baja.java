package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Baja extends Novedad {

    public Baja() {
        nombreMovimiento = "Baja";
        calculoSemana = new SemanaBaja();
        validarPeriodo = new FechaMovimientoEnRango();
    }

    @Override
    public void validar() throws NovedadException {
        validarPeriodo.validar(fechaMovimiento, periodo);
    }
}
