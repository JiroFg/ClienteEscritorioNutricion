//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.modelo.dao.CatalogoDAO;
import clienteescritorionutricion.modelo.dao.DomicilioDAO;
import clienteescritorionutricion.modelo.pojo.Domicilio;
import clienteescritorionutricion.modelo.pojo.Estado;
import clienteescritorionutricion.modelo.pojo.Municipio;
import clienteescritorionutricion.modelo.pojo.Respuesta;
import clienteescritorionutricion.utils.Utilidades;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class FXMLFormularioDomicilioController implements Initializable {

    private int idPaciente;
    private int idDomicilio;
    @FXML
    private TextField tfCalle;
    @FXML
    private TextField tfColonia;
    @FXML
    private TextField tfCodigoPostal;
    @FXML
    private ComboBox<Estado> cbEstado;
    @FXML
    private ComboBox<Municipio> cbMunicipio;
    @FXML
    private TextField tfNumero;
    @FXML
    private Label errorNumero;
    @FXML
    private Label errorCodigoPostal;
    @FXML
    private Label errorColonia;
    @FXML
    private Label errorEstado;
    @FXML
    private Label errorMunicipio;
    @FXML
    private Label errorCalle;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnGuardarListener(ActionEvent event) {
        if(comprobarCampos()){
            Domicilio domicilioPaciente = new Domicilio();
            domicilioPaciente.setCalle(tfCalle.getText());
            domicilioPaciente.setNumero(tfNumero.getText());
            domicilioPaciente.setColonia(tfColonia.getText());
            domicilioPaciente.setCodigoPostal(tfCodigoPostal.getText());
            domicilioPaciente.setIdMunicipio(cbMunicipio.getValue().getIdMunicipio());
            domicilioPaciente.setIdPaciente(idPaciente);
            System.out.println(domicilioPaciente);
            Respuesta respuesta = DomicilioDAO.registrarDomicilio(domicilioPaciente);
            Utilidades.mostrarAlertaSimple("Domicilio registrado correctamente", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
        }
    }
    
    private boolean comprobarCampos(){
        boolean isValid = true;
        resetearError();
        if(tfCalle.getText().isEmpty()){
            errorCalle.setText("Calle requerida");
            isValid = false;
        }
        if(tfNumero.getText().isEmpty()){
            errorNumero.setText("Numero requerido");
            isValid = false;
        }
        if(tfColonia.getText().isEmpty()){
            errorColonia.setText("Colonia requerida");
            isValid = false;
        }
        if(tfCodigoPostal.getText().isEmpty()){
            errorCodigoPostal.setText("Codigo postal requerido");
            isValid = false;
        }
        if(cbEstado.getSelectionModel().isEmpty()){
            errorEstado.setText("Estado requerido");
            isValid = false;
        }
        if(cbMunicipio.getSelectionModel().isEmpty()){
            errorMunicipio.setText("Municipio requerido");
        }
        return isValid;
    }
    
    private void resetearError(){
        errorCalle.setText("");
        errorNumero.setText("");
        errorColonia.setText("");
        errorCodigoPostal.setText("");
        errorEstado.setText("");
        errorMunicipio.setText("");
    }

    @FXML
    private void btnCancelarListener(ActionEvent event) {
        Stage escenario = (Stage) tfCalle.getScene().getWindow();
        escenario.close();
    }
    
    public void inicializarInformacion(int idPaciente){
        this.idPaciente = idPaciente;
        domicilio(idPaciente);
    }
    
    private void domicilio(int idPaciente){
        Domicilio domicilio = DomicilioDAO.obtenerDomicilio(idPaciente);
        setComboBox();
        if(domicilio != null){
            setCampos(domicilio);
        }else{
            System.out.println("No tiene domicilio el paciente");
        }
    }
    
    private void setCampos(Domicilio domicilio){
        idDomicilio = domicilio.getIdDomicilio();
        tfCalle.setText(domicilio.getCalle());
        tfColonia.setText(domicilio.getColonia());
        tfCodigoPostal.setText(domicilio.getCodigoPostal());
        tfNumero.setText(domicilio.getNumero());
        cbEstado.setValue(CatalogoDAO.obtenerEstadoPorId(domicilio.getIdEstado()));
        cbMunicipio.setValue(CatalogoDAO.obtenerMunicipioPorId(domicilio.getIdMunicipio()));
    }
    
    private void setComboBox(){
        ObservableList<Estado> estados = FXCollections.observableArrayList(CatalogoDAO.obtenerEstados());
        cbEstado.setItems(estados);
    }

    @FXML
    private void cbEstadoEventListener(ActionEvent event) {
        cbMunicipio.getItems().removeAll(cbMunicipio.getItems());
        ObservableList<Municipio> municipios = FXCollections.observableArrayList(CatalogoDAO.obtenerMunicipioPorEstado(cbEstado.getValue().getIdEstado()));
        System.out.println(municipios);
        cbMunicipio.setItems(municipios);
    }

    @FXML
    private void btnActualizarListener(ActionEvent event) {
        if(comprobarCampos()){
            Domicilio domicilioPaciente = new Domicilio();
            domicilioPaciente.setIdDomicilio(idDomicilio);
            domicilioPaciente.setCalle(tfCalle.getText());
            domicilioPaciente.setNumero(tfNumero.getText());
            domicilioPaciente.setColonia(tfColonia.getText());
            domicilioPaciente.setCodigoPostal(tfCodigoPostal.getText());
            domicilioPaciente.setIdMunicipio(cbMunicipio.getValue().getIdMunicipio());
            domicilioPaciente.setIdEstado(cbEstado.getValue().getIdEstado());
            domicilioPaciente.setIdPaciente(idPaciente);
            Respuesta respuesta = DomicilioDAO.actualizarDomicilio(domicilioPaciente);
            Utilidades.mostrarAlertaSimple("Domicilio registrado correctamente", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
        }
    }
    
}
