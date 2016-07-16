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
    }

    @Override
    public void validar() throws NovedadException {
        if (plaza != null && plaza.isActivo()) {
            throw new NovedadException("El asegurado ya se encuentra ACTIVO en la nomina");
        }
    }
}
