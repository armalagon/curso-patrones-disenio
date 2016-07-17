package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class PlazaNoDebeEstarActiva extends ValidacionNovedadDecorator {

    public PlazaNoDebeEstarActiva(Novedad novedad) {
        super(novedad);
        this.nombreMovimiento = novedad.getNombreMovimiento() + ", PlazaNoDebeEstarActiva";
    }

    @Override
    public void validar() throws NovedadException {
        novedad.validar();
        if (novedad.getPlaza() != null && novedad.getPlaza().isActivo()) {
            throw new NovedadException("El asegurado ya se encuentra ACTIVO en la nomina");
        }
    }
}
