package ni.com.armalagon.factura;

public class Persona {
    private String primerNombre;
    private String primerApellido;

    public Persona() {
    }

    public Persona(String primerNombre, String primerApellido) {
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    @Override
    public String toString() {
        return primerNombre + " " + primerApellido;
    }
}
