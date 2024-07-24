package ventatelevisoresled.modelo;

import java.util.ArrayList;
import java.util.List;

public class BaseDatos {

    private List<Televisor> televisores;
    private List<Cliente> clientes;
    private List<Venta> ventas;

    public BaseDatos() {
        this.televisores = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        // Inicializar datos
        inicializarDatos();
    }

    public void inicializarDatos() {
        // Implementa la lógica para inicializar datos si es necesario
        System.out.println("Datos inicializados.");
        cargarDatosEjemplo();
    }

    private void cargarDatosEjemplo() {
        // Agregar algunos datos de ejemplo (puedes modificar esto según necesites)
        televisores.add(new Televisor("Samsung", "QLED", 1200.00));
        televisores.add(new Televisor("LG", "OLED", 1500.00));
        clientes.add(new Cliente("Juan Pérez", "Calle Falsa 123"));
        clientes.add(new Cliente("Ana Gómez", "Avenida Siempre Viva 742"));
    }

    // Métodos para gestionar televisores
    public void agregarTelevisor(Televisor televisor) {
        televisores.add(televisor);
    }

    public void eliminarTelevisor(Televisor televisor) {
        televisores.remove(televisor);
    }

    public void modificarTelevisor(Televisor televisor) {
        int index = televisores.indexOf(televisor);
        if (index != -1) {
            televisores.set(index, televisor);
        }
    }

    public Televisor buscarTelevisorPorModelo(String modelo) {
        for (Televisor televisor : televisores) {
            if (televisor.getModelo().equals(modelo)) {
                return televisor;
            }
        }
        return null;
    }

    public List<Televisor> getTelevisores() {
        return new ArrayList<>(televisores);
    }

    // Métodos para gestionar clientes
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void eliminarCliente(Cliente cliente) {
        clientes.remove(cliente);
    }

    public void modificarCliente(Cliente cliente) {
        int index = clientes.indexOf(cliente);
        if (index != -1) {
            clientes.set(index, cliente);
        }
    }

    public Cliente buscarClientePorNombre(String nombre) {
        for (Cliente cliente : clientes) {
            if (cliente.getNombre().equals(nombre)) {
                return cliente;
            }
        }
        return null;
    }

    public List<Cliente> getClientes() {
        return new ArrayList<>(clientes);
    }

    // Métodos para gestionar ventas
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    public void eliminarVenta(Venta venta) {
        ventas.remove(venta);
    }

    public void modificarVenta(Venta venta) {
        int index = ventas.indexOf(venta);
        if (index != -1) {
            ventas.set(index, venta);
        }
    }

    public Venta buscarVentaPorModelo(String modelo) {
        for (Venta venta : ventas) {
            if (venta.getModeloTelevisor().equals(modelo)) {
                return venta;
            }
        }
        return null;
    }

    public List<Venta> getVentas() {
        return new ArrayList<>(ventas);
    }
}
