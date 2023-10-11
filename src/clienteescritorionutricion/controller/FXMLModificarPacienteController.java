//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.modelo.pojo.Paciente;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;


public class FXMLModificarPacienteController implements Initializable {

    private Paciente paciente;
    
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
    
    public void setPaciente(Paciente paciente){
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
    
}
//Edson Jair Fuentes García