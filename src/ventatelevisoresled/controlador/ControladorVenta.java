package ventatelevisoresled.controlador;

import ventatelevisoresled.modelo.BaseDatos;
import ventatelevisoresled.modelo.Venta;
import ventatelevisoresled.vista.VistaVenta;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorVenta {

    private VistaVenta vista;
    private BaseDatos baseDatos;

    public ControladorVenta(VistaVenta vista, BaseDatos baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;
        initController();
    }

    private void initController() {
        // Configurar los listeners de la vista
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarVenta();
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarVenta();
            }
        });

        vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarVenta();
            }
        });

        // Cargar la lista de ventas en la vista
        cargarVentas();
    }

    private void agregarVenta() {
        String modeloTelevisor = vista.getTxtModeloTelevisor().getText();
        String nombreCliente = vista.getTxtNombreCliente().getText();
        double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        // Crear una nueva venta
        Venta nuevaVenta = new Venta(modeloTelevisor, nombreCliente, precio);
        // Agregar la venta a la base de datos
        baseDatos.agregarVenta(nuevaVenta);
        // Actualizar la vista
        cargarVentas();
    }

    private void eliminarVenta() {
        String modeloTelevisor = vista.getTxtModeloTelevisor().getText();
        // Buscar la venta en la base de datos
        Venta ventaAEliminar = baseDatos.buscarVentaPorModelo(modeloTelevisor);
        if (ventaAEliminar != null) {
            baseDatos.eliminarVenta(ventaAEliminar);
            // Actualizar la vista
            cargarVentas();
        } else {
            vista.mostrarMensaje("Venta no encontrada");
        }
    }

    private void modificarVenta() {
        String modeloTelevisorActual = vista.getTxtModeloTelevisor().getText();
        String nuevoNombreCliente = vista.getTxtNuevoNombreCliente().getText();
        double nuevoPrecio = Double.parseDouble(vista.getTxtNuevoPrecio().getText());
        // Buscar la venta en la base de datos
        Venta ventaAModificar = baseDatos.buscarVentaPorModelo(modeloTelevisorActual);
        if (ventaAModificar != null) {
            // Modificar la venta
            ventaAModificar.setNombreCliente(nuevoNombreCliente);
            ventaAModificar.setPrecio(nuevoPrecio);
            // Actualizar en la base de datos
            baseDatos.modificarVenta(ventaAModificar);
            // Actualizar la vista
            cargarVentas();
        } else {
            vista.mostrarMensaje("Venta no encontrada");
        }
    }

    private void cargarVentas() {
        vista.getModeloListaVentas().clear();
        for (Venta venta : baseDatos.getVentas()) {
            vista.getModeloListaVentas().addElement(venta.toString());
        }
    }
}
