package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class ASongsController {
    @FXML
    private TextField songNameTextField;
    @FXML
    private TextField singerNameTextField;
    @FXML
    private TextField albumTextField;
    @FXML
    private TextField typeTextField;
    @FXML
    private TextField releaseDateTextField;
    @FXML
    private TextField songTimeTextField;
    @FXML
    private Label addLabels;

    @FXML
    private TextField songNameUpdateTextField;
    @FXML
    private TextField singerNameUpdateTextField;
    @FXML
    private TextField albumUpdateTextField;
    @FXML
    private TextField typeUpdateTextField;
    @FXML
    private TextField releaseDateUpdateTextField;
    @FXML
    private TextField songTimeUpdateTextField;

    public void songAddButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String songName = songNameTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String album= albumTextField.getText();
        String type = typeTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String songTime = songTimeTextField.getText();
        int dinlenmeSayisi = 0;


        String insertFields = "INSERT INTO mirhats_sarki(SarkiName,SanatciName,Albüm,ÇıkışTarihi,Tür,Süre,DinlenmeSayisi) VALUES ('";
        String insertValues = songName+"','"+singerName+"','"+album+"','"+releaseDate+"','"+type+"','"+songTime+"','"+dinlenmeSayisi+"')";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabels.setText("This song added!");
            songNameTextField.setText("");
            singerNameTextField.setText("");
            albumTextField.setText("");
            typeTextField.setText("");
            releaseDateTextField.setText("");
            songTimeTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void songDeleteButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String songName = songNameTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String album= albumTextField.getText();
        String type = typeTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String songTime = songTimeTextField.getText();
        int dinlenmeSayisi = 0;


        String insertFields = "DELETE FROM mirhats_sarki WHERE SarkiName = '";
        String insertValues = songName+"'";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabels.setText("This song deleted!");
            songNameTextField.setText("");
            singerNameTextField.setText("");
            albumTextField.setText("");
            typeTextField.setText("");
            releaseDateTextField.setText("");
            songTimeTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void songUpdateButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String songName = songNameTextField.getText();
        String singerName= singerNameTextField.getText() ;
        String album= albumTextField.getText();
        String type = typeTextField.getText();
        String releaseDate = releaseDateTextField.getText();
        String songTime = songTimeTextField.getText();
        int dinlenmeSayisi = 0;

        String songNameUpdate = songNameUpdateTextField.getText();
        String singerNameUpdate = singerNameUpdateTextField.getText();
        String albumUpdate = albumUpdateTextField.getText();
        String typeUpdate = typeUpdateTextField.getText();
        String releaseDateUpdate = releaseDateUpdateTextField.getText();
        String songTimeUpdate = songTimeUpdateTextField.getText();

        if(singerNameUpdate == "" && albumUpdate == "" && typeUpdate == "" && releaseDateUpdate == "" && songTimeUpdate == "")
        {
            //String insertFields = "UPDATE mirhats_sarki SET SarkiName = '"+songNameUpdate+"', SanatciName ='"+singerNameUpdate+"', Albüm ='"+albumUpdate+"',ÇıkışTarihi='"+releaseDateUpdate+"',Tür='"+typeUpdate+"',Süre='"+songTimeUpdate+"' WHERE SarkiName = '"+songName+"'";
            String insertFields = "UPDATE mirhats_sarki SET SarkiName = '"+songNameUpdate+"' WHERE SarkiName = '"+songName+"'";
            String insertTo = insertFields;

            try {
                Statement statement = connectDB.createStatement();
                statement.executeUpdate(insertTo);

                addLabels.setText("This singer updated!");
                songNameTextField.setText("");
                singerNameTextField.setText("");
                albumTextField.setText("");
                typeTextField.setText("");
                releaseDateTextField.setText("");
                songTimeTextField.setText("");
                songNameUpdateTextField.setText("");
                singerNameUpdateTextField.setText("");
                albumUpdateTextField.setText("");
                typeUpdateTextField.setText("");
                releaseDateUpdateTextField.setText("");
                songTimeUpdateTextField.setText("");
            }
            catch (Exception e)
            {
                e.printStackTrace();
                e.getCause();
            }
        }

        if(songNameUpdate == "" && albumUpdate == "" && typeUpdate == "" && releaseDateUpdate == "" && songTimeUpdate == "")
        {
            if(songName != "" && singerName != "") {
                //String insertFields = "UPDATE mirhats_sarki SET SarkiName = '"+songNameUpdate+"', SanatciName ='"+singerNameUpdate+"', Albüm ='"+albumUpdate+"',ÇıkışTarihi='"+releaseDateUpdate+"',Tür='"+typeUpdate+"',Süre='"+songTimeUpdate+"' WHERE SarkiName = '"+songName+"'";
                String insertFields = "UPDATE mirhats_sarki SET SanatciName = '" + singerNameUpdate + "' WHERE SarkiName = '" + songName + "' and SanatciName = '" + singerName + "'";
                String insertTo = insertFields;

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertTo);

                    addLabels.setText("This singer updated!");
                    songNameTextField.setText("");
                    singerNameTextField.setText("");
                    albumTextField.setText("");
                    typeTextField.setText("");
                    releaseDateTextField.setText("");
                    songTimeTextField.setText("");
                    songNameUpdateTextField.setText("");
                    singerNameUpdateTextField.setText("");
                    albumUpdateTextField.setText("");
                    typeUpdateTextField.setText("");
                    releaseDateUpdateTextField.setText("");
                    songTimeUpdateTextField.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
            if(songName == "" && singerName !="")
            {
                String insertFields = "UPDATE mirhats_sarki SET SanatciName = '" + singerNameUpdate + "' WHERE SanatciName = '" + singerName + "'";
                String insertTo = insertFields;

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertTo);

                    addLabels.setText("This singer updated!");
                    songNameTextField.setText("");
                    singerNameTextField.setText("");
                    albumTextField.setText("");
                    typeTextField.setText("");
                    releaseDateTextField.setText("");
                    songTimeTextField.setText("");
                    songNameUpdateTextField.setText("");
                    singerNameUpdateTextField.setText("");
                    albumUpdateTextField.setText("");
                    typeUpdateTextField.setText("");
                    releaseDateUpdateTextField.setText("");
                    songTimeUpdateTextField.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        }

        if(songNameUpdate == "" && singerNameUpdate == "" && typeUpdate == "" && releaseDateUpdate == "" && songTimeUpdate == "")
        {
            if(songName != "" && singerName != "") {
                String insertFields = "UPDATE mirhats_sarki SET Albüm = '" + albumUpdate + "' WHERE SarkiName = '" + songName + "' and SanatciName = '" + singerName + "'";
                String insertTo = insertFields;

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertTo);

                    addLabels.setText("This singer updated!");
                    songNameTextField.setText("");
                    singerNameTextField.setText("");
                    albumTextField.setText("");
                    typeTextField.setText("");
                    releaseDateTextField.setText("");
                    songTimeTextField.setText("");
                    songNameUpdateTextField.setText("");
                    singerNameUpdateTextField.setText("");
                    albumUpdateTextField.setText("");
                    typeUpdateTextField.setText("");
                    releaseDateUpdateTextField.setText("");
                    songTimeUpdateTextField.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
            if(songName == "")
            {
                String insertFields = "UPDATE mirhats_sarki SET Albüm = '" + albumUpdate + "' WHERE SanatciName = '" + singerName + "' and Albüm = '"+album+"'";
                String insertTo = insertFields;

                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertTo);

                    addLabels.setText("This singer updated!");
                    songNameTextField.setText("");
                    singerNameTextField.setText("");
                    albumTextField.setText("");
                    typeTextField.setText("");
                    releaseDateTextField.setText("");
                    songTimeTextField.setText("");
                    songNameUpdateTextField.setText("");
                    singerNameUpdateTextField.setText("");
                    albumUpdateTextField.setText("");
                    typeUpdateTextField.setText("");
                    releaseDateUpdateTextField.setText("");
                    songTimeUpdateTextField.setText("");
                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }
            }
        }



    }
}
