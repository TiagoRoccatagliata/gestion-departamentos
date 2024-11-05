package models;

public class Departamento {
    private int id;
    private String ubicacion;
    private double precioCompra;
    private double precioEstimadoVenta;
    private String estadoRemodelacion;
    private double rentabilidadDeseada;

    // Constructor
    public Departamento(int id, String ubicacion, double precioCompra, double precioEstimadoVenta, String estadoRemodelacion, double rentabilidadDeseada) {
        this.id = id;
        this.ubicacion = ubicacion;
        this.precioCompra = precioCompra;
        this.precioEstimadoVenta = precioEstimadoVenta;
        this.estadoRemodelacion = estadoRemodelacion;
        this.rentabilidadDeseada = rentabilidadDeseada;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }
    public double getPrecioCompra() { return precioCompra; }
    public void setPrecioCompra(double precioCompra) { this.precioCompra = precioCompra; }
    public double getPrecioEstimadoVenta() { return precioEstimadoVenta; }
    public void setPrecioEstimadoVenta(double precioEstimadoVenta) { this.precioEstimadoVenta = precioEstimadoVenta; }
    public String getEstadoRemodelacion() { return estadoRemodelacion; }
    public void setEstadoRemodelacion(String estadoRemodelacion) { this.estadoRemodelacion = estadoRemodelacion; }
    public double getRentabilidadDeseada() { return rentabilidadDeseada; }
    public void setRentabilidadDeseada(double rentabilidadDeseada) { this.rentabilidadDeseada = rentabilidadDeseada; }
}