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
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class FXMLDocumentController implements Initializable {
    

    @FXML
    private AnchorPane adminLoginPane, studentinfo,iitsprogrammingclub,layout;

    @FXML
    private TextField aName;

    @FXML
    private PasswordField aPassword;

    @FXML
    private Button aLogin;

    @FXML
    private Button userLogin;

    @FXML
    private AnchorPane userLoginPane;

    @FXML
    public TextField uName;
    
    @FXML
    private TextField username;

    @FXML
    private TextField userid;

    @FXML
    private TextField userpass;

    @FXML
    private TextField codeforces;

    @FXML
    private TextField codechef;

    @FXML
    private TextField vjudge;

    @FXML
    private TextField hackerrank;

    @FXML
    private TextField atcoder;
    
    @FXML
    private PasswordField uPassword;

    @FXML
    private Button uLogin;

    @FXML
    private Button adminLogin;
    
    
    @FXML
    private void handelAdminLogin(ActionEvent event) {
        adminLoginPane.setVisible(true);
        userLoginPane.setVisible(false);
    }
@FXML
private void handelUserLogin(ActionEvent event){
            adminLoginPane.setVisible(false);
            userLoginPane.setVisible(true);
}

@FXML
private void handelAdminLoginfinal(ActionEvent event) throws IOException{
            DbC ob=new DbC();
            ob.getData(aName.getText());
            String finalUname=ob.getname();
            String finalPassword=ob.getpass();
            if(aName.getText().equals(finalUname) && aPassword.getText().equals(finalPassword)){
                //System.out.println("Login Successful");
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
//                iitsprogrammingclub.getChildren().setAll(pane);
//                AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
//                iitsprogrammingclub.getChildren().setAll(pane);
                  showadmininterface();
            }
            else{
                  // JOptionPane.showMessageDialog(rootPane,"Wrong Username or Passwoed.\n Please enter the correct one.\n If you forgot or not registered then contact with the Manager");
                  Alert a = new Alert(AlertType.NONE);
                  a.setAlertType(AlertType.WARNING);  
                  a.setContentText("Wrong Username or Passwoed.\n Please enter the correct one.\n If you forgot or not registered then contact with the Manager");
                  a.show(); 
            }
}
@FXML
private void handelUserLoginfinal(ActionEvent event) throws ClassNotFoundException, SQLException, IOException{
            stucon ob=new stucon();
            ob.getData(uName.getText());
            String finalUname=ob.getname();
            String finalPassword=ob.getpass();
            if(uName.getText().equals(finalUname) && uPassword.getText().equals(finalPassword)){
//                System.out.println("Login Successful"); 
                    //showuser();
                    studentinfo.setVisible(true);
                    adminLoginPane.setVisible(false);
                    userLoginPane.setVisible(false);
                    //userid.setText("jahsdash");  
                
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "");
                Statement stmt = con.createStatement();
                //System.out.println("coRnnected");
                //retraive data from database Login_info table

                ResultSet rs = stmt.executeQuery("select * from student_login where student_id='"+uName.getText()+"'");
                 while(rs.next()) {
                     userid.setText(rs.getString("student_id"));
                     username.setText(rs.getString("student_name"));
                     userpass.setText(rs.getString("student_password"));
                     codeforces.setText(rs.getString("codeforces_handle"));
                     codechef.setText(rs.getString("codechef_handle"));
                     vjudge.setText(rs.getString("vjudge_handle"));
                     hackerrank.setText(rs.getString("hackerrank_handle"));
                     atcoder.setText(rs.getString("atcoder_handle"));
                }
                 
//                 else{
//                     System.out.println("not found");
//                 }
            }
            else{
            
                  Alert a = new Alert(AlertType.NONE);
                  a.setAlertType(AlertType.WARNING);  
                  a.setContentText("Wrong Username or Passwoed.\n Please enter the correct one.\n If you forgot or not registered then contact with the Manager");
                  a.show(); 
            }
}




    
        @FXML
    private void UpdateInfo(ActionEvent event) throws SQLException, ClassNotFoundException {
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "");
            //System.out.println("conntected");
            String id=userid.getText();
            String name=username.getText();
            String pass=userpass.getText();
            String cf=codeforces.getText();
            String cc=codechef.getText();
            String vj=vjudge.getText();
            String hr=hackerrank.getText();
            String ac=atcoder.getText();
            //System.out.println("done");
            String sql="Update student_login set student_login.student_name='"+name+"',student_login.student_password='"+pass+"',student_login.codeforces_handle='"+cf+"',student_login.codechef_handle='"+cc+"',student_login.vjudge_handle='"+vj+"',student_login.hackerrank_handle='"+hr+"',student_login.atcoder_handle='"+ac+"'  Where student_login.student_id='"+id+"'";
            PreparedStatement create=con.prepareStatement(sql);
            Alert alert = new Alert(AlertType.WARNING, "your data is going to be update",ButtonType.OK, ButtonType.CANCEL);
            alert.setTitle("Date format warning");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                create.executeUpdate();
                uName.clear();
                uPassword.clear();
                studentinfo.setVisible(false);
                userLoginPane.setVisible(true);
            }
    }
    
    
    public void mainwork() throws IOException{
        layout.setVisible(false);
        adminLoginPane.setVisible(true);
    }
    
    public void log() throws IOException{
        uName.clear();
        uPassword.clear();
        studentinfo.setVisible(false);
        userLoginPane.setVisible(true);
    }

    void showadmininterface() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("AdminInterface.fxml"));
        iitsprogrammingclub.getChildren().setAll(pane);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}















































