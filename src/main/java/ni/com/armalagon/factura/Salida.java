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
}
