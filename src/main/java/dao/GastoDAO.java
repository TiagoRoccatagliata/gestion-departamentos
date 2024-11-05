package dao;

import models.Gasto;
import utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GastoDAO {

    // Método para insertar un gasto
    public void insertarGasto(Gasto gasto) {
        String sql = "INSERT INTO gastos (departamento_id, categoria, monto, fecha) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gasto.getDepartamentoId());
            pstmt.setString(2, gasto.getCategoria());
            pstmt.setDouble(3, gasto.getMonto());
            pstmt.setString(4, gasto.getFecha());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los gastos
    public List<Gasto> obtenerGastos() {
        List<Gasto> gastos = new ArrayList<>();
        String sql = "SELECT * FROM gastos";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Gasto gasto = new Gasto(
                        rs.getInt("id"),
                        rs.getInt("departamento_id"),
                        rs.getString("categoria"),
                        rs.getDouble("monto"),
                        rs.getString("fecha")
                );
                gastos.add(gasto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return gastos;
    }

    // Método para actualizar un gasto
    public void actualizarGasto(Gasto gasto) {
        String sql = "UPDATE gastos SET departamento_id = ?, categoria = ?, monto = ?, fecha = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gasto.getDepartamentoId());
            pstmt.setString(2, gasto.getCategoria());
            pstmt.setDouble(3, gasto.getMonto());
            pstmt.setString(4, gasto.getFecha());
            pstmt.setInt(5, gasto.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un gasto
    public void eliminarGasto(int id) {
        String sql = "DELETE FROM gastos WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}