package ventatelevisoresled;

import ventatelevisoresled.vista.VistaCliente;
import ventatelevisoresled.vista.VistaTelevisor;
import ventatelevisoresled.vista.VistaVenta;
import ventatelevisoresled.controlador.ControladorCliente;
import ventatelevisoresled.controlador.ControladorTelevisor;
import ventatelevisoresled.controlador.ControladorVenta;
import ventatelevisoresled.modelo.BaseDatos;

public class VentaTelevisoresLED {

    public static void main(String[] args) {
        // Crear instancia de la base de datos
        BaseDatos baseDatos = new BaseDatos();

        // Crear instancias de las vistas
        VistaCliente vistaCliente = new VistaCliente();
        VistaTelevisor vistaTelevisor = new VistaTelevisor();
        VistaVenta vistaVenta = new VistaVenta();

        // Crear instancias de los controladores
        ControladorCliente controladorCliente = new ControladorCliente(vistaCliente, baseDatos);
        ControladorTelevisor controladorTelevisor = new ControladorTelevisor(vistaTelevisor, baseDatos);
        ControladorVenta controladorVenta = new ControladorVenta(vistaVenta, baseDatos);

        // Mostrar las vistas
        vistaCliente.setVisible(true);
        vistaTelevisor.setVisible(true);
        vistaVenta.setVisible(true);
    }
}
