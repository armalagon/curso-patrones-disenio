package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Alta extends Novedad {

    public Alta() {
        nombreMovimiento = "Alta";
        calculoSemana = new SemanaAlta();
        validarPeriodo = new FechaMovimientoEnRango();
    }

    @Override
    public void validar() throws NovedadException {
        validarPeriodo.validar(fechaMovimiento, periodo);
    }
}
