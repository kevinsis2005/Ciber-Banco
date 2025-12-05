public class Cuenta {
    private String numeroDeCuenta;
    private String tipoDeCuenta;
    private double saldo;

    public Cuenta(String numeroDeCuenta, String tipoDeCuenta, double saldoInicial) {
        this.numeroDeCuenta = numeroDeCuenta;
        this.tipoDeCuenta = tipoDeCuenta;
        this.saldo = saldoInicial;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getNumeroDeCuenta() {
        return numeroDeCuenta;
    }

    public String getTipoDeCuenta() {
        return tipoDeCuenta;
    }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > saldo) {
            return false;
        }
        saldo -= monto;
        return true;
    }

    public boolean transferir(double monto, Cuenta cuentaDestino) {
        if (monto > saldo) {
            return false;
        }
        saldo -= monto;
        cuentaDestino.depositar(monto);
        return true;
    }
}
