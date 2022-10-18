package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminInterfaceController implements Initializable {
    @FXML
    private ImageView bgAdminPanel;
    @FXML
    private ImageView adminImageView;
    @FXML
    private ImageView searchUserImageView;
    @FXML
    private ImageView songIconImageView;
    @FXML
    private ImageView singerIconImageView;
    @FXML
    private ImageView albumIconImageView;
    @FXML
    private Button exitButton;
    @FXML
    private AnchorPane ancPane;



    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File adminIconFile=new File("images/icons8-admin-settings-male-96.png");
        Image adminIconImage = new Image(adminIconFile.toURI().toString());
        adminImageView.setImage(adminIconImage);

        File bgAdminPanelFile=new File("images/AdminPanel.png");
        Image bgAdminPanelImage = new Image(bgAdminPanelFile.toURI().toString());
        bgAdminPanel.setImage(bgAdminPanelImage);

        File searchUserIconFile=new File("images/icons8-find-user-male-96.png");
        Image searchUserIconImage = new Image(searchUserIconFile.toURI().toString());
        searchUserImageView.setImage(searchUserIconImage);

        File songIconFile=new File("images/icons8-musical-notes-96.png");
        Image songIconImage = new Image(songIconFile.toURI().toString());
        songIconImageView.setImage(songIconImage);

        File singerIconFile=new File("images/icons8-audio-wave-96.png");
        Image singerIconImage = new Image(singerIconFile.toURI().toString());
        singerIconImageView.setImage(singerIconImage);

        File albumIconFile=new File("images/icons8-music-library-96.png");
        Image albumIconImage = new Image(albumIconFile.toURI().toString());
        albumIconImageView.setImage(albumIconImage);
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
            Parent fxml = FXMLLoader.load(getClass().getResource("AUsers.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void songsButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("ASongs.fxml"));
            ancPane.getChildren().removeAll();
            ancPane.getChildren().setAll(fxml);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void singersButtonAction(ActionEvent event)
    {
        try {
            Parent fxml = FXMLLoader.load(getClass().getResource("ASingers.fxml"));
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
            Parent fxml = FXMLLoader.load(getClass().getResource("AAlbums.fxml"));
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
