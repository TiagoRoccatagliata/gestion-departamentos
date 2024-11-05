package models;

public class Inversion {
    private int id;
    private int departamentoId;
    private double porcentajeInversion;
    private double capital;

    // Constructor
    public Inversion(int id, int departamentoId, double porcentajeInversion, double capital) {
        this.id = id;
        this.departamentoId = departamentoId;
        this.porcentajeInversion = porcentajeInversion;
        this.capital = capital;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getDepartamentoId() { return departamentoId; }
    public void setDepartamentoId(int departamentoId) { this.departamentoId = departamentoId; }
    public double getPorcentajeInversion() { return porcentajeInversion; }
    public void setPorcentajeInversion(double porcentajeInversion) { this.porcentajeInversion = porcentajeInversion; }
    public double getCapital() { return capital; }
    public void setCapital(double capital) { this.capital = capital; }
}