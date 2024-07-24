package ventatelevisoresled.vista;

import javax.swing.*;
import java.awt.*;

public class VistaVenta extends JFrame {

    private JTextField txtModeloTelevisor;
    private JTextField txtNombreCliente;
    private JTextField txtPrecio;
    private JTextField txtNuevoNombreCliente;
    private JTextField txtNuevoPrecio;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JList<String> listaVentas;
    private DefaultListModel<String> modeloListaVentas;

    public VistaVenta() {
        setTitle("Gestión de Ventas");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(5, 2));

        panelFormulario.add(new JLabel("Modelo Televisor:"));
        txtModeloTelevisor = new JTextField();
        panelFormulario.add(txtModeloTelevisor);

        panelFormulario.add(new JLabel("Nombre Cliente:"));
        txtNombreCliente = new JTextField();
        panelFormulario.add(txtNombreCliente);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Nuevo Nombre Cliente:"));
        txtNuevoNombreCliente = new JTextField();
        panelFormulario.add(txtNuevoNombreCliente);

        panelFormulario.add(new JLabel("Nuevo Precio:"));
        txtNuevoPrecio = new JTextField();
        panelFormulario.add(txtNuevoPrecio);

        // Panel de botones
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new FlowLayout());

        btnAgregar = new JButton("Agregar");
        panelBotones.add(btnAgregar);

        btnEliminar = new JButton("Eliminar");
        panelBotones.add(btnEliminar);

        btnModificar = new JButton("Modificar");
        panelBotones.add(btnModificar);

        // Panel de lista
        JPanel panelLista = new JPanel();
        panelLista.setLayout(new BorderLayout());

        modeloListaVentas = new DefaultListModel<>();
        listaVentas = new JList<>(modeloListaVentas);
        JScrollPane scrollPane = new JScrollPane(listaVentas);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        // Agregar componentes a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelLista, BorderLayout.SOUTH);
    }

    // Getters
    public JTextField getTxtModeloTelevisor() {
        return txtModeloTelevisor;
    }

    public JTextField getTxtNombreCliente() {
        return txtNombreCliente;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JTextField getTxtNuevoNombreCliente() {
        return txtNuevoNombreCliente;
    }

    public JTextField getTxtNuevoPrecio() {
        return txtNuevoPrecio;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public DefaultListModel<String> getModeloListaVentas() {
        return modeloListaVentas;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
