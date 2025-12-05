public class Cliente {
    private String nombre;
    private String codigoAcceso;
    private Cuenta cuenta;

    public Cliente(String nombre, String codigoAcceso, Cuenta cuenta) {
        this.nombre = nombre;
        this.codigoAcceso = codigoAcceso;
        this.cuenta = cuenta;
    }

    public String getNombre() {
        return nombre;
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public boolean validarCodigoAcceso(String codigoIngresado) {
        return codigoIngresado.equals(codigoAcceso);
    }
}
