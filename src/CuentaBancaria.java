public class CuentaBancaria {
    private int saldo;

    public CuentaBancaria(int saldoinicial) {
        this.saldo = saldoinicial;
    }

    public synchronized void depositar(int monto) {
        this.saldo += monto;
        System.out.println(Thread.currentThread().getName() + " ha depositado " + monto + ". Saldo: " + this.saldo);
    }

    public synchronized void retirar(int monto) {
        if (this.saldo >= monto) {
            this.saldo -= monto;
            System.out.println(Thread.currentThread().getName() + " ha retirado " + monto + ". Saldo: " + this.saldo);
        } else {
            System.out.println(Thread.currentThread().getName() + " intento retirar " + monto + "pero no tiene saldo suficiente. Saldo: " + this.saldo);
        }
    }

    public int get_saldo() {
        return this.saldo;
    }
}
