package clienteescritorionutricion.controller;
import clienteescritorionutricion.ClienteEscritorioNutricion;
import clienteescritorionutricion.modelo.dao.InicioSesionDAO;
import clienteescritorionutricion.modelo.pojo.RespuestaLogin;
import clienteescritorionutricion.utils.Utilidades;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FXMLInicioSesionController implements Initializable {

    @FXML
    private TextField tfNumPersonal;
    @FXML
    private PasswordField pfContrasena;
    @FXML
    private Label lbErrorNumPersonal;
    @FXML
    private Label lbErrorContra;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void btnIniciarSesion(ActionEvent event) {
        String numPersonal = tfNumPersonal.getText();
        String contrasena = pfContrasena.getText();
        lbErrorNumPersonal.setText("");
        lbErrorContra.setText("");
        boolean isValid = true;
        if(numPersonal.isEmpty()){
            lbErrorNumPersonal.setText("Número de personal requerido");
            isValid = false;
        }
        if(contrasena.isEmpty()){
            lbErrorContra.setText("Contraseña requerida");
            isValid = false;
        }
        if(isValid){
            verificarCredenciales(numPersonal, contrasena);
        }
    }
    
    private void verificarCredenciales(String numeroPersonal, String contrasena){
        RespuestaLogin respuesta = InicioSesionDAO.iniciarSesion(numeroPersonal, contrasena);
        if(respuesta.isError() == false){
            Utilidades.mostrarAlertaSimple("Credenciales validas", respuesta.getMensaje(), Alert.AlertType.INFORMATION);
            try{
                irPantallaPrincipal();
            }catch(IOException ex){
                ex.printStackTrace();
            }
        }else{
            Utilidades.mostrarAlertaSimple("Error", respuesta.getMensaje(), Alert.AlertType.ERROR);
        }
    }
    
    private void irPantallaPrincipal() throws IOException{
        Stage stageActual = (Stage) tfNumPersonal.getScene().getWindow();
        Parent vista = FXMLLoader.load(ClienteEscritorioNutricion.class.getResource("FXMLHome.fxml"));
        Scene escena = new Scene(vista);
        stageActual.setScene(escena);
        stageActual.setTitle("Home");
        stageActual.show();
    }
    
}
