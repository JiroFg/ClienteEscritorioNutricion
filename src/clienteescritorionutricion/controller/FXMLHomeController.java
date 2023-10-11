//Edson Jair Fuentes García
package clienteescritorionutricion.controller;

import clienteescritorionutricion.ClienteEscritorioNutricion;
import clienteescritorionutricion.modelo.pojo.Medico;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class FXMLHomeController implements Initializable {

    @FXML
    private Button btnAdminPacientes;
    private Medico medico;
    @FXML
    private Label lbNombre;
    @FXML
    private Label lbNumPersonal;
    @FXML
    private Label lbCedula;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void btnAdminPacientes(ActionEvent event) {
        try{
            irPantallaAdministrarPacientes();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    
    private void irPantallaAdministrarPacientes() throws IOException{
        Stage stageActual = (Stage) btnAdminPacientes.getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(ClienteEscritorioNutricion.class.getResource("FXMLAdminPacientes.fxml"));
        Parent vista = loader.load();
        FXMLAdminPacientesController adminPacientesController = loader.getController();
        adminPacientesController.setIdMedico(medico.getIdMedico());
        Scene escena = new Scene(vista);
        Stage escenarioAdmin = new Stage();
        escenarioAdmin.setScene(escena);
        escenarioAdmin.setTitle("Administración Pacientes");
        escenarioAdmin.initModality(Modality.APPLICATION_MODAL);
        escenarioAdmin.showAndWait();
    }
    
    public void inicializarInformacionMedico(Medico medico){
        this.medico = medico;
        lbNombre.setText(medico.getNombre() + " " + medico.getApellidoPaterno()+ " " + medico.getApellidoMaterno()) ;
        lbNumPersonal.setText("No. Personal: " + medico.getNumeroPersonal());
        lbCedula.setText("Cédula: " + medico.getNumeroCedulaProfesional());
    }
    
}
//Edson Jair Fuentes García
