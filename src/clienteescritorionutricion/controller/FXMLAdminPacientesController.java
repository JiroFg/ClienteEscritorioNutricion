package clienteescritorionutricion.controller;

import clienteescritorionutricion.ClienteEscritorioNutricion;
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
import javafx.stage.Stage;


public class FXMLAdminPacientesController implements Initializable {

    @FXML
    private Button btnRegistrarPaciente;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
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
        Parent vista = FXMLLoader.load(ClienteEscritorioNutricion.class.getResource("FXMLRegistrarPaciente.fxml"));
        Scene escena = new Scene(vista);
        stageActual.setScene(escena);
        stageActual.setTitle("Registrar Paciente");
        stageActual.show();
    }
    
}
