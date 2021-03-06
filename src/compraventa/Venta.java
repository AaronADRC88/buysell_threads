package compraventa;

import java.awt.HeadlessException;
import javax.swing.JOptionPane;

public class Venta extends Thread {

    double cantidad = 0;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public Venta() {

    }

    public double introduceCantidad() {

        try {
            do {
                cantidad = Double.parseDouble(JOptionPane.showInputDialog(null, "introduce el coste del producto", "", JOptionPane.PLAIN_MESSAGE));
            } while (cantidad <= 0);
            return cantidad;
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Introduce un valor válido", "ERROR", JOptionPane.WARNING_MESSAGE);
            this.introduceCantidad();
        }
        return cantidad;
    }

    @Override
    public void run() {
        while (CompraVenta.running) {
            this.introduceCantidad();
            CompraVenta.cash = CompraVenta.cash + this.getCantidad();
            JOptionPane.showMessageDialog(null, "Saldo actual= " + CompraVenta.cash);

        }

    }
}
