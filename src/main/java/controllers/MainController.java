package controllers;

import dao.DepartamentoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Departamento;

public class MainController {

    @FXML
    private TableView<Departamento> tableDepartamentos;
    @FXML
    private TableColumn<Departamento, Integer> colId;
    @FXML
    private TableColumn<Departamento, String> colUbicacion;
    @FXML
    private TableColumn<Departamento, Double> colPrecioCompra;
    @FXML
    private TableColumn<Departamento, Double> colPrecioEstimadoVenta;
    @FXML
    private TableColumn<Departamento, String> colEstadoRemodelacion;
    @FXML
    private TableColumn<Departamento, Double> colRentabilidadDeseada;

    private ObservableList<Departamento> listaDepartamentos;
    private final DepartamentoDAO departamentoDAO = new DepartamentoDAO();

    @FXML
    public void initialize() {
        // Configurar las columnas de la tabla
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        colPrecioCompra.setCellValueFactory(new PropertyValueFactory<>("precioCompra"));
        colPrecioEstimadoVenta.setCellValueFactory(new PropertyValueFactory<>("precioEstimadoVenta"));
        colEstadoRemodelacion.setCellValueFactory(new PropertyValueFactory<>("estadoRemodelacion"));
        colRentabilidadDeseada.setCellValueFactory(new PropertyValueFactory<>("rentabilidadDeseada"));

        // Cargar datos en la tabla
        cargarDatosDepartamentos();
    }

    private void cargarDatosDepartamentos() {
        listaDepartamentos = FXCollections.observableArrayList(departamentoDAO.obtenerDepartamentos());
        tableDepartamentos.setItems(listaDepartamentos);
    }

    @FXML
    private void onAgregarDepartamento() {
        // Lógica para agregar un departamento
        mostrarAlerta("Agregar Departamento", "Esta es una simulación de agregar un departamento.");
    }

    @FXML
    private void onEditarDepartamento() {
        Departamento departamentoSeleccionado = tableDepartamentos.getSelectionModel().getSelectedItem();
        if (departamentoSeleccionado != null) {
            // Lógica para editar el departamento seleccionado
            mostrarAlerta("Editar Departamento", "Esta es una simulación de editar el departamento: " + departamentoSeleccionado.getId());
        } else {
            mostrarAlerta("Selección requerida", "Por favor, selecciona un departamento para editar.");
        }
    }

    @FXML
    private void onEliminarDepartamento() {
        Departamento departamentoSeleccionado = tableDepartamentos.getSelectionModel().getSelectedItem();
        if (departamentoSeleccionado != null) {
            Alert confirmacion = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacion.setTitle("Confirmación de eliminación");
            confirmacion.setHeaderText(null);
            confirmacion.setContentText("¿Estás seguro de que deseas eliminar el departamento seleccionado?");

            ButtonType resultado = confirmacion.showAndWait().orElse(ButtonType.CANCEL);
            if (resultado == ButtonType.OK) {
                departamentoDAO.eliminarDepartamento(departamentoSeleccionado.getId());
                cargarDatosDepartamentos();
            }
        } else {
            mostrarAlerta("Selección requerida", "Por favor, selecciona un departamento para eliminar.");
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}