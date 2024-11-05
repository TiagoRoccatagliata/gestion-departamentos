package controllers;

import dao.DocumentoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Documento;

public class FormularioDocumentoController {

    @FXML
    private TextField txtRuta;
    @FXML
    private TextField txtDescripcion;

    private Documento documento;
    private DocumentoDAO documentoDAO = new DocumentoDAO();
    private boolean isEditMode = false;

    public void setDocumento(Documento documento) {
        this.documento = documento;
        if (documento != null) {
            isEditMode = true;
            txtRuta.setText(documento.getRuta());
            txtDescripcion.setText(documento.getDescripcion());
        }
    }

    @FXML
    private void guardarDocumento() {
        String ruta = txtRuta.getText();
        String descripcion = txtDescripcion.getText();

        if (isEditMode) {
            documento.setRuta(ruta);
            documento.setDescripcion(descripcion);
            documentoDAO.actualizarDocumento(documento);
        } else {
            Documento nuevoDocumento = new Documento(0, 0, ruta, descripcion);
            documentoDAO.insertarDocumento(nuevoDocumento);
        }

        cerrarVentana();
    }

    @FXML
    private void cancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtRuta.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}