package ControllerFX;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import conect.Conexion;
import javafx.scene.Parent;
import javafx.scene.Scene;
// import javafx.scene.control.Alert.AlertType;
// import javafx.scene.control.Alert;
import javafx.scene.control.Button; 
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControlCursos{    

    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    String dato, query;
    
    Conexion conect = new Conexion();
    Connection con = null;


    @FXML private ComboBox<String> cmbHorario;
    @FXML private ComboBox<String> cmbInstructor;
    @FXML private TextField txtName;
    @FXML private Button btnCrear;


    @FXML
    void crearCurso(MouseEvent event) throws SQLException {
        
        String horario = cmbHorario.getValue();
        String instructor = cmbInstructor.getValue();
        String nameCurso = txtName.getText();
    }

    

    @FXML void initialize() throws IOException, SQLException{
        conect.conectar();
        ResultSet consult;

        query = "SELECT nombre,apellido from usuario where tipo = 1;";
        try (Statement stm = conect.getCon().createStatement()){
            consult = stm.executeQuery(query);
            while (consult.next()) {
                dato = String.format("%s %s", consult.getString("nombre"), consult.getString("apellido"));
                cmbInstructor.getItems().add(dato);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        query = "SELECT *from horarios";
        try (Statement stm = conect.getCon().createStatement()){
            consult = stm.executeQuery(query);
            while (consult.next()) {
                dato = String.format("%d %d", consult.getInt("día"), consult.getString("hora"));
                cmbHorario.getItems().add(dato);
            }
        } catch (Exception e) {
        }
        
    }




/////////////////////////       H E A D E R     /////////////////////////

@FXML private Button home;
@FXML private Button cursos;
@FXML private Button estudiantes;
@FXML private Button instructores;


@FXML void opensHome(ActionEvent event) throws SQLException{
    try {
        Stage stage = (Stage) home.getScene().getWindow(); 
        stage.close();
        Parent root = (new FXMLLoader(getClass().getResource("fxml/home.fxml"))).load();
        Scene scene =  new Scene(root);
        Stage teatro = new Stage();
        teatro.setScene(scene);
        teatro.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML void openCursos(ActionEvent event) throws SQLException{
    try {
        Stage stage = (Stage) cursos.getScene().getWindow(); 
        stage.close();
        Parent root = (new FXMLLoader(getClass().getResource("fxml/cursos.fxml"))).load();
        Scene scene =  new Scene(root);
        Stage teatro = new Stage();
        teatro.setScene(scene);
        teatro.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@FXML void openEstudiantes(ActionEvent event) throws SQLException{
    try {
        Stage stage = (Stage) estudiantes.getScene().getWindow(); 
        stage.close();
        Parent root = (new FXMLLoader(getClass().getResource("fxml/estudiantes.fxml"))).load();
        Scene scene =  new Scene(root);
        Stage teatro = new Stage();
        teatro.setScene(scene);
        teatro.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}


@FXML void openInstructores(ActionEvent event) throws SQLException{
    try {
        Stage stage = (Stage) instructores.getScene().getWindow(); 
        stage.close();
        Parent root = (new FXMLLoader(getClass().getResource("fxml/instructores.fxml"))).load();
        Scene scene =  new Scene(root);
        Stage teatro = new Stage();
        teatro.setScene(scene);
        teatro.show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}



}



	




