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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import static jdk.nashorn.internal.runtime.Debug.id;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminDeleteAdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane adminLoginPane, studentinfo,iitsprogrammingclub,AdminDeleteAdmin;
    
    @FXML
    private TextField adminid;
    
     public void go() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        AdminDeleteAdmin.getChildren().setAll(pane);
    }
     
     public void log() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        AdminDeleteAdmin.getChildren().setAll(pane);
    }
    
    
        @FXML
         private void admindeleteadmin(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
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
                        if(rs.next()) {
                              String sql2="Delete from admin_login Where admin_login.admin_id='"+name+"'";
                              PreparedStatement create=con.prepareStatement(sql2);
                              create.executeUpdate();
                              go();  
                         }
                        else{
                            Alert a = new Alert(Alert.AlertType.NONE);
                            a.setAlertType(Alert.AlertType.ERROR);  
                            a.setContentText("ID is already not registered.");
                            a.show();
                        }
                        
                    }
                    catch(IOException | SQLException e){
                        Alert a = new Alert(Alert.AlertType.NONE);
                        a.setAlertType(Alert.AlertType.ERROR);  
                        a.setContentText("ID is already not registered.");
                        a.show();
                    }
                }
                
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
