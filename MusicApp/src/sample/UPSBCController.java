package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UPSBCController implements Initializable {
    @FXML
    private Label showSongsLabel1;
    @FXML
    private Label showSongsLabel2;
    @FXML
    private Label showSongsLabel3;
    @FXML
    private Label showSongsLabel4;
    @FXML
    private Label showSongsLabel5;
    @FXML
    private Label showSongsLabel6;
    @FXML
    private Label showSongsLabel7;
    @FXML
    private Label showSongsLabel8;
    @FXML
    private Label showSongsLabel9;
    @FXML
    private Label showSongsLabel10;


    @FXML
    private ImageView play;
    @FXML
    private ImageView back;
    @FXML
    private ImageView next;

    @FXML
    private Label labelSingerName;
    @FXML
    private Label labelSongName;
    @FXML
    private Label labelTime;

    @FXML
    private Button backButton;
    @FXML
    private Button nextButton;
    @FXML
    private Button playButton;

    @FXML
    private Button viewButton;

    @FXML
    private TextField countryTextField;


    List<String> songsList = new ArrayList<String>();
    List<String> singersList = new ArrayList<String>();
    List<String> typesList = new ArrayList<String>();
    List<String> countListensList = new ArrayList<String>();
    List<String> timeList = new ArrayList<String>();
    List<String> countryList = new ArrayList<String>();

    public int c1=0;
    public int c2=0;
    public int c3=0;
    public int c4=0;
    public int c5=0;
    public int c6=0;

    public int x=0;



    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        File playIconFile=new File("images/icons8-play-96.png");
        Image playIconImage = new Image(playIconFile.toURI().toString());
        play.setImage(playIconImage);

        File backIconFile=new File("images/icons8-rewind-96.png");
        Image backIconImage = new Image(backIconFile.toURI().toString());
        back.setImage(backIconImage);

        File nextIconFile=new File("images/icons8-fast-forward-96.png");
        Image nextIconImage = new Image(nextIconFile.toURI().toString());
        next.setImage(nextIconImage);
    }

    public void viewButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN =new DatabaseConnection();
        Connection connectDB = connectionN.getConnection();

        String psbc = "SELECT SarkiName,SanatciName,DinlenmeSayisi,Tür,Süre,Ülke FROM mirhats_sarki WHERE Ülke='"+countryTextField.getText()+"' ORDER BY DinlenmeSayisi DESC";

        try {
            Statement statement1 = connectDB.createStatement();
            ResultSet queryOutput = statement1.executeQuery(psbc);

            Statement statement2 = connectDB.createStatement();
            ResultSet queryOutput2 = statement2.executeQuery(psbc);

            Statement statement3 = connectDB.createStatement();
            ResultSet queryOutput3 = statement3.executeQuery(psbc);

            Statement statement4 = connectDB.createStatement();
            ResultSet queryOutput4 = statement4.executeQuery(psbc);

            Statement statement5 = connectDB.createStatement();
            ResultSet queryOutput5 = statement5.executeQuery(psbc);

            Statement statement6 = connectDB.createStatement();
            ResultSet queryOutput6 = statement6.executeQuery(psbc);
            while(queryOutput.next())
            {
                String rString1= queryOutput.getString("SarkiName");
                songsList.add(rString1);
                System.out.println(songsList.get(c1));
                c1++;
            }

            while(queryOutput2.next())
            {
                String rString2= queryOutput2.getString("SanatciName");
                singersList.add(rString2);
                System.out.println(singersList.get(c2));
                c2++;
            }
            while(queryOutput3.next())
            {
                String rString3= queryOutput3.getString("Tür");
                typesList.add(rString3);
                System.out.println(typesList.get(c3));
                c3++;
            }
            while(queryOutput4.next())
            {
                String rString4= queryOutput4.getString("DinlenmeSayisi");
                countListensList.add(rString4);
                System.out.println(countListensList.get(c4));
                c4++;
            }
            while(queryOutput5.next())
            {
                String rString5= queryOutput5.getString("Süre");
                timeList.add(rString5);
                //System.out.println(timeList.get(c5));
                c5++;
            }
            while(queryOutput6.next())
            {
                String rString6= queryOutput6.getString("Ülke");
                countryList.add(rString6);
                //System.out.println(timeList.get(c5));
                c6++;
            }
            for(int i =0;i<c1;i++)
            {
                if(i==0)
                {
                    showSongsLabel1.setText(String.valueOf(1+" - "+songsList.get(0)+" - "+singersList.get(0)+" - "+typesList.get(0)+" - "+countListensList.get(0)));
                }
                if(i==1)
                {
                    showSongsLabel2.setText(String.valueOf(2+" - "+songsList.get(1)+" - "+singersList.get(1)+" - "+typesList.get(1)+" - "+countListensList.get(1)));
                }
                if(i==2)
                {
                    showSongsLabel3.setText(String.valueOf(3+" - "+songsList.get(2)+" - "+singersList.get(2)+" - "+typesList.get(2)+" - "+countListensList.get(2)));
                }
                if(i==3)
                {
                    showSongsLabel4.setText(String.valueOf(4+" - "+songsList.get(3)+" - "+singersList.get(3)+" - "+typesList.get(3)+" - "+countListensList.get(3)));
                }
                if(i==4)
                {
                    showSongsLabel5.setText(String.valueOf(5+" - "+songsList.get(4)+" - "+singersList.get(4)+" - "+typesList.get(4)+" - "+countListensList.get(4)));
                }
                if(i==5)
                {
                    showSongsLabel6.setText(String.valueOf(6+" - "+songsList.get(5)+" - "+singersList.get(5)+" - "+typesList.get(5)+" - "+countListensList.get(5)));
                }
                if(i==6)
                {
                    showSongsLabel7.setText(String.valueOf(7+" - "+songsList.get(6)+" - "+singersList.get(6)+" - "+typesList.get(6)+" - "+countListensList.get(6)));
                }
                if(i==7)
                {
                    showSongsLabel8.setText(String.valueOf(8+" - "+songsList.get(7)+" - "+singersList.get(7)+" - "+typesList.get(7)+" - "+countListensList.get(7)));
                }
                if(i==8)
                {
                    showSongsLabel9.setText(String.valueOf(9+" - "+songsList.get(8)+" - "+singersList.get(8)+" - "+typesList.get(8)+" - "+countListensList.get(8)));
                }
                if(i==9)
                {
                    showSongsLabel10.setText(String.valueOf(10+" - "+songsList.get(9)+" - "+singersList.get(9)+" - "+typesList.get(9)+" - "+countListensList.get(9)));
                }

            }

        }
        catch (Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }

        viewButton.setDisable(true);

    }

    public void playButtonAction(ActionEvent event)
    {
        DatabaseConnection connectionN1 = new DatabaseConnection();
        Connection connectDB1 = connectionN1.getConnection();

        String countListen = "UPDATE mirhats_sarki SET DinlenmeSayisi="+(Integer.parseInt(countListensList.get(x))+1)+" WHERE SarkiName='"+songsList.get(x)+"'";
        String insertTo = countListen;

        countListensList.set(x,Integer.toString(Integer.parseInt(countListensList.get(x))+1));


        if (x == 0) {
            showSongsLabel1.setText(String.valueOf(1 + " - " + songsList.get(0) + " - " + singersList.get(0) + " - " + typesList.get(0) + " - " + countListensList.get(0)));
        }
        if (x == 1) {
            showSongsLabel2.setText(String.valueOf(2 + " - " + songsList.get(1) + " - " + singersList.get(1) + " - " + typesList.get(1) + " - " + countListensList.get(1)));
        }
        if (x == 2) {
            showSongsLabel3.setText(String.valueOf(3 + " - " + songsList.get(2) + " - " + singersList.get(2) + " - " + typesList.get(2) + " - " + countListensList.get(2)));
        }
        if (x == 3) {
            showSongsLabel4.setText(String.valueOf(4 + " - " + songsList.get(3) + " - " + singersList.get(3) + " - " + typesList.get(3) + " - " + countListensList.get(3)));
        }
        if (x == 4) {
            showSongsLabel5.setText(String.valueOf(5 + " - " + songsList.get(4) + " - " + singersList.get(4) + " - " + typesList.get(4) + " - " + countListensList.get(4)));
        }
        if (x == 5) {
            showSongsLabel6.setText(String.valueOf(6 + " - " + songsList.get(5) + " - " + singersList.get(5) + " - " + typesList.get(5) + " - " + countListensList.get(5)));
        }
        if (x == 6) {
            showSongsLabel7.setText(String.valueOf(7 + " - " + songsList.get(6) + " - " + singersList.get(6) + " - " + typesList.get(6) + " - " + countListensList.get(6)));
        }
        if (x == 7) {
            showSongsLabel8.setText(String.valueOf(8 + " - " + songsList.get(7) + " - " + singersList.get(7) + " - " + typesList.get(7) + " - " + countListensList.get(7)));
        }
        if (x == 8) {
            showSongsLabel9.setText(String.valueOf(9 + " - " + songsList.get(8) + " - " + singersList.get(8) + " - " + typesList.get(8) + " - " + countListensList.get(8)));
        }
        if (x == 9) {
            showSongsLabel10.setText(String.valueOf(10 + " - " + songsList.get(9) + " - " + singersList.get(9) + " - " + typesList.get(9) + " - " + countListensList.get(9)));
        }

        try
        {
            Statement statementCL = connectDB1.createStatement();
            statementCL.executeUpdate(insertTo);


        }
        catch(Exception e)
        {
            e.printStackTrace();
            e.getCause();
        }
    }

    public void backButtonAction(ActionEvent event)
    {

    }

    public void nextButtonAction(ActionEvent event)
    {

    }

    public void Listen1Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(0));
        labelSingerName.setText(singersList.get(0));
        labelTime.setText(timeList.get(0));
        x=0;
    }
    public void Listen2Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(1));
        labelSingerName.setText(singersList.get(1));
        labelTime.setText(timeList.get(1));
        x=1;
    }
    public void Listen3Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(2));
        labelSingerName.setText(singersList.get(2));
        labelTime.setText(timeList.get(2));
        x=2;
    }
    public void Listen4Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(3));
        labelSingerName.setText(singersList.get(3));
        labelTime.setText(timeList.get(3));
        x=3;
    }
    public void Listen5Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(4));
        labelSingerName.setText(singersList.get(4));
        labelTime.setText(timeList.get(4));
        x=4;
    }
    public void Listen6Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(5));
        labelSingerName.setText(singersList.get(5));
        labelTime.setText(timeList.get(5));
        x=5;
    }
    public void Listen7Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(6));
        labelSingerName.setText(singersList.get(6));
        labelTime.setText(timeList.get(6));
        x=6;
    }
    public void Listen8Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(7));
        labelSingerName.setText(singersList.get(7));
        labelTime.setText(timeList.get(7));
        x=7;
    }
    public void Listen9Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(8));
        labelSingerName.setText(singersList.get(8));
        labelTime.setText(timeList.get(8));
        x=8;
    }
    public void Listen10Action(ActionEvent event)
    {
        labelSongName.setText(songsList.get(9));
        labelSingerName.setText(singersList.get(9));
        labelTime.setText(timeList.get(9));
        x=9;
    }
}
