package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class ModificacionSalario extends Novedad {

    public ModificacionSalario() {
        nombreMovimiento = "Modificacion Salario";
        calculoSemana = new SemanaAlta();
        validarPeriodo = new FechaMovimientoEnRango();
    }

    @Override
    public void validar() throws NovedadException {
        validarPeriodo.validar(fechaMovimiento, periodo);
    }
}
