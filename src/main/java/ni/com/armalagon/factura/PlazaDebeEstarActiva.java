package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class PlazaDebeEstarActiva extends ValidacionNovedadDecorator {

    public PlazaDebeEstarActiva(Novedad novedad) {
        super(novedad);
        this.nombreMovimiento = novedad.getNombreMovimiento() + ", PlazaDebeEstarActiva";
    }

    @Override
    public void validar() throws NovedadException {
        novedad.validar();
        if (novedad.getPlaza() == null || !novedad.getPlaza().isActivo()) {
            throw new NovedadException("El asegurado debe estar ACTIVO en la nomina");
        }
    }
}
