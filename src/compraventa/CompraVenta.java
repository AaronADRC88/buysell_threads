package compraventa;

import javax.swing.JOptionPane;

public class CompraVenta {

    static double cash = 1000.0;
    static int shop = JOptionPane.showOptionDialog(null, "escoge la operación a realizar", "Gestiona la tienda", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, new Object[]{"realizar venta ", "realizar compra", "salir"}, "salir");
    public static volatile boolean running = true;
    static void kill(){
        running = false;
    }

    public static void main(String[] args) {

        do {
            switch (shop) {
                case 0:
                    Venta venta = new Venta();
                    venta.start();
                   CompraVenta.kill();
                    break;
                case 1:
                    new Compra().start();
                    break;
                case 2:
                    System.exit(0);
            }
        } while (shop != -1 && shop != 2);

    }

}
