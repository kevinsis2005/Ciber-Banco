public class UsuariosBanco {
    public static void cargarUsuarios(Banco banco) {
        Cliente clienteSteven = new Cliente("Steven Rogers", "12345", new Cuenta("8021902", "Corriente", 4000.99));
        Cliente clienteTony = new Cliente("Tony Stark", "54321", new Cuenta("8021903", "Ahorros", 10000.50));
        Cliente clienteNatasha = new Cliente("Natasha Romanoff", "11111", new Cuenta("8021904", "Corriente", 7500.00));
        Cliente clienteBruce = new Cliente("Bruce Banner", "22222", new Cuenta("8021905", "Ahorros", 5000.75));

        banco.agregarCliente(clienteSteven);
        banco.agregarCliente(clienteTony);
        banco.agregarCliente(clienteNatasha);
        banco.agregarCliente(clienteBruce);
    }
}
