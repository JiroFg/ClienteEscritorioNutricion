package clienteescritorionutricion.controller;

import java.io.File;
import java.net.MalformedURLException;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


public class FXMLRegistrarPacienteController implements Initializable {
    
    FileChooser fileChooser = new FileChooser();
    
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
    private ImageView imgPerfil;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        group = new ToggleGroup();
        rbMasculino.setToggleGroup(group);
        rbFemenino.setToggleGroup(group);
    }    

    @FXML
    private void btnSeleccionarImagenListener(ActionEvent event) throws MalformedURLException {
        Stage stageActual = (Stage) tfNombre.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stageActual);
        URL url = selectedFile.toURI().toURL();
        imgPerfil.setImage(new Image(url.toExternalForm()));
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

    @FXML
    private void btnRegistrarListener(ActionEvent event) {
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
        System.out.println(isValid(
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
        ));
    }
    
    private String tomarSexoDelToggle(){
        RadioButton selectedRadioButton = (RadioButton) group.getSelectedToggle();
        String toggleValue;
        if(selectedRadioButton != null){
            toggleValue = selectedRadioButton.getText();
        }else{
            toggleValue = "";
        }
        return toggleValue;
    }
    
}
