package models;

public class Documento {
    private int id;
    private int departamentoId;
    private String ruta;
    private String descripcion;

    // Constructor
    public Documento(int id, int departamentoId, String ruta, String descripcion) {
        this.id = id;
        this.departamentoId = departamentoId;
        this.ruta = ruta;
        this.descripcion = descripcion;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }
    public String getRuta() { return ruta; }
    public void setRuta(String ruta) { this.ruta = ruta; }
    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }
}