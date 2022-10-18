package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UUsersController implements Initializable {
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
    @FXML
    private Button followButton1;
    @FXML
    private Button followButton2;
    @FXML
    private Button followButton3;
    @FXML
    private Button followButton4;
    @FXML
    private Button followButton5;
    @FXML
    private Button followButton6;
    @FXML
    private Button followButton7;
    @FXML
    private Button followButton8;
    @FXML
    private Button followButton9;
    @FXML
    private Button followButton10;
    @FXML
    private Button followButton11;
    @FXML
    private Button followButton12;

    @FXML
    private Button unfollowButton1;
    @FXML
    private Button unfollowButton2;
    @FXML
    private Button unfollowButton3;
    @FXML
    private Button unfollowButton4;
    @FXML
    private Button unfollowButton5;
    @FXML
    private Button unfollowButton6;
    @FXML
    private Button unfollowButton7;
    @FXML
    private Button unfollowButton8;
    @FXML
    private Button unfollowButton9;
    @FXML
    private Button unfollowButton10;
    @FXML
    private Button unfollowButton11;
    @FXML
    private Button unfollowButton12;




    List<String> usersList = new ArrayList<String>();
    List<String> mmList = new ArrayList<String>();
    public int co=0;
    public int mo=0;

    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        followButton1.setVisible(false);
        followButton2.setVisible(false);
        followButton3.setVisible(false);
        followButton4.setVisible(false);
        followButton5.setVisible(false);
        followButton6.setVisible(false);
        followButton7.setVisible(false);
        followButton8.setVisible(false);
        followButton9.setVisible(false);
        followButton10.setVisible(false);
        followButton11.setVisible(false);
        followButton12.setVisible(false);

        unfollowButton1.setVisible(false);
        unfollowButton2.setVisible(false);
        unfollowButton3.setVisible(false);
        unfollowButton4.setVisible(false);
        unfollowButton5.setVisible(false);
        unfollowButton6.setVisible(false);
        unfollowButton7.setVisible(false);
        unfollowButton8.setVisible(false);
        unfollowButton9.setVisible(false);
        unfollowButton10.setVisible(false);
        unfollowButton11.setVisible(false);
        unfollowButton12.setVisible(false);


    }


    public void viewButtonAction(ActionEvent event) {



        DatabaseConnection connectionN = new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String users = "SELECT username,üyelik FROM mirhats_account";
        String membership = "SELECT username,üyelik FROM mirhats_account";

        try {


            Statement statement = connectDB.createStatement();
            ResultSet queryOutput = statement.executeQuery(users);

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput2 = statement2.executeQuery(membership);
            while (queryOutput.next()) {
                String resString = queryOutput.getString("username");
                usersList.add(resString);
                System.out.println(usersList.get(co));

                co++;

            }
            while (queryOutput2.next()) {
                String mmString = queryOutput2.getString("üyelik");
                mmList.add(mmString);
                System.out.println(mmList.get(mo));
                mo++;
            }
            for (int i = 1; i < co; i++) {
                if (i == 1) {
                    showUsersLabel.setText(String.valueOf(usersList.get(1)));
                }
                if (i == 2) {
                    showUsersLabel2.setText(String.valueOf(usersList.get(2)));
                }
                if (i == 3) {
                    showUsersLabel3.setText(String.valueOf(usersList.get(3)));
                }
                if (i == 4) {
                    showUsersLabel4.setText(String.valueOf(usersList.get(4)));
                }
                if (i == 5) {
                    showUsersLabel5.setText(String.valueOf(usersList.get(5)));
                }
                if (i == 6) {
                    showUsersLabel6.setText(String.valueOf(usersList.get(6)));
                }
                if (i == 7) {
                    showUsersLabel7.setText(String.valueOf(usersList.get(7)));
                }
                if (i == 8) {
                    showUsersLabel8.setText(String.valueOf(usersList.get(8)));
                }

            }

            for (int i = 1; i < mo; i++) {
                if (i == 1) {
                    if ((String.valueOf(mmList.get(1))).equals("Premium")) {
                        showUsersMMLabel1.setTextFill(Color.DARKORANGE);
                        followButton1.setVisible(true);
                    }
                    else
                    {
                        followButton1.setVisible(true);
                        followButton1.setDisable(true);
                    }
                    showUsersMMLabel1.setText(String.valueOf(mmList.get(1)));
                }
                if (i == 2) {
                    if ((String.valueOf(mmList.get(2))).equals("Premium")) {
                        showUsersMMLabel2.setTextFill(Color.DARKORANGE);
                        followButton2.setVisible(true);
                    }
                    else
                    {
                        followButton2.setVisible(true);
                        followButton2.setDisable(true);
                    }
                    showUsersMMLabel2.setText(String.valueOf(mmList.get(2)));
                }
                if (i == 3) {
                    if ((String.valueOf(mmList.get(3))).equals("Premium")) {
                        showUsersMMLabel3.setTextFill(Color.ORANGE);
                        followButton3.setVisible(true);
                    }
                    else
                    {
                        followButton3.setVisible(true);
                        followButton3.setDisable(true);
                    }
                    showUsersMMLabel3.setText(String.valueOf(mmList.get(3)));
                }
                if (i == 4) {
                    if ((String.valueOf(mmList.get(4))).equals("Premium")) {
                        showUsersMMLabel4.setTextFill(Color.DARKORANGE);
                        followButton4.setVisible(true);
                    }
                    else
                    {
                        followButton4.setVisible(true);
                        followButton4.setDisable(true);
                    }
                    showUsersMMLabel4.setText(String.valueOf(mmList.get(4)));
                }
                if (i == 5) {
                    if ((String.valueOf(mmList.get(5))).equals("Premium")) {
                        showUsersMMLabel5.setTextFill(Color.DARKORANGE);
                        followButton5.setVisible(true);
                    }
                    else
                    {
                        followButton5.setVisible(true);
                        followButton5.setDisable(true);
                    }
                    showUsersMMLabel5.setText(String.valueOf(mmList.get(5)));
                }
                if (i == 6) {
                    if ((String.valueOf(mmList.get(6))).equals("Premium")) {
                        showUsersMMLabel6.setTextFill(Color.DARKORANGE);
                        followButton6.setVisible(true);
                    }
                    else
                    {
                        followButton6.setVisible(true);
                        followButton6.setDisable(true);
                    }
                    showUsersMMLabel6.setText(String.valueOf(mmList.get(6)));
                }
                if (i == 7) {
                    if ((String.valueOf(mmList.get(7))).equals("Premium")) {
                        showUsersMMLabel7.setTextFill(Color.DARKORANGE);
                        followButton7.setVisible(true);
                    }
                    else
                    {
                        followButton7.setVisible(true);
                        followButton7.setDisable(true);
                    }
                    showUsersMMLabel7.setText(String.valueOf(mmList.get(7)));
                }
                if (i == 8) {
                    if ((String.valueOf(mmList.get(8))).equals("Premium")) {
                        showUsersMMLabel8.setTextFill(Color.DARKORANGE);
                        followButton8.setVisible(true);
                    }
                    else
                    {
                        followButton8.setVisible(true);
                        followButton8.setDisable(true);
                    }
                    showUsersMMLabel8.setText(String.valueOf(mmList.get(8)));
                }

            }

            viewButton.setDisable(true);


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void followButtonAction1(ActionEvent event)
    {
        followButton1.setVisible(false);
        unfollowButton1.setVisible(true);

    }
    public void followButtonAction2(ActionEvent event)
    {
        followButton2.setVisible(false);
        unfollowButton2.setVisible(true);
    }
    public void followButtonAction3(ActionEvent event)
    {
        followButton3.setVisible(false);
        unfollowButton3.setVisible(true);
    }
    public void followButtonAction4(ActionEvent event)
    {
        followButton4.setVisible(false);
        unfollowButton4.setVisible(true);
    }
    public void followButtonAction5(ActionEvent event)
    {
        followButton5.setVisible(false);
        unfollowButton5.setVisible(true);
    }
    public void followButtonAction6(ActionEvent event)
    {
        followButton6.setVisible(false);
        unfollowButton6.setVisible(true);
    }
    public void followButtonAction7(ActionEvent event)
    {
        followButton7.setVisible(false);
        unfollowButton7.setVisible(true);
    }
    public void followButtonAction8(ActionEvent event)
    {
        followButton8.setVisible(false);
        unfollowButton8.setVisible(true);
    }
    public void followButtonAction9(ActionEvent event)
    {
        followButton9.setVisible(false);
        unfollowButton9.setVisible(true);
    }
    public void followButtonAction10(ActionEvent event)
    {
        followButton10.setVisible(false);
        unfollowButton10.setVisible(true);
    }
    public void followButtonAction11(ActionEvent event)
    {
        followButton11.setVisible(false);
        unfollowButton11.setVisible(true);
    }
    public void followButtonAction12(ActionEvent event)
    {
        followButton12.setVisible(false);
        unfollowButton12.setVisible(true);
    }

    public void unfollowButtonAction1(ActionEvent event)
    {
        followButton1.setVisible(true);
        unfollowButton1.setVisible(false);
    }
    public void unfollowButtonAction2(ActionEvent event)
    {
        followButton2.setVisible(true);
        unfollowButton2.setVisible(false);
    }
    public void unfollowButtonAction3(ActionEvent event)
    {
        followButton3.setVisible(true);
        unfollowButton3.setVisible(false);
    }
    public void unfollowButtonAction4(ActionEvent event)
    {
        followButton4.setVisible(true);
        unfollowButton4.setVisible(false);
    }
    public void unfollowButtonAction5(ActionEvent event)
    {
        followButton5.setVisible(true);
        unfollowButton5.setVisible(false);
    }
    public void unfollowButtonAction6(ActionEvent event)
    {
        followButton6.setVisible(true);
        unfollowButton6.setVisible(false);
    }
    public void unfollowButtonAction7(ActionEvent event)
    {
        followButton7.setVisible(true);
        unfollowButton7.setVisible(false);
    }
    public void unfollowButtonAction8(ActionEvent event)
    {
        followButton8.setVisible(true);
        unfollowButton8.setVisible(false);
    }
    public void unfollowButtonAction9(ActionEvent event)
    {
        followButton9.setVisible(true);
        unfollowButton9.setVisible(false);
    }
    public void unfollowButtonAction10(ActionEvent event)
    {
        followButton10.setVisible(true);
        unfollowButton10.setVisible(false);
    }
    public void unfollowButtonAction11(ActionEvent event)
    {
        followButton11.setVisible(true);
        unfollowButton11.setVisible(false);
    }
    public void unfollowButtonAction12(ActionEvent event)
    {
        followButton12.setVisible(true);
        unfollowButton12.setVisible(false);
    }


}
