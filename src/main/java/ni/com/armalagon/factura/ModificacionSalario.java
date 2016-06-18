package ni.com.armalagon.factura;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class ModificacionSalario extends Novedad {

    public ModificacionSalario() {
        calculoSemana = new SemanaAlta();
    }

    @Override
    public void calcularSemana() {
        semana = calculoSemana.calcular(fechaMovimiento);
    }

    @Override
    public void setSemana(Semana semana) {
        throw new UnsupportedOperationException("El calculo de la semana es automatico, operacion no soportada");
    }
}
