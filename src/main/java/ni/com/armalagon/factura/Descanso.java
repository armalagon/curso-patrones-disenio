package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Descanso extends Novedad {

    public Descanso() {
        nombreMovimiento = "Descanso";
        calculoSemana = new SinCalculoSemana();
        validarPeriodo = new FechaMovimientoEnRango();
    }

    @Override
    public void validar() throws NovedadException {
        validarPeriodo.validar(fechaMovimiento, periodo);
    }
}
