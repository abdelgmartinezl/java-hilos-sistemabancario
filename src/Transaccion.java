public class Transaccion implements Runnable {
    private CuentaBancaria cuenta;
    private boolean deposito;
    private int monto;

    public Transaccion(CuentaBancaria cuenta, boolean deposito, int monto) {
        this.cuenta = cuenta;
        this.deposito = deposito;
        this.monto = monto;
    }

    @Override
    public void run() {
        if (deposito) {
            cuenta.depositar(monto);
        } else {
            cuenta.retirar(monto);
        }
    }
}
