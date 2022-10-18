package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;


public class LoginController extends Main implements Initializable  {
    @FXML
    private Button cancelButton;
    @FXML
    private Label loginMessageLabel;
    @FXML
    private ImageView iconImageView;
    @FXML
    private ImageView MMYView;
    @FXML
    private ImageView musicIconView;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File iconFile=new File("images/icons8-login-96.png");
        Image iconImage = new Image(iconFile.toURI().toString());
        iconImageView.setImage(iconImage);

        File mmyFile=new File("images/MMY.png");
        Image mmyImage = new Image(mmyFile.toURI().toString());
        MMYView.setImage(mmyImage);

        File musicIconFile=new File("images/icons8-musical-96.png");
        Image musicIconImage = new Image(musicIconFile.toURI().toString());
        musicIconView.setImage(musicIconImage);
    }

    public void loginButtonOnAction(ActionEvent event)
    {

        if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == false)
        {
            validateLogin();
        }
        else if(usernameTextField.getText().isBlank() == true && passwordTextField.getText().isBlank() == false)
        {
            loginMessageLabel.setText("Please enter : Username");
        }
        else if(usernameTextField.getText().isBlank() == false && passwordTextField.getText().isBlank() == true)
        {
            loginMessageLabel.setText("Please enter : Password");
        }
        else
        {
            loginMessageLabel.setText("Please enter : Username and Password");
        }
    }

    public void cancelButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void validateLogin()
    {

        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String verifyLogin = "SELECT count(1) FROM mirhats_account WHERE username = '"+ usernameTextField.getText() + "' and password = '"+passwordTextField.getText()+"'";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next())
            {
                if(queryResult.getInt(1) == 1)
                {
                    //loginMessageLabel.setText("WIN");
                    loginMessageLabel.setText("");
                    if(usernameTextField.getText().equals("AdminMirhat")) {
                        try {

                            Parent root = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
                            Stage adminPanelStage = new Stage();
                            adminPanelStage.initStyle(StageStyle.UNDECORATED);
                            adminPanelStage.setScene(new Scene(root, 1000, 600));
                            adminPanelStage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                            e.getCause();
                        }
                    }
                    else
                    {
                        Parent root = FXMLLoader.load(getClass().getResource("UserInterface.fxml"));
                        Stage userPanelStage = new Stage();
                        userPanelStage.initStyle(StageStyle.UNDECORATED);
                        userPanelStage.setScene(new Scene(root, 1000, 600));
                        userPanelStage.show();
                    }
                }
                else
                {
                    loginMessageLabel.setText("Invalid login.Please try again.");
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void createAccountForm()
    {
        try
        {
            Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
            Stage registerStage = new Stage();
            registerStage.initStyle(StageStyle.UNDECORATED);
            registerStage.setScene(new Scene(root, 600, 600));
            registerStage.show();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

}
