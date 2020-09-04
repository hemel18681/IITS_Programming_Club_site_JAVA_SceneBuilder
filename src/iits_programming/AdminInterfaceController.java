/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iits_programming;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class AdminInterfaceController implements Initializable {

    @FXML
    private Button addmember;
    @FXML
    private Button viewmember;
    @FXML
    private Button deletemember;
    @FXML
    private Button addadmin;
    @FXML
    private Button viewadmin;
    @FXML
    private Button deleteadmin;
    @FXML
    private AnchorPane adminInterface,adminPane;
    /**
     * Initializes the controller class.
     */
    public void log() throws IOException{
        AnchorPane pane = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        adminPane.getChildren().setAll(pane);
    }
    
    @FXML
    private void handelAdminAddmember(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminAddMember.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    @FXML
    private void handelAdminViewmember(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminViewMember.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    @FXML
    private void handelAdmindeletemember(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminDeleteMember.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    @FXML
    private void handelAdminAddadmin(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminAddAdmin.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    @FXML
    private void handelAdminViewadmin(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminViewAdmin.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    @FXML
    private void handelAdmindeleteadmin(ActionEvent event) throws IOException{
        AnchorPane obs=FXMLLoader.load(getClass().getResource("AdminDeleteAdmin.fxml"));
        adminPane.getChildren().setAll(obs);
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
