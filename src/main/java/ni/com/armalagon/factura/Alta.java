package ni.com.armalagon.factura;

import java.util.Date;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Alta extends Novedad {

    public Alta() {
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

    public static void main(String... args) {
        /*
        Novedad descanso = new Descanso();
        descanso.setNss(16146068);
        descanso.setFechaMovimiento(new Date());
        descanso.calcularSemana();
        descanso.setSemana(new Semana(true, true, false, true, false));

        System.out.println("Alta como una alta...Semana: " + descanso.getSemana());
        */

        Periodo periodo = Periodo.crear(new Date());
        System.out.println("Periodo: " + periodo + "...# semanas: " + periodo.getTotalSemana());

        /*System.out.println("Periodo #1: " + Configuracion.getInstance().getPeriodo(201601)
                + ", # semana: " + Configuracion.getInstance().getPeriodo(201601).getTotalSemana());*/
        System.out.println("Periodo #2: " + Configuracion.getInstance().getPeriodo(201501)
                + ", # semana: " + Configuracion.getInstance().getPeriodo(201501).getTotalSemana());
    }
}
