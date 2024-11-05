package models;

public class Gasto {
    private int id;
    private int departamentoId;
    private String categoria;
    private double monto;
    private String fecha;

    // Constructor
    public Gasto(int id, int departamentoId, String categoria, double monto, String fecha) {
        this.id = id;
        this.departamentoId = departamentoId;
        this.categoria = categoria;
        this.monto = monto;
        this.fecha = fecha;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getMonto() { return monto; }
    public void setMonto(double monto) { this.monto = monto; }
    public String getFecha() { return fecha; }
    public void setFecha(String fecha) { this.fecha = fecha; }
}