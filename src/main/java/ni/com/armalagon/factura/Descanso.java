package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Descanso extends Novedad {

    public Descanso() {
    }

    @Override
    public void calcularSemana() {
        System.out.println("El calculo de la semana es manual, no se realiza calculo");
    }
}
