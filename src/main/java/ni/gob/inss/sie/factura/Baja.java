package ni.gob.inss.sie.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Baja extends Novedad {

    public Baja() {
        calculoSemana = new SemanaBaja();
    }

    @Override
    public void calcularSemana() {
        semana = calculoSemana.calcular(fechaMovimiento);
    }
}
