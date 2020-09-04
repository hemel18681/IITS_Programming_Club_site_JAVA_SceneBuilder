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
public class AdminViewMemberController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @FXML
    private AnchorPane AdminVIewMember,AdminInterface;

    @FXML
    private TextField userid;

    @FXML
    private TextField username;

    @FXML
    private TextField codeforces;

    @FXML
    private TextField codechef;

    @FXML
    private TextField hackerrank;

    @FXML
    private TextField vjudge;

    @FXML
    private TextField atcoder;
    
    
    public void go() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        AdminVIewMember.getChildren().setAll(pane);
    }
     
     public void log() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        AdminVIewMember.getChildren().setAll(pane);
    }
    public void reset(){
        userid.clear();
        username.clear();
        codeforces.clear();
        codechef.clear();
        hackerrank.clear();
        vjudge.clear();
        atcoder.clear();
    }
    
     public void adminviewmember() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "");
        Statement stmt = con.createStatement();
        String name=userid.getText();
        if("".equals(name)){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.WARNING);  
            a.setContentText("ID is required");
            a.show();
        }
        else{
            try{
                ResultSet rs = stmt.executeQuery("select * from student_login where student_id='"+name+"'");
                if(rs.next()){
                      rs = stmt.executeQuery("select * from student_login where student_id='"+name+"'");
                    while(rs.next()) {
                        System.out.println(rs.getString("student_name"));
                        username.setText(rs.getString("student_name"));
                        codeforces.setText(rs.getString("codeforces_handle"));
                        codechef.setText(rs.getString("codechef_handle"));
                        hackerrank.setText(rs.getString("hackerrank_handle"));
                        vjudge.setText(rs.getString("vjudge_handle"));
                        atcoder.setText(rs.getString("atcoder_handle"));
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
