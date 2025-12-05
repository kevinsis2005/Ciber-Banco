import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        UsuariosBanco.cargarUsuarios(banco);

        System.out.println("*******");
        System.out.println("Bienvenido al CiberBanco");

        Scanner entrada = new Scanner(System.in);
        Cliente clienteSesion = null;

        // INICIO DE SESIÓN
        while (clienteSesion == null) {
            System.out.print("Ingrese su código de acceso: ");
            String codigoIngresado = entrada.nextLine();

            clienteSesion = banco.iniciarSesion(codigoIngresado);

            if (clienteSesion == null) {
                System.out.println("Código incorrecto.");
                System.out.print("¿Desea intentar otra vez? (si/no): ");
                String respuestaUsuario = entrada.nextLine();
                if (!respuestaUsuario.equalsIgnoreCase("si")) {
                    System.out.println("Saliendo...");
                    return;
                }
            }
        }

        System.out.println("Acceso concedido\n");

        // MOSTRAR INFORMACIÓN DEL CLIENTE
        Cuenta cuenta = clienteSesion.getCuenta();
        System.out.println("*******");
        System.out.println("=== Información del cliente ===");
        System.out.printf("Nombre del cliente: %s%n", clienteSesion.getNombre());
        System.out.printf("El tipo de cuenta es: %s%n", cuenta.getTipoDeCuenta());
        System.out.printf("El número de cuenta es: %s%n", cuenta.getNumeroDeCuenta());
        System.out.printf("Su saldo disponible es: %.2f%n", cuenta.getSaldo());
        System.out.println("*******");

        int opcionSeleccionada = 0;

        // MENÚ PRINCIPAL
        while (opcionSeleccionada != 5) {
            System.out.println("\n----- Menú -----");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Retirar dinero");
            System.out.println("3. Depositar dinero");
            System.out.println("4. Transferir dinero");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            opcionSeleccionada = Integer.parseInt(entrada.nextLine());

            switch (opcionSeleccionada) {
                case 1:
                    System.out.printf("Saldo actual: %.2f%n", clienteSesion.getCuenta().getSaldo());
                    break;

                case 2:
                    System.out.print("Monto a retirar: ");
                    double montoARetirar = Double.parseDouble(entrada.nextLine());
                    if (clienteSesion.getCuenta().retirar(montoARetirar)) {
                        System.out.printf("Retiro exitoso. Nuevo saldo: %.2f%n", clienteSesion.getCuenta().getSaldo());
                    } else {
                        System.out.println("Saldo insuficiente.");
                    }
                    break;

                case 3:
                    System.out.print("Monto a depositar: ");
                    double montoADepositar = Double.parseDouble(entrada.nextLine());
                    clienteSesion.getCuenta().depositar(montoADepositar);
                    System.out.printf("Depósito exitoso. Nuevo saldo: %.2f%n", clienteSesion.getCuenta().getSaldo());
                    break;

                case 4:
                    System.out.print("Monto a transferir: ");
                    double montoATransferir = Double.parseDouble(entrada.nextLine());
                    System.out.print("Nombre del destinatario: ");
                    String nombreDestinatario = entrada.nextLine();

                    Cliente clienteDestinatario = banco.buscarClientePorNombre(nombreDestinatario);

                    if (clienteDestinatario == null) {
                        System.out.println("No se encontró el destinatario.");
                    } else {
                        if (clienteSesion.getCuenta().transferir(montoATransferir, clienteDestinatario.getCuenta())) {
                            System.out.println("Transferencia realizada.");
                            System.out.printf("Nuevo saldo: %.2f%n", clienteSesion.getCuenta().getSaldo());
                        } else {
                            System.out.println("Saldo insuficiente.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Gracias por usar el CiberBanco.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
