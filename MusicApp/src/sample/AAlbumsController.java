package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class AAlbumsController {
    @FXML
    private TextField albumTextField;
    @FXML
    private TextField singerNameTextField;
    @FXML
    private TextField songNameTextField;
    @FXML
    private TextField releaseDateTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private Label addLabels;

    @FXML
    private TextField albumUpdateTextField;

    public void albumAddButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String album= albumTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String songName = songNameTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String type = typeTextField.getText();


        String insertFields = "INSERT INTO mirhats_albüm(Albüm,SanatciName,SarkiName,ÇıkışTarihi,Tür) VALUES ('";
        String insertValues = album+"','"+singerName+"','"+songName+"','"+releaseDate+"','"+type+"')";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabels.setText("This album added!");
            songNameTextField.setText("");
            singerNameTextField.setText("");
            albumTextField.setText("");
            typeTextField.setText("");
            releaseDateTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void albumDeleteButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String album= albumTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String songName = songNameTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String type = typeTextField.getText();


        String insertFields = "DELETE FROM mirhats_albüm WHERE Albüm = '";
        String insertValues = album+"'";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabels.setText("This album deleted!");
            songNameTextField.setText("");
            singerNameTextField.setText("");
            albumTextField.setText("");
            typeTextField.setText("");
            releaseDateTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }
    public void albumUpdateButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String album= albumTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String songName = songNameTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String type = typeTextField.getText();

        String albumUpdate = albumUpdateTextField.getText();

        String insertFields = "UPDATE mirhats_albüm SET Albüm = '"+albumUpdate+"' WHERE Albüm = '"+album+"'";
        String insertTo = insertFields;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabels.setText("This album updated!");
            songNameTextField.setText("");
            singerNameTextField.setText("");
            albumTextField.setText("");
            typeTextField.setText("");
            releaseDateTextField.setText("");

            albumUpdateTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }
}
