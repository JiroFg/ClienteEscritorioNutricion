//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.ClienteEscritorioNutricion;
import clienteescritorionutricion.modelo.dao.PacientesDAO;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLAdminPacientesController implements Initializable {
    
    private int idMedico;
    
    private ObservableList<Paciente> pacientes;

    @FXML
    private Button btnRegistrarPaciente;
    @FXML
    private TextField tfBuscarPaciente;
    @FXML
    private Button btnEditarPaciente;
    @FXML
    private Button btnEliminarPaciente;
    @FXML
    private TableView<Paciente> tvPacientes;
    @FXML
    private TableColumn colNombre;
    @FXML
    private TableColumn colApellidoPaterno;
    @FXML
    private TableColumn colApellidoMaterno;
    @FXML
    private TableColumn colFechaNacimiento;
    @FXML
    private TableColumn colEmail;
    @FXML
    private TableColumn colTelefono;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        pacientes = FXCollections.observableArrayList();
        configurarTable();
    }
    
    private void descargarPacientes(){
        HashMap<String, Object> respuesta = PacientesDAO.obtenerPacientesPorMedico(idMedico);
        if(!(boolean) respuesta.get("error")){
            List<Paciente> listaWS = (List<Paciente>) respuesta.get("pacientes");
            pacientes.addAll(listaWS);
            tvPacientes.setItems(pacientes);
        }else{
            Utilidades.mostrarAlertaSimple("Error", (String) respuesta.get("mensaje"), Alert.AlertType.ERROR);
        }
    }
    
    private void configurarTable(){
        colNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
        colApellidoPaterno.setCellValueFactory(new PropertyValueFactory("apellidoPaterno"));
        colApellidoMaterno.setCellValueFactory(new PropertyValueFactory("apellidoMaterno"));
        colFechaNacimiento.setCellValueFactory(new PropertyValueFactory("fechaNacimiento"));
        colEmail.setCellValueFactory(new PropertyValueFactory("email"));
        colTelefono.setCellValueFactory(new PropertyValueFactory("telefono"));
    }

    @FXML
    private void btnRegistrarPacienteListener(ActionEvent event) {
        try{
            irPantallaRegistrarPaciente();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void irPantallaRegistrarPaciente() throws IOException{
        Stage stageActual = (Stage) btnRegistrarPaciente.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(ClienteEscritorioNutricion.class.getResource("FXMLRegistrarPaciente.fxml"));
        Parent vista = loader.load();
        FXMLRegistrarPacienteController registrarPacienteController = loader.getController();
        registrarPacienteController.setIdMedico(idMedico);
        Scene escena = new Scene(vista);
        Stage escenarioRegistrar = new Stage();
        escenarioRegistrar.setScene(escena);
        escenarioRegistrar.setTitle("Registrar Paciente");
        escenarioRegistrar.initModality(Modality.APPLICATION_MODAL);
        escenarioRegistrar.show();
    }
    
    private void irPantallaModificarPaciente(Paciente paciente) throws IOException{
        Stage stageActual = (Stage) btnRegistrarPaciente.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(ClienteEscritorioNutricion.class.getResource("FXMLModificarPaciente.fxml"));
        Parent vista = loader.load();
        FXMLModificarPacienteController modificarPacienteController = loader.getController();
        modificarPacienteController.setPaciente(paciente);
        Scene escena = new Scene(vista);
        Stage escenarioRegistrar = new Stage();
        escenarioRegistrar.setScene(escena);
        escenarioRegistrar.setTitle("Modificar Paciente");
        escenarioRegistrar.initModality(Modality.APPLICATION_MODAL);
        escenarioRegistrar.show();
    }
    
    public void setIdMedico(int idMedico){
        this.idMedico = idMedico;
         descargarPacientes();
    }

    @FXML
    private void btnEditarPacienteListener(ActionEvent event) {
        int posicion = tvPacientes.getSelectionModel().getSelectedIndex();
        if(posicion != -1){
            Paciente paciente = pacientes.get(posicion);
            try {
                irPantallaModificarPaciente(paciente);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            Utilidades.mostrarAlertaSimple("Selección requerida", "Seleccione un elemento de la lista", Alert.AlertType.WARNING);
        }
    }

    @FXML
    private void btnEliminarPacienteListener(ActionEvent event) {
        
    }
}
//Edson Jair Fuentes García
