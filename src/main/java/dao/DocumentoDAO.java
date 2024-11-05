package dao;

import models.Documento;
import utilities.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DocumentoDAO {

    // Método para insertar un documento
    public void insertarDocumento(Documento documento) {
        String sql = "INSERT INTO documentos (departamento_id, ruta, descripcion) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, documento.getDepartamentoId());
            pstmt.setString(2, documento.getRuta());
            pstmt.setString(3, documento.getDescripcion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obtener todos los documentos
    public List<Documento> obtenerDocumentos() {
        List<Documento> documentos = new ArrayList<>();
        String sql = "SELECT * FROM documentos";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                Documento documento = new Documento(
                        rs.getInt("id"),
                        rs.getInt("departamento_id"),
                        rs.getString("ruta"),
                        rs.getString("descripcion")
                );
                documentos.add(documento);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return documentos;
    }

    // Método para actualizar un documento
    public void actualizarDocumento(Documento documento) {
        String sql = "UPDATE documentos SET departamento_id = ?, ruta = ?, descripcion = ? WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, documento.getDepartamentoId());
            pstmt.setString(2, documento.getRuta());
            pstmt.setString(3, documento.getDescripcion());
            pstmt.setInt(4, documento.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para eliminar un documento
    public void eliminarDocumento(int id) {
        String sql = "DELETE FROM documentos WHERE id = ?";

        try (Connection conn = DatabaseConnection.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}