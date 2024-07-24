package ventatelevisoresled.controlador;

import ventatelevisoresled.modelo.BaseDatos;
import ventatelevisoresled.modelo.Cliente;
import ventatelevisoresled.vista.VistaCliente;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCliente {

    private VistaCliente vista;
    private BaseDatos baseDatos;

    public ControladorCliente(VistaCliente vista, BaseDatos baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;
        initController();
    }

    private void initController() {
        // Configurar los listeners de la vista
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarCliente();
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarCliente();
            }
        });

        vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarCliente();
            }
        });

        // Cargar la lista de clientes en la vista
        cargarClientes();
    }

    private void agregarCliente() {
        String nombre = vista.getTxtNombre().getText();
        String direccion = vista.getTxtDireccion().getText();
        // Crear un nuevo cliente
        Cliente nuevoCliente = new Cliente(nombre, direccion);
        // Agregar el cliente a la base de datos
        baseDatos.agregarCliente(nuevoCliente);
        // Actualizar la vista
        cargarClientes();
    }

    private void eliminarCliente() {
        String nombre = vista.getTxtNombre().getText();
        // Buscar el cliente en la base de datos
        Cliente clienteAEliminar = baseDatos.buscarClientePorNombre(nombre);
        if (clienteAEliminar != null) {
            baseDatos.eliminarCliente(clienteAEliminar);
            // Actualizar la vista
            cargarClientes();
        } else {
            vista.mostrarMensaje("Cliente no encontrado");
        }
    }

    private void modificarCliente() {
        String nombreActual = vista.getTxtNombre().getText();
        String nuevoNombre = vista.getTxtNuevoNombre().getText();
        String nuevaDireccion = vista.getTxtNuevaDireccion().getText();
        // Buscar el cliente en la base de datos
        Cliente clienteAModificar = baseDatos.buscarClientePorNombre(nombreActual);
        if (clienteAModificar != null) {
            // Modificar el cliente
            clienteAModificar.setNombre(nuevoNombre);
            clienteAModificar.setDireccion(nuevaDireccion);
            // Actualizar en la base de datos
            baseDatos.modificarCliente(clienteAModificar);
            // Actualizar la vista
            cargarClientes();
        } else {
            vista.mostrarMensaje("Cliente no encontrado");
        }
    }

    private void cargarClientes() {
        vista.getModeloListaClientes().clear();
        for (Cliente cliente : baseDatos.getClientes()) {
            vista.getModeloListaClientes().addElement(cliente.toString());
        }
    }
}
