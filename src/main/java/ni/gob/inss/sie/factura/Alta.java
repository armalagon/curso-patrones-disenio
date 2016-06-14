package ni.gob.inss.sie.factura;

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

    public static void main(String... args) {
        Novedad alta = new Alta();
        alta.setNss(16146068);
        alta.setFechaMovimiento(new Date());
        alta.calcularSemana();

        System.out.println("Alta como una alta...Semana: " + alta.getSemana());

        alta.setSemanaCalculable(new SemanaBaja());
        alta.calcularSemana();
        System.out.println("Alta como una baja...Semana: " + alta.getSemana());

        Periodo periodo = Periodo.crear(new Date());
        System.out.println("Periodo: " + periodo + "...# semanas: " + periodo.getTotalSemana() + "...semana: " + periodo.getFormatoCadena());

        System.out.println("Periodo #1: " + Configuracion.getInstance().getPeriodo(201601));
    }
}
