package ventatelevisoresled.modelo;

public class Venta {
    
    private String modeloTelevisor;
    private String nombreCliente;
    private double precio;

    public Venta(String modeloTelevisor, String nombreCliente, double precio) {
        this.modeloTelevisor = modeloTelevisor;
        this.nombreCliente = nombreCliente;
        this.precio = precio;
    }

    // Getters y Setters
    public String getModeloTelevisor() {
        return modeloTelevisor;
    }

    public void setModeloTelevisor(String modeloTelevisor) {
        this.modeloTelevisor = modeloTelevisor;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Venta{" +
               "modeloTelevisor='" + modeloTelevisor + '\'' +
               ", nombreCliente='" + nombreCliente + '\'' +
               ", precio=" + precio +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Venta venta = (Venta) obj;

        return modeloTelevisor != null ? modeloTelevisor.equals(venta.modeloTelevisor) : venta.modeloTelevisor == null;
    }

    @Override
    public int hashCode() {
        return modeloTelevisor != null ? modeloTelevisor.hashCode() : 0;
    }
}
