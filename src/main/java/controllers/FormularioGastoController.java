package controllers;

import dao.GastoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Gasto;

public class FormularioGastoController {

    @FXML
    private TextField txtCategoria;
    @FXML
    private TextField txtMonto;
    @FXML
    private TextField txtFecha;

    private Gasto gasto;
    private GastoDAO gastoDAO = new GastoDAO();
    private boolean isEditMode = false;

    public void setGasto(Gasto gasto) {
        this.gasto = gasto;
        if (gasto != null) {
            isEditMode = true;
            txtCategoria.setText(gasto.getCategoria());
            txtMonto.setText(String.valueOf(gasto.getMonto()));
            txtFecha.setText(gasto.getFecha());
        }
    }

    @FXML
    private void guardarGasto() {
        try {
            String categoria = txtCategoria.getText();
            double monto = Double.parseDouble(txtMonto.getText());
            String fecha = txtFecha.getText();

            if (isEditMode) {
                gasto.setCategoria(categoria);
                gasto.setMonto(monto);
                gasto.setFecha(fecha);
                gastoDAO.actualizarGasto(gasto);
            } else {
                Gasto nuevoGasto = new Gasto(0, 0, categoria, monto, fecha);
                gastoDAO.insertarGasto(nuevoGasto);
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
        Stage stage = (Stage) txtCategoria.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}