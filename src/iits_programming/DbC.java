/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package iits_programming;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author sajib
 */
public class DbC {

    String name;
    String password;
    int i = 0;

    //connect database
    void getData(String unamecheck) {
        
        try {
            Class.forName("com.mysql.jdbc.Driver");

//here db_mess is the database name, root is the username and "" is the password
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/iits_programming_club", "root", "")) {

                Statement stmt = con.createStatement();
                //retraive data from database Login_info table

                ResultSet rs = stmt.executeQuery("select * from admin_login where admin_username='"+unamecheck+"'");

                while (rs.next()) {

                    name = rs.getString("admin_username");
                    password = rs.getString("admin_password");
                    
                }

            }

        } catch (ClassNotFoundException | SQLException e) {
            Alert ob;
            ob = new Alert(AlertType.ERROR);
            ob.setTitle("Error");
            ob.setContentText("DataBase Not Connected");
            ob.setHeaderText("Chceck Connection");
            ob.showAndWait();
        }
    }

    String getname() {
        return name;
    }

    String getpass() {
        return password;
    }
}