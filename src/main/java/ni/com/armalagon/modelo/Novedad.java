package ni.com.armalagon.modelo;

import java.io.Serializable;
import java.util.Date;

import ni.com.armalagon.factura.Semana;

/**
 *
 * @author armalagon
 * @version 1.0
 * @since 1.0
 */
public class Novedad implements Serializable {
    private static final long serialVersionUID = -4255849171280077724L;

    private Integer id;
    private Integer nss;
    private Integer idTipoNovedad;
    private Date fechaNovedad;
    private Integer periodo;
    private Semana semana;

    public Novedad() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNss() {
        return nss;
    }

    public void setNss(Integer nss) {
        this.nss = nss;
    }

    public Integer getIdTipoNovedad() {
        return idTipoNovedad;
    }

    public void setIdTipoNovedad(Integer idTipoNovedad) {
        this.idTipoNovedad = idTipoNovedad;
    }

    public Date getFechaNovedad() {
        return fechaNovedad;
    }

    public void setFechaNovedad(Date fechaNovedad) {
        this.fechaNovedad = fechaNovedad;
    }

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    public Semana getSemana() {
        return semana;
    }

    public void setSemana(Semana semana) {
        this.semana = semana;
    }
}
