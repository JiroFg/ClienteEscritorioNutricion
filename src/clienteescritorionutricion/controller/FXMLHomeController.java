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


public class FXMLHomeController implements Initializable {

    @FXML
    private Button btnAdminPacientes;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        Parent vista = FXMLLoader.load(ClienteEscritorioNutricion.class.getResource("FXMLAdminPacientes.fxml"));
        Scene escena = new Scene(vista);
        stageActual.setScene(escena);
        stageActual.setTitle("Administrar Pacientes");
        stageActual.show();
    }
    
}
