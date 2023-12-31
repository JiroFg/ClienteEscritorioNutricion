//Edson Jair Fuentes García
package clienteescritorionutricion;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


public class ClienteEscritorioNutricion extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLInicioSesion.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Iniciar sesión");
        Image image = new Image("clienteescritorionutricion/resources/nutricion_icon.png");
        stage.getIcons().add(image);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
//Edson Jair Fuentes García