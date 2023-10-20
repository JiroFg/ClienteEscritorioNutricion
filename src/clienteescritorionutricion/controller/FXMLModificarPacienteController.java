//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.interfaz.IRespuesta;
import clienteescritorionutricion.modelo.dao.PacientesDAO;
import clienteescritorionutricion.modelo.pojo.Paciente;
import clienteescritorionutricion.modelo.pojo.Respuesta;
import clienteescritorionutricion.utils.Utilidades;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class FXMLModificarPacienteController implements Initializable {

    private Paciente paciente;
    private IRespuesta observador;
    
    @FXML
    private TextField tfNombre;
    @FXML
    private TextField tfApellidoPaterno;
    @FXML
    private TextField tfApellidoMaterno;
    @FXML
    private DatePicker dpFechaNacimiento;
    
    private ToggleGroup group; 
    
    @FXML
    private RadioButton rbMasculino;
    @FXML
    private RadioButton rbFemenino;
    @FXML
    private TextField tfPeso;
    @FXML
    private TextField tfEstatura;
    @FXML
    private TextField tfTallaInicial;
    @FXML
    private TextField tfTelefono;
    @FXML
    private TextField tfEmail;
    @FXML
    private TextField tfContrasena;
    @FXML
    private Label lbErrorNombre;
    @FXML
    private Label lbErrorApellidoPaterno;
    @FXML
    private Label lbErrorApellidoMaterno;
    @FXML
    private Label lbErrorFechaNacimiento;
    @FXML
    private Label lbErrorSexo;
    @FXML
    private Label lbErrorPeso;
    @FXML
    private Label lbErrorEstatura;
    @FXML
    private Label lbErrorTallaInicial;
    @FXML
    private Label lbErrorTelefono;
    @FXML
    private Label lbErrorEmail;
    @FXML
    private Label lbErrorContrasena;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        rbMasculino.setToggleGroup(group);
        rbFemenino.setToggleGroup(group);
    }    

    @FXML
    private void btnSeleccionarImagenListener(ActionEvent event) {
    }

    @FXML
    private void btnModificarPacienteListener(ActionEvent event) {
        String nombre = tfNombre.getText();
        String apellidoPaterno = tfApellidoPaterno.getText();
        String apellidoMaterno = tfApellidoMaterno.getText();
        LocalDate fechaNacimiento = dpFechaNacimiento.getValue();
        String sexo = tomarSexoDelToggle();
        String peso = tfPeso.getText();
        String estatura = tfEstatura.getText();
        String tallaInicial = tfTallaInicial.getText();
        String telefono = tfTelefono.getText();
        String email = tfEmail.getText();
        String contrasena = tfContrasena.getText();
        if(isValid(
                nombre,
                apellidoPaterno,
                apellidoMaterno,
                fechaNacimiento,
                sexo,
                peso,
                estatura,
                tallaInicial,
                telefono,
                email,
                contrasena
        )){
            paciente.setNombre(nombre);
            paciente.setApellidoPaterno(apellidoPaterno);
            paciente.setApellidoMaterno(apellidoMaterno);
            paciente.setFechaNacimiento(fechaNacimiento.toString());
            paciente.setSexo(sexo);
            paciente.setPeso(Float.parseFloat(peso));
            paciente.setEstatura(Float.parseFloat(estatura));
            paciente.setTallaInicial(Float.parseFloat(tallaInicial));
            paciente.setEmail(email);
            paciente.setTelefono(telefono);
            paciente.setContrasena(contrasena);
            modificarPaciente(paciente);
        }
    }
    
    private void modificarPaciente(Paciente paciente){
        Respuesta respuesta = PacientesDAO.actualizarPaciente(paciente);
        if(!respuesta.isError()){
            Utilidades.mostrarAlertaSimple("Paciente actualizado con exito", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
            observador.notificarGuardadoPaciente(paciente.getNombre());
            cerrarVentana();
        }else{
            Utilidades.mostrarAlertaSimple("Error", respuesta.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    
    private boolean isValid(
            String nombre,
            String apellidoPaterno,
            String apellidoMaterno,
            LocalDate fechaNacimiento,
            String sexo,
            String peso,
            String estatura,
            String tallaInicial,
            String telefono,
            String email,
            String contrasena
    ){
        boolean isValid = true;
        resetearCampos();
        
        if(nombre.isEmpty()){
            lbErrorNombre.setText("Nombre requerido");
            isValid = false;
        }
        if(apellidoPaterno.isEmpty()){
            lbErrorApellidoPaterno.setText("Apellido paterno requerdio");
            isValid = false;
        }
        if(apellidoMaterno.isEmpty()){
            lbErrorApellidoMaterno.setText("Apellido materno requerido");
            isValid = false;
        }
        if(fechaNacimiento == null){
            isValid = false;
            lbErrorFechaNacimiento.setText("Fecha de nacimiento requerida");
        }
        if(sexo.isEmpty()){
            isValid = false;
            lbErrorSexo.setText("Sexo requerido");
        }
        if(peso.isEmpty()){
            isValid = false;
            lbErrorPeso.setText("Peso requerido");
        }
        if(estatura.isEmpty()){
            isValid = false;
            lbErrorEstatura.setText("Estatura requerida");
        }
        if(tallaInicial.isEmpty()){
            isValid = false;
            lbErrorTallaInicial.setText("Talla inicial requerida");
        }
        if(telefono.isEmpty()){
            isValid = false;
            lbErrorTelefono.setText("Telefono requerido");
        }
        if(email.isEmpty()){
            isValid = false;
            lbErrorEmail.setText("Email requerido");
        }
        if(contrasena.isEmpty()){
            isValid = false;
            lbErrorContrasena.setText("Contraseña requerida");
        }
        return isValid;
    }
    
    private void resetearCampos(){
        lbErrorNombre.setText("");
        lbErrorApellidoPaterno.setText("");
        lbErrorApellidoMaterno.setText("");
        lbErrorFechaNacimiento.setText("");
        lbErrorSexo.setText("");
        lbErrorPeso.setText("");
        lbErrorEstatura.setText("");
        lbErrorTallaInicial.setText("");
        lbErrorTelefono.setText("");
        lbErrorEmail.setText("");
        lbErrorContrasena.setText("");
    }
    
    private void setCampos(){
        tfNombre.setText(paciente.getNombre());
        tfApellidoPaterno.setText(paciente.getApellidoPaterno());
        tfApellidoMaterno.setText(paciente.getApellidoMaterno());
        dpFechaNacimiento.setValue(LocalDate.parse(paciente.getFechaNacimiento()));
        setSexoToggle(paciente.getSexo());
        tfPeso.setText(String.valueOf(paciente.getPeso()));
        tfEstatura.setText(String.valueOf(paciente.getEstatura()));
        tfTallaInicial.setText(String.valueOf(paciente.getTallaInicial()));
        tfTelefono.setText(paciente.getTelefono());
        tfEmail.setText(paciente.getEmail());
        tfContrasena.setText(paciente.getContrasena());
    }
    
    public void inicializarInformacion(Paciente paciente, IRespuesta observador){
        this.observador = observador;
        this.paciente = paciente;
        setCampos();
    }
    
    private void setSexoToggle(String sexo){
        if(sexo.equals("M")){
            rbMasculino.setSelected(true);
        }else{
            rbFemenino.setSelected(true);
        }
    }
    
    private String tomarSexoDelToggle(){
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toggleValue;
        if(selectedRadioButton != null){
            String aux = selectedRadioButton.getText();
            if(aux.equals("Masculino")){
                toggleValue = "M";
            }else{
                toggleValue = "F";
            }
        }else{
            toggleValue = "";
        }
        return toggleValue;
    }
    
    private void cerrarVentana(){
        Stage escenario = (Stage) tfNombre.getScene().getWindow();
        escenario.close();
    }
    
}
//Edson Jair Fuentes García