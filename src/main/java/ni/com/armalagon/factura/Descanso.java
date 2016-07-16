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
    }

    @Override
    public void validar() throws NovedadException {
        if (plaza == null || !plaza.isActivo()) {
            throw new NovedadException("El asegurado debe estar ACTIVO en la nomina");
        }
    }
}
