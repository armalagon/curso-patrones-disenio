package ni.com.armalagon.modelo;

import java.util.Date;

/**
 *
 * @author aalaniz
 * @version 1.0
 * @since 1.0
 */
public class Plaza {
    private int registroPatronal;
    private int nomina;
    private int nss;
    private Date fechaIngreso;
    private boolean activo;

    public Plaza() {
    }

    public Plaza(int registroPatronal, int nomina, int nss, boolean activo) {
        this.registroPatronal = registroPatronal;
        this.nomina = nomina;
        this.nss = nss;
        this.activo = activo;
    }

    public int getRegistroPatronal() {
        return registroPatronal;
    }

    public void setRegistroPatronal(int registroPatronal) {
        this.registroPatronal = registroPatronal;
    }

    public int getNomina() {
        return nomina;
    }

    public void setNomina(int nomina) {
        this.nomina = nomina;
    }

    public int getNss() {
        return nss;
    }

    public void setNss(int nss) {
        this.nss = nss;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return new StringBuilder(Plaza.class.getName())
                .append("[")
                .append("registroPatronal=").append(registroPatronal)
                .append(",nomina=").append(nomina)
                .append(",nss=").append(nss)
                .append(",activo=").append(activo)
                .append("]").toString();
    }
}
