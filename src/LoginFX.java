import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import conect.Conexion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginFX{    

    @FXML private TextField loginUser;
    @FXML private PasswordField loginPassword;
    @FXML private Label loginMensage;
    @FXML private Button loginSingUp;
    

    Connection con = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

	@FXML void ingresarBtn(ActionEvent event) throws SQLException{
		String nombreUsuario = loginUser.getText();
        String contraseña = loginPassword.getText();
        Conexion conect = new Conexion();
        conect.conectar();

        // ACA SIRVE LA VALIDACION PARA EL ADMIN 
        if(conect.isConectado()){
            System.out.println("Prueba conectado-------------");
            String query = "SELECT id from personas where nombre = '"+nombreUsuario+"' AND identificacion = '"+contraseña+"' AND tipo = '"+3+"' ";
            try (Statement stm = conect.getCon().createStatement()){
                ResultSet rst = stm.executeQuery(query);
                if(rst.next()){;
                    Stage stage = (Stage) loginSingUp.getScene().getWindow();
                    stage.close();
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/home.fxml"));
                    Parent root = loader.load();
                    Scene scene = new Scene(root);
                    stage = new Stage();
                    stage.setTitle("Home");
                    stage.setScene(scene);
                    stage.show();
                    conect.desconectar();
            // ACA SIRVE LA VALIDACION PARA EL INSTRUCTOR 
                }else if (conect.isConectado()){
                    System.out.println("Prueba conectado-------------");
                    String queryEstudiantes = "SELECT id from personas where email = '"+nombreUsuario+"' AND identificacion = '"+contraseña+"' AND tipo = '"+1+"' ";
                    try (Statement stmE = conect.getCon().createStatement()){
                        ResultSet rste = stm.executeQuery(queryEstudiantes);
                        if(rste.next()){;
                            Stage stage = (Stage) loginSingUp.getScene().getWindow();
                            stage.close();
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/instructores.fxml"));
                            Parent root = loader.load();
                            Scene scene = new Scene(root);
                            stage = new Stage();
                            stage.setTitle("instructores");
                            stage.setScene(scene);
                            stage.show();
                            conect.desconectar();
                        }
                    }
                    // =======    S E G U I R      M A Ñ A N A  ============
                }else if(conect.isConectado()){

                }
                else
                loginMensage.setText("Invalid User or Password");
                
            } catch (Exception e) {
                e.printStackTrace();
    
        }
        }
	}

	
}