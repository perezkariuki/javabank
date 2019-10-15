/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterlogin;

import java.sql.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.awt.event.MouseEvent;
import java.lang.System.Logger;
import java.rmi.RemoteException;

import java.sql.Connection;

import java.sql.DriverManager;
import java.util.logging.Level;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author keith
 */
public class AfterLogin extends Application implements Hello {
  Connection conn;
  Statement statement;
  PreparedStatement pst = null;
    
    @Override
    public void start(Stage stage) throws ClassNotFoundException {
        //connect 
        DbConnect();
        
       //Create Label for Current Balance
        Text text = new Text ("Enter user ID");
        Text text1 = new Text ("Enter amount to deposit:");
        Text text2 = new Text ("View Bank Balance:");   
        
        //create textfield for Amount to Deposit
        TextField textField = new TextField();
        TextField textField1 = new TextField();
      
        //create buttons 
      
        Button button3 = new Button("Click to view balance");
       
        //creating a grid pane and import relevant classes
        GridPane gridPane = new GridPane();
        
        //set up size for the pane
        gridPane.setMinSize(600, 400);
        
        // set padding
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        
        //set the vertical and horizantal gaps between the columns
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        
        //set the grid alignment
        gridPane.setAlignment(Pos.CENTER);
        
        // arrange all the nodes in the grid
        gridPane.add(text, 0, 0);
        gridPane.add(text1, 0, 2);
        gridPane.add(text2, 0, 6);
        gridPane.add(textField, 0, 1);
        gridPane.add(textField1, 0, 3);
        
       
        gridPane.add(button3, 0, 7);
       
        
        button3.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +"-fx-background-insets: 0;\n" +"-fx-text-fill: white;"+"-fx-font-size:18pt;");
        
        text.setStyle("-fx-font: normal bold 30px 'serif'");      
        text1.setStyle("-fx-font: normal bold 30px 'serif'");
        text2.setStyle("-fx-font: normal bold 30px 'serif'");
        gridPane.setStyle("-fx-background-image:url('https://previews.123rf.com/images/kurashov/kurashov1006/kurashov100600038/7117190-sheet-of-stained-lined-paper.jpg'); ");
        
        
        //Creating a scene object
        Scene scene = new Scene(gridPane);
        
        //Setting title to the stage
        stage.setTitle("Banking System");
        
        //Adding scene to the stage
        stage.setScene(scene);
        
        //Displaying the contents of the stage
        stage.show();
        
        
         button3.setOnAction((ActionEvent event) -> {
            displayScene ds = new displayScene();
             
            ds.start(stage);
         });
        
         Button button1 = new Button("Click to Deposit");
         button1.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +"-fx-background-insets: 0;\n" +"-fx-text-fill: white;"+"-fx-font-size:13pt;");
         gridPane.add(button1, 0, 5);
         button1.setOnAction(ActionEvent  -> {
           try{
            Connection conn = (Connection) DriverManager.getConnection ( "jdbc:mysql://localhost/bankdatabase","root","" );	
           
            String Amount = textField1.getText();
            
            String Id = textField.getText();
          
            
            String insertquery = "INSERT INTO `Bank`(`Id`,`Amount`) VALUES (?,?)";
          
     
            pst = conn.prepareStatement(insertquery);
            
            pst.setString(1,Id);
            
            pst.setString(2,Amount);
      
            pst.executeUpdate();
            
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information Dialog");
            alert.setHeaderText(null);
            alert.setContentText("Deposit was Successful!");
            alert.showAndWait();
            
            System.out.println("Deposit inserted");
            
           
        }
        catch(Exception e){
            System.out.println(e.getMessage());   
        } 
         });
  }
 
   
    public static void main(String[] args) {
        launch();
    }
    
    public Connection DbConnect() {
    //connect to MySql
     try{
    String driver = "com.mysql.jdbc.Driver";    
    String DATABASE_URL = "jdbc:mysql://localhost/bankdatabase";
    String USER = "root";
    String PASSWORD = "";
    Class.forName(driver);
  
	Connection conn = (Connection) DriverManager.getConnection ( DATABASE_URL, USER,PASSWORD );	
         java.sql.Statement Statement = conn.createStatement();
        System.out.println("Bank database Connected!");
     
        
    	
    return conn;			
     } 
 catch(Exception el){
     System.out.println("DB Failed!");
   
 }
    return null;
       
}

    @Override
    public void animation() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
}
