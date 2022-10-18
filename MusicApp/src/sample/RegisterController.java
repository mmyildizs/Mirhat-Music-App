package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private ImageView registerImageView;
    @FXML
    private Button exitButton;
    @FXML
    private Label registerMessageLabel;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private PasswordField confirmpasswordTextField;
    @FXML
    private Label confirmpasswordMessageLabel;
    @FXML
    private TextField firstnameTextField;
    @FXML
    private TextField lastnameTextField;
    @FXML
    private TextField usernameTextField;
    @FXML
    public RadioButton normalRB;
    @FXML
    public RadioButton premiumRB;
    @FXML
    public Label payMessageLabel;

    public String ms;
    public String ns;
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File registerFile=new File("images/icons8-dyndns-96.png");
        Image registerImage = new Image(registerFile.toURI().toString());
        registerImageView.setImage(registerImage);
    }

    public void registerButtonOnAction(ActionEvent event)
    {
        if(passwordTextField.getText().equals(confirmpasswordTextField.getText()) )
        {
            registerUser();
            confirmpasswordMessageLabel.setText("");
        }
        else
        {
            confirmpasswordMessageLabel.setText("Password does not match.");
        }
    }

    public void exitButtonOnAction(ActionEvent event)
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        //Platform.exit();
    }
    public void registerUser()
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();
        String type = "Kullanıcı";
        String membership = ms;

        String insertFields = "INSERT INTO mirhats_account(firstName , lastName , username,password,tür,üyelik) VALUES ('";
        String insertValues = firstName+"','"+lastName+"','"+username+"','"+password+"','"+type+"','"+membership+"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            registerMessageLabel.setText("User has been registered successfully!");
            payMessageLabel.setText("You paid $30");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }

    public void getMembership(ActionEvent event)
    {
        if(normalRB.isSelected())
        {
            System.out.println(normalRB.getText());
            ms = normalRB.getText();
            payMessageLabel.setText("");
        }
        if(premiumRB.isSelected())
        {
            System.out.println(premiumRB.getText());
            ms = premiumRB.getText();
            payMessageLabel.setText("You will pay $30");
        }

    }
}
