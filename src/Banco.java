import java.util.ArrayList;

public class Banco {
    private ArrayList<Cliente> listaClientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        listaClientes.add(cliente);
    }

    public Cliente iniciarSesion(String codigoAcceso) {
        for (Cliente cliente : listaClientes) {
            if (cliente.validarCodigoAcceso(codigoAcceso)) {
                return cliente;
            }
        }
        return null;
    }

    public Cliente buscarClientePorNombre(String nombreCliente) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getNombre().equalsIgnoreCase(nombreCliente)) {
                return cliente;
            }
        }
        return null;
    }
}
