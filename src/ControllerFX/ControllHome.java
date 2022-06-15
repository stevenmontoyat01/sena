package ControllerFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;


public class ControllHome {    

    @FXML private Button hoEstudiantes;
    @FXML private Button inicioSesion;

    @FXML void homeEstudiantes(ActionEvent event){
        try {
            ///////////////////////////////////////////////////
            Stage stage = (Stage) hoEstudiantes.getScene().getWindow(); 
            stage.close(); //CERRAR LA PESTAÑA DE HOME
            Parent root = (new FXMLLoader(getClass().getResource("../fxml/estudiantes.fxml"))).load();
            Scene scene =  new Scene(root);
            Stage teatro = new Stage();
            teatro.setScene(scene);
            teatro.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML void clicksesion (ActionEvent event) {
        try{
            Stage stage = (Stage) inicioSesion.getScene().getWindow();
            stage.close();
            Parent root = (new FXMLLoader(getClass().getResource("../fxml/estudiantes.fxml"))).load();
            Scene scene = new Scene (root);
            Stage teatro = new Stage();
            teatro.setScene(scene);
            teatro.show();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
	




