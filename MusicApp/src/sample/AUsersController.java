package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AUsersController {
    @FXML
    private Label showUsersLabel;
    @FXML
    private Label showUsersLabel2;
    @FXML
    private Label showUsersLabel3;
    @FXML
    private Label showUsersLabel4;
    @FXML
    private Label showUsersLabel5;
    @FXML
    private Label showUsersLabel6;
    @FXML
    private Label showUsersLabel7;
    @FXML
    private Label showUsersLabel8;
    @FXML
    private Label showUsersMMLabel1;
    @FXML
    private Label showUsersMMLabel2;
    @FXML
    private Label showUsersMMLabel3;
    @FXML
    private Label showUsersMMLabel4;
    @FXML
    private Label showUsersMMLabel5;
    @FXML
    private Label showUsersMMLabel6;
    @FXML
    private Label showUsersMMLabel7;
    @FXML
    private Label showUsersMMLabel8;
    @FXML
    private Button viewButton;

    List<String> usersList = new ArrayList<String>();
    List<String> mmList = new ArrayList<String>();
    public int co=0;
    public int mo=0;

    public void viewButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN =new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String users = "SELECT username,üyelik FROM mirhats_account";
        String membership = "SELECT username,üyelik FROM mirhats_account";

        try
        {
            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(users);

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput2 = statement2.executeQuery(membership);
            while(queryOutput.next())
            {
                String resString = queryOutput.getString("username");
                usersList.add(resString);
                System.out.println(usersList.get(co));

                co++;

            }
            while(queryOutput2.next())
            {
                String mmString = queryOutput2.getString("üyelik");
                mmList.add(mmString);
                System.out.println(mmList.get(mo));
                mo++;
            }
            for(int i =1;i<co;i++)
            {
                if(i==1)
                {
                    showUsersLabel.setText(String.valueOf(usersList.get(1)));
                }
                if(i==2)
                {
                    showUsersLabel2.setText(String.valueOf(usersList.get(2)));
                }
                if(i==3)
                {
                    showUsersLabel3.setText(String.valueOf(usersList.get(3)));
                }
                if(i==4)
                {
                    showUsersLabel4.setText(String.valueOf(usersList.get(4)));
                }
                if(i==5)
                {
                    showUsersLabel5.setText(String.valueOf(usersList.get(5)));
                }
                if(i==6)
                {
                    showUsersLabel6.setText(String.valueOf(usersList.get(6)));
                }
                if(i==7)
                {
                    showUsersLabel7.setText(String.valueOf(usersList.get(7)));
                }
                if(i==8)
                {
                    showUsersLabel8.setText(String.valueOf(usersList.get(8)));
                }

            }

            for(int i =1;i<mo;i++)
            {
                if(i==1)
                {
                    if((String.valueOf(mmList.get(1))).equals("Premium"))
                    {
                        showUsersMMLabel1.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel1.setText(String.valueOf(mmList.get(1)));
                }
                if(i==2)
                {
                    if((String.valueOf(mmList.get(2))).equals("Premium"))
                    {
                        showUsersMMLabel2.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel2.setText(String.valueOf(mmList.get(2)));
                }
                if(i==3)
                {
                    if((String.valueOf(mmList.get(3))).equals("Premium"))
                    {
                        showUsersMMLabel3.setTextFill(Color.ORANGE);
                    }
                    showUsersMMLabel3.setText(String.valueOf(mmList.get(3)));
                }
                if(i==4)
                {
                    if((String.valueOf(mmList.get(4))).equals("Premium"))
                    {
                        showUsersMMLabel4.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel4.setText(String.valueOf(mmList.get(4)));
                }
                if(i==5)
                {
                    if((String.valueOf(mmList.get(5))).equals("Premium"))
                    {
                        showUsersMMLabel5.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel5.setText(String.valueOf(mmList.get(5)));
                }
                if(i==6)
                {
                    if((String.valueOf(mmList.get(6))).equals("Premium"))
                    {
                        showUsersMMLabel6.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel6.setText(String.valueOf(mmList.get(6)));
                }
                if(i==7)
                {
                    if((String.valueOf(mmList.get(7))).equals("Premium"))
                    {
                        showUsersMMLabel7.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel7.setText(String.valueOf(mmList.get(7)));
                }
                if(i==8)
                {
                    if((String.valueOf(mmList.get(8))).equals("Premium"))
                    {
                        showUsersMMLabel8.setTextFill(Color.DARKORANGE);
                    }
                    showUsersMMLabel8.setText(String.valueOf(mmList.get(8)));
                }

            }

            viewButton.setDisable(true);




        }
        catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }
}
