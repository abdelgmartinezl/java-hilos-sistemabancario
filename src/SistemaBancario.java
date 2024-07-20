public class SistemaBancario {
    public static void main(String[] args) {
        CuentaBancaria cuenta = new CuentaBancaria(1000);

        Thread t1 = new Thread(new Transaccion(cuenta, true, 500), "Thread-1");
        Thread t2 = new Thread(new Transaccion(cuenta, true, 500), "Thread-2");
        Thread t3 = new Thread(new Transaccion(cuenta, true, 500), "Thread-3");
        Thread t4 = new Thread(new Transaccion(cuenta, true, 500), "Thread-4");
        Thread t5 = new Thread(new Transaccion(cuenta, true, 500), "Thread-5");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

        try {
            t1.join();
            t2.join();
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Saldo Final: " + cuenta.get_saldo());
    }
}
