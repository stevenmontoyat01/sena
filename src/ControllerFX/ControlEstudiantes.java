package ControllerFX;

import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ControlEstudiantes {
    // C O D E
    /////////////////////////       H E A D E R     /////////////////////////

    @FXML private Button home;
    @FXML private Button estudiantes;

    @FXML void opensHome(ActionEvent event){
        try {
            Stage stage = (Stage) home.getScene().getWindow(); 
            stage.close();
            Parent root = (new FXMLLoader(getClass().getResource("../fxml/home.fxml"))).load();
            Scene scene =  new Scene(root);
            Stage teatro = new Stage();
            teatro.setScene(scene);
            teatro.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML void openEstudiantes(ActionEvent event){
        try {
            Stage stage = (Stage) estudiantes.getScene().getWindow(); 
            stage.close();
            Parent root = (new FXMLLoader(getClass().getResource("../fxml/estudiantes.fxml"))).load();
            Scene scene =  new Scene(root);
            Stage teatro = new Stage();
            teatro.setScene(scene);
            teatro.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
