package ventatelevisoresled.vista;

import javax.swing.*;
import java.awt.*;

public class VistaCliente extends JFrame {

    private JTextField txtNombre;
    private JTextField txtDireccion;
    private JTextField txtNuevoNombre;
    private JTextField txtNuevaDireccion;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JList<String> listaClientes;
    private DefaultListModel<String> modeloListaClientes;

    public VistaCliente() {
        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(4, 2));

        panelFormulario.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Dirección:"));
        txtDireccion = new JTextField();
        panelFormulario.add(txtDireccion);

        panelFormulario.add(new JLabel("Nuevo Nombre:"));
        txtNuevoNombre = new JTextField();
        panelFormulario.add(txtNuevoNombre);

        panelFormulario.add(new JLabel("Nueva Dirección:"));
        txtNuevaDireccion = new JTextField();
        panelFormulario.add(txtNuevaDireccion);

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

        modeloListaClientes = new DefaultListModel<>();
        listaClientes = new JList<>(modeloListaClientes);
        JScrollPane scrollPane = new JScrollPane(listaClientes);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        // Agregar componentes a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelLista, BorderLayout.SOUTH);
    }

    // Getters
    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public JTextField getTxtDireccion() {
        return txtDireccion;
    }

    public JTextField getTxtNuevoNombre() {
        return txtNuevoNombre;
    }

    public JTextField getTxtNuevaDireccion() {
        return txtNuevaDireccion;
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

    public DefaultListModel<String> getModeloListaClientes() {
        return modeloListaClientes;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
