package controllers;

import dao.DepartamentoDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Departamento;

import java.util.Optional;

public class FormularioDepartamentoController {

    @FXML
    private TextField txtUbicacion;
    @FXML
    private TextField txtPrecioCompra;
    @FXML
    private TextField txtPrecioEstimadoVenta;
    @FXML
    private TextField txtEstadoRemodelacion;
    @FXML
    private TextField txtRentabilidadDeseada;

    private Departamento departamento;
    private DepartamentoDAO departamentoDAO = new DepartamentoDAO();
    private boolean isEditMode = false;

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
        if (departamento != null) {
            isEditMode = true;
            txtUbicacion.setText(departamento.getUbicacion());
            txtPrecioCompra.setText(String.valueOf(departamento.getPrecioCompra()));
            txtPrecioEstimadoVenta.setText(String.valueOf(departamento.getPrecioEstimadoVenta()));
            txtEstadoRemodelacion.setText(departamento.getEstadoRemodelacion());
            txtRentabilidadDeseada.setText(String.valueOf(departamento.getRentabilidadDeseada()));
        }
    }

    @FXML
    private void guardarDepartamento() {
        try {
            String ubicacion = txtUbicacion.getText();
            double precioCompra = Double.parseDouble(txtPrecioCompra.getText());
            double precioEstimadoVenta = Double.parseDouble(txtPrecioEstimadoVenta.getText());
            String estadoRemodelacion = txtEstadoRemodelacion.getText();
            double rentabilidadDeseada = Double.parseDouble(txtRentabilidadDeseada.getText());

            if (isEditMode) {
                departamento.setUbicacion(ubicacion);
                departamento.setPrecioCompra(precioCompra);
                departamento.setPrecioEstimadoVenta(precioEstimadoVenta);
                departamento.setEstadoRemodelacion(estadoRemodelacion);
                departamento.setRentabilidadDeseada(rentabilidadDeseada);
                departamentoDAO.actualizarDepartamento(departamento);
            } else {
                Departamento nuevoDepartamento = new Departamento(0, ubicacion, precioCompra, precioEstimadoVenta, estadoRemodelacion, rentabilidadDeseada);
                departamentoDAO.insertarDepartamento(nuevoDepartamento);
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
        Stage stage = (Stage) txtUbicacion.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}