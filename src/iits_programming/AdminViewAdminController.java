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
import java.sql.ResultSet;
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
public class AdminViewAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane AdminViewAdmin;
    
    
    @FXML
    private TextField adminid;

    @FXML
    private TextField adminname;

    @FXML
    private TextField adminusername;
    
    public void go() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        AdminViewAdmin.getChildren().setAll(pane);
    }
     
     public void log() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        AdminViewAdmin.getChildren().setAll(pane);
    }
    
     public void reset(){
        adminid.clear();
        adminname.clear();
        adminusername.clear();
    }
     
     public void adminviewadmin() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "");
        Statement stmt = con.createStatement();
        String name=adminid.getText();
        if("".equals(name)){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.WARNING);  
            a.setContentText("ID is required");
            a.show();
        }
        else{
            try{
                ResultSet rs = stmt.executeQuery("select * from admin_login where admin_id='"+name+"'");
                if(rs.next()){
                    rs = stmt.executeQuery("select * from admin_login where admin_id='"+name+"'");
                    while(rs.next()) {
                     adminname.setText(rs.getString("admin_name"));
                     adminusername.setText(rs.getString("admin_username"));
                    }
                }
                else{
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.INFORMATION);  
                        a.setContentText("ID is not registered.");
                        a.show();
                }
                 
            }
            catch(SQLException e){
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.ERROR);  
                a.setContentText("ID is not registered.");
                a.show();
            }
        }
        
        
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
