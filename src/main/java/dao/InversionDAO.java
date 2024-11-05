package dao;

import models.Inversion;
import utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InversionDAO {

    // Método para insertar una nueva inversión
    public void insertarInversion(Inversion inversion) {
        String sql = "INSERT INTO inversiones (departamento_id, porcentaje_inversion, capital) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, inversion.getDepartamentoId());
            pstmt.setDouble(2, inversion.getPorcentajeInversion());
            pstmt.setDouble(3, inversion.getCapital());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todas las inversiones
    public List<Inversion> obtenerInversiones() {
        List<Inversion> inversiones = new ArrayList<>();
        String sql = "SELECT * FROM inversiones";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Inversion inversion = new Inversion(
                        rs.getInt("id"),
                        rs.getInt("departamento_id"),
                        rs.getDouble("porcentaje_inversion"),
                        rs.getDouble("capital")
                );
                inversiones.add(inversion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inversiones;
    }

    // Método para actualizar una inversión
    public void actualizarInversion(Inversion inversion) {
        String sql = "UPDATE inversiones SET departamento_id = ?, porcentaje_inversion = ?, capital = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, inversion.getDepartamentoId());
            pstmt.setDouble(2, inversion.getPorcentajeInversion());
            pstmt.setDouble(3, inversion.getCapital());
            pstmt.setInt(4, inversion.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar una inversión
    public void eliminarInversion(int id) {
        String sql = "DELETE FROM inversiones WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}