package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class UserInterfaceController implements Initializable {
    @FXML
    private Label usernameLabel;
    @FXML
    private ImageView bgUserPanel;
    @FXML
    private ImageView userImageView;
    @FXML
    private ImageView searchUserImageView;
    @FXML
    private ImageView albumIconImageView;
    @FXML
    private ImageView psbcIconImageView;
    @FXML
    private ImageView psbtIconImageView;
    @FXML
    private ImageView psbgIconImageView;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane ancPane;




    public void initialize(URL url, ResourceBundle resourceBundle) {
        File userIconFile=new File("images/icons8-checked-user-male-96.png");
        Image userIconImage = new Image(userIconFile.toURI().toString());
        userImageView.setImage(userIconImage);

        File bgUserPanelFile=new File("images/AdminPanel.png");
        Image bgUserPanelImage = new Image(bgUserPanelFile.toURI().toString());
        bgUserPanel.setImage(bgUserPanelImage);

        File searchUserIconFile=new File("images/icons8-find-user-male-96.png");
        Image searchUserIconImage = new Image(searchUserIconFile.toURI().toString());
        searchUserImageView.setImage(searchUserIconImage);

        File albumIconFile=new File("images/icons8-music-library-96.png");
        Image albumIconImage = new Image(albumIconFile.toURI().toString());
        albumIconImageView.setImage(albumIconImage);

        File psbcIconFile=new File("images/icons8-globe-earth-96.png");
        Image psbcIconImage = new Image(psbcIconFile.toURI().toString());
        psbcIconImageView.setImage(psbcIconImage);

        File psbtIconFile=new File("images/icons8-musical-96.png");
        Image psbtIconImage = new Image(psbtIconFile.toURI().toString());
        psbtIconImageView.setImage(psbtIconImage);

        File psbgIconFile=new File("images/icons8-general-electrics-96.png");
        Image psbgIconImage = new Image(psbgIconFile.toURI().toString());
        psbgIconImageView.setImage(psbgIconImage);

    }

    public void exitButtonAction(ActionEvent event)
    {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void usersButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("UUsers.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void albumsButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("UAlbums.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void psbcButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("UPSBC.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void psbtButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("UPSBT.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void psbgButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("UPSBG.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }


}
