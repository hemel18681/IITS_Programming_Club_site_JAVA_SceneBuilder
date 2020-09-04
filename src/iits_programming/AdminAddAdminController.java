/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iits_programming;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;


    
/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminAddAdminController implements Initializable {
    @FXML
    private AnchorPane adminLoginPane, studentinfo,iitsprogrammingclub,AdminAddAdmin;
     @FXML
    private TextField adminid;

    @FXML
    private TextField adminname;

    @FXML
    private TextField adminuname;

    @FXML
    private TextField adminpass;
    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    public void go() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        AdminAddAdmin.getChildren().setAll(pane);
    }
    public void add() throws ClassNotFoundException, SQLException, IOException{
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "");
                Statement stmt = con.createStatement();
                String id=adminid.getText();
                int idd = Integer.parseInt(id);
                String name=adminname.getText();
                String uname=adminuname.getText();
                String pass=adminpass.getText();
                if("".equals(id)||"".equals(name)||"".equals(uname)||"".equals(pass)){
                    Alert a = new Alert(Alert.AlertType.NONE);
                    a.setAlertType(Alert.AlertType.WARNING);  
                    a.setContentText("Every field is required");
                    a.show(); 
                }
                else{
                    try{
                        String sql = " insert into admin_login (admin_id, admin_name, admin_username, admin_password)"+ " values (?, ?, ?, ?)";
                        PreparedStatement create=con.prepareStatement(sql);
                        System.out.println("sql working");
                        create.setString (1, id);
                        create.setString (2, name);
                        create.setString (3, uname);
                        create.setString (4, pass);
                        create.execute();
                        //System.out.println("sql execude");
                        go();
                    }
                    catch(IOException | SQLException e){
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.INFORMATION);  
                        a.setContentText("ID is already registered.");
                        a.show();
                    }
                }
//                log();
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
//                AdminAddAdmin.getChildren().setAll(pane);
    }
    public void log() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        AdminAddAdmin.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
