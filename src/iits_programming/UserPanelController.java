/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iits_programming;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Asus
 */
public class UserPanelController  implements Initializable {

    @FXML
    private AnchorPane studentinfo;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
