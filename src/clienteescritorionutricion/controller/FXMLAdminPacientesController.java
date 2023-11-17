//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.ClienteEscritorioNutricion;
import clienteescritorionutricion.interfaz.IRespuesta;
import clienteescritorionutricion.modelo.dao.PacientesDAO;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.modelo.pojo.Respuesta;
import clienteescritorionutricion.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLAdminPacientesController implements Initializable, IRespuesta {
    
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
        registrarPacienteController.inicializarInformacion(idMedico, this);
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
        modificarPacienteController.inicializarInformacion(paciente, this);
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
        Paciente paciente = tvPacientes.getSelectionModel().getSelectedItem();
        if(paciente != null){
            Optional<ButtonType> respuestaConf = Utilidades.mostrarAlertaConfirmacion("Eliminar paciente", "¿Esta seguro que desea eliminar al paciente "+paciente.getNombre()+"?");
            if(respuestaConf.get() == ButtonType.OK){
                eliminarPaciente(paciente.getIdPaciente());
                pacientes.clear();
                descargarPacientes();
            }
        }else{
            Utilidades.mostrarAlertaSimple("Selección requerida", "Seleccione un elemento de la lista", Alert.AlertType.WARNING);
        }
    }

    @Override
    public void notificarGuardadoPaciente(String nombrePaciente) {
        System.out.println(nombrePaciente);
        pacientes.clear();
        descargarPacientes();
    }
    
    private void eliminarPaciente(int idPaciente){
        Respuesta respuesta = PacientesDAO.eliminarPaciente(idPaciente);
        if(!respuesta.isError()){
            Utilidades.mostrarAlertaSimple("Paciente eliminado correctamente", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
        }else{
            Utilidades.mostrarAlertaSimple("Error al eliminar paciente", respuesta.getMensaje(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    private void btnDomicilioListener(ActionEvent event) {
        int posicion = tvPacientes.getSelectionModel().getSelectedIndex();
        if(posicion != -1){
            Paciente paciente = pacientes.get(posicion);
            try {
                irPantallaDomicilio(paciente);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }else{
            Utilidades.mostrarAlertaSimple("Selección requerida", "Seleccione un elemento de la lista", Alert.AlertType.WARNING);
        }
    }
    
    private void irPantallaDomicilio(Paciente paciente) throws IOException{
        Stage stageActual = (Stage) btnRegistrarPaciente.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(ClienteEscritorioNutricion.class.getResource("FXMLFormularioDomicilio.fxml"));
        Parent vista = loader.load();
        FXMLFormularioDomicilioController formularioDomicilioController = loader.getController();
        formularioDomicilioController.inicializarInformacion(paciente.getIdPaciente());
        Scene escena = new Scene(vista);
        Stage escenarioRegistrar = new Stage();
        escenarioRegistrar.setScene(escena);
        escenarioRegistrar.setTitle("Domicilio");
        escenarioRegistrar.initModality(Modality.APPLICATION_MODAL);
        escenarioRegistrar.show();
    }

}
//Edson Jair Fuentes García
