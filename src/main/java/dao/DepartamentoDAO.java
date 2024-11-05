package dao;

import models.Departamento;
import utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoDAO {

    // Método para insertar un nuevo departamento
    public void insertarDepartamento(Departamento departamento) {
        String sql = "INSERT INTO departamentos (ubicacion, precio_compra, precio_estimado_venta, estado_remodelacion, rentabilidad_deseada) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, departamento.getUbicacion());
            pstmt.setDouble(2, departamento.getPrecioCompra());
            pstmt.setDouble(3, departamento.getPrecioEstimadoVenta());
            pstmt.setString(4, departamento.getEstadoRemodelacion());
            pstmt.setDouble(5, departamento.getRentabilidadDeseada());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los departamentos
    public List<Departamento> obtenerDepartamentos() {
        List<Departamento> departamentos = new ArrayList<>();
        String sql = "SELECT * FROM departamentos";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Departamento departamento = new Departamento(
                        rs.getInt("id"),
                        rs.getString("ubicacion"),
                        rs.getDouble("precio_compra"),
                        rs.getDouble("precio_estimado_venta"),
                        rs.getString("estado_remodelacion"),
                        rs.getDouble("rentabilidad_deseada")
                );
                departamentos.add(departamento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return departamentos;
    }

    // Método para actualizar un departamento
    public void actualizarDepartamento(Departamento departamento) {
        String sql = "UPDATE departamentos SET ubicacion = ?, precio_compra = ?, precio_estimado_venta = ?, estado_remodelacion = ?, rentabilidad_deseada = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, departamento.getUbicacion());
            pstmt.setDouble(2, departamento.getPrecioCompra());
            pstmt.setDouble(3, departamento.getPrecioEstimadoVenta());
            pstmt.setString(4, departamento.getEstadoRemodelacion());
            pstmt.setDouble(5, departamento.getRentabilidadDeseada());
            pstmt.setInt(6, departamento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un departamento
    public void eliminarDepartamento(int id) {
        String sql = "DELETE FROM departamentos WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}