package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Salida extends Novedad {

    public Salida() {
        nombreMovimiento = "Salida";
        calculoSemana = new SinSemana();
    }

    @Override
    public void validar() throws NovedadException {
        if (plaza == null || !plaza.isActivo()) {
            throw new NovedadException("El asegurado debe estar ACTIVO en la nomina");
        }
    }
}
