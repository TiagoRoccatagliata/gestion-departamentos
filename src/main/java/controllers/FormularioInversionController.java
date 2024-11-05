package controllers;

import dao.InversionDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Inversion;

public class FormularioInversionController {

    @FXML
    private TextField txtPorcentajeInversion;
    @FXML
    private TextField txtCapital;

    private Inversion inversion;
    private InversionDAO inversionDAO = new InversionDAO();
    private boolean isEditMode = false;

    public void setInversion(Inversion inversion) {
        this.inversion = inversion;
        if (inversion != null) {
            isEditMode = true;
            txtPorcentajeInversion.setText(String.valueOf(inversion.getPorcentajeInversion()));
            txtCapital.setText(String.valueOf(inversion.getCapital()));
        }
    }

    @FXML
    private void guardarInversion() {
        try {
            double porcentajeInversion = Double.parseDouble(txtPorcentajeInversion.getText());
            double capital = Double.parseDouble(txtCapital.getText());

            if (isEditMode) {
                inversion.setPorcentajeInversion(porcentajeInversion);
                inversion.setCapital(capital);
                inversionDAO.actualizarInversion(inversion);
            } else {
                Inversion nuevaInversion = new Inversion(0, 0, porcentajeInversion, capital);
                inversionDAO.insertarInversion(nuevaInversion);
            }

            cerrarVentana();
        } catch (NumberFormatException e) {
            mostrarAlerta("Error en los datos", "Por favor, ingresa valores numéricos válidos.");
        }
    }

    @FXML
    private void cancelar() {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) txtPorcentajeInversion.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}