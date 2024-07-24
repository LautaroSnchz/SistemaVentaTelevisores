package ventatelevisoresled.modelo;

public class Televisor {
    
    private String marca;
    private String modelo;
    private double precio;

    public Televisor(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    // Getters y Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Televisor{" +
               "marca='" + marca + '\'' +
               ", modelo='" + modelo + '\'' +
               ", precio=" + precio +
               '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Televisor televisor = (Televisor) obj;

        return modelo != null ? modelo.equals(televisor.modelo) : televisor.modelo == null;
    }

    @Override
    public int hashCode() {
        return modelo != null ? modelo.hashCode() : 0;
    }
}
