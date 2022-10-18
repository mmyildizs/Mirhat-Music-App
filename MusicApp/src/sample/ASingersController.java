package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.Statement;

public class ASingersController {
    @FXML
    private TextField singerNameTextField;
    @FXML
    private TextField countryTextField;
    @FXML
    private Label addLabel;
    @FXML
    private TextField singerNameUpdateTextField;
    @FXML
    private TextField countryUpdateTextField;

    public void singerAddButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String singerName= singerNameTextField.getText() ;
        String country= countryTextField.getText();

        String insertFields = "INSERT INTO mirhats_sanatci(SanatciName,Ülke) VALUES ('";
        String insertValues = singerName+"','"+country+"')";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabel.setText("This singer added!");
            singerNameTextField.setText("");
            countryTextField.setText("");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
    public void singerDeleteButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String singerName= singerNameTextField.getText() ;
        String country= countryTextField.getText();

        String insertFields = "DELETE FROM mirhats_sanatci WHERE SanatciName = '";
        String insertValues = singerName+"'";
        String insertTo = insertFields+insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabel.setText("This singer deleted!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

    }
    public void singerUpdateButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String singerName= singerNameTextField.getText() ;
        String country= countryTextField.getText();
        String singerNameUpdate = singerNameUpdateTextField.getText();
        String countryUpdate = countryUpdateTextField.getText();

        String insertFields = "UPDATE mirhats_sanatci SET SanatciName = '"+singerNameUpdate+"', Ülke ='"+countryUpdate+"' WHERE SanatciName = '"+singerName+"'";
        String insertTo = insertFields;
        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertTo);

            addLabel.setText("This singer updated!");
        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
}
