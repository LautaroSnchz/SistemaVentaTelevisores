package ventatelevisoresled.vista;

import javax.swing.*;
import java.awt.*;

public class VistaTelevisor extends JFrame {

    private JTextField txtMarca;
    private JTextField txtModelo;
    private JTextField txtPrecio;
    private JTextField txtNuevaMarca;
    private JTextField txtNuevoModelo;
    private JTextField txtNuevoPrecio;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private JButton btnModificar;
    private JList<String> listaTelevisores;
    private DefaultListModel<String> modeloListaTelevisores;

    public VistaTelevisor() {
        setTitle("Gestión de Televisores");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        initComponents();
    }

    private void initComponents() {
        // Panel de formulario
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(6, 2));

        panelFormulario.add(new JLabel("Marca:"));
        txtMarca = new JTextField();
        panelFormulario.add(txtMarca);

        panelFormulario.add(new JLabel("Modelo:"));
        txtModelo = new JTextField();
        panelFormulario.add(txtModelo);

        panelFormulario.add(new JLabel("Precio:"));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Nueva Marca:"));
        txtNuevaMarca = new JTextField();
        panelFormulario.add(txtNuevaMarca);

        panelFormulario.add(new JLabel("Nuevo Modelo:"));
        txtNuevoModelo = new JTextField();
        panelFormulario.add(txtNuevoModelo);

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

        modeloListaTelevisores = new DefaultListModel<>();
        listaTelevisores = new JList<>(modeloListaTelevisores);
        JScrollPane scrollPane = new JScrollPane(listaTelevisores);
        panelLista.add(scrollPane, BorderLayout.CENTER);

        // Agregar componentes a la ventana
        add(panelFormulario, BorderLayout.NORTH);
        add(panelBotones, BorderLayout.CENTER);
        add(panelLista, BorderLayout.SOUTH);
    }

    // Getters
    public JTextField getTxtMarca() {
        return txtMarca;
    }

    public JTextField getTxtModelo() {
        return txtModelo;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public JTextField getTxtNuevaMarca() {
        return txtNuevaMarca;
    }

    public JTextField getTxtNuevoModelo() {
        return txtNuevoModelo;
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

    public DefaultListModel<String> getModeloListaTelevisores() {
        return modeloListaTelevisores;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}
