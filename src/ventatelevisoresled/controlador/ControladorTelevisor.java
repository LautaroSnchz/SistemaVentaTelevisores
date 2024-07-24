package ventatelevisoresled.controlador;

import ventatelevisoresled.modelo.BaseDatos;
import ventatelevisoresled.modelo.Televisor;
import ventatelevisoresled.vista.VistaTelevisor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorTelevisor {

    private VistaTelevisor vista;
    private BaseDatos baseDatos;

    public ControladorTelevisor(VistaTelevisor vista, BaseDatos baseDatos) {
        this.vista = vista;
        this.baseDatos = baseDatos;
        initController();
    }

    private void initController() {
        // Configurar los listeners de la vista
        vista.getBtnAgregar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregarTelevisor();
            }
        });

        vista.getBtnEliminar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarTelevisor();
            }
        });

        vista.getBtnModificar().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarTelevisor();
            }
        });

        // Cargar la lista de televisores en la vista
        cargarTelevisores();
    }

    private void agregarTelevisor() {
        String marca = vista.getTxtMarca().getText();
        String modelo = vista.getTxtModelo().getText();
        double precio = Double.parseDouble(vista.getTxtPrecio().getText());
        // Crear un nuevo televisor
        Televisor nuevoTelevisor = new Televisor(marca, modelo, precio);
        // Agregar el televisor a la base de datos
        baseDatos.agregarTelevisor(nuevoTelevisor);
        // Actualizar la vista
        cargarTelevisores();
    }

    private void eliminarTelevisor() {
        String modelo = vista.getTxtModelo().getText();
        // Buscar el televisor en la base de datos
        Televisor televisorAEliminar = baseDatos.buscarTelevisorPorModelo(modelo);
        if (televisorAEliminar != null) {
            baseDatos.eliminarTelevisor(televisorAEliminar);
            // Actualizar la vista
            cargarTelevisores();
        } else {
            vista.mostrarMensaje("Televisor no encontrado");
        }
    }

    private void modificarTelevisor() {
        String modeloActual = vista.getTxtModelo().getText();
        String nuevaMarca = vista.getTxtNuevaMarca().getText();
        String nuevoModelo = vista.getTxtNuevoModelo().getText();
        double nuevoPrecio = Double.parseDouble(vista.getTxtNuevoPrecio().getText());
        // Buscar el televisor en la base de datos
        Televisor televisorAModificar = baseDatos.buscarTelevisorPorModelo(modeloActual);
        if (televisorAModificar != null) {
            // Modificar el televisor
            televisorAModificar.setMarca(nuevaMarca);
            televisorAModificar.setModelo(nuevoModelo);
            televisorAModificar.setPrecio(nuevoPrecio);
            // Actualizar en la base de datos
            baseDatos.modificarTelevisor(televisorAModificar);
            // Actualizar la vista
            cargarTelevisores();
        } else {
            vista.mostrarMensaje("Televisor no encontrado");
        }
    }

    private void cargarTelevisores() {
        vista.getModeloListaTelevisores().clear();
        for (Televisor televisor : baseDatos.getTelevisores()) {
            vista.getModeloListaTelevisores().addElement(televisor.toString());
        }
    }
}
