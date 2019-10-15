/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterlogin;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.collections.*;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javafx.application.Application.launch;

/**
 *
 * @author user
 */
public class displayScene extends Application implements Hello{
   
static final String DRIVER = "com.mysql.jdbc.Driver";
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bankdatabase";
static final String USER = "root";
static final String PASSWORD = "";

////////////////////////////
private String[] propertyName = {"Id", "Amount"};

   //List of Labels
   private String[] propertyLabel = {"Id", "Amount"};

   private Connecting connect = new Connecting();
   private final GridPane gridPane1 = new GridPane();
   private ObservableList<Banking> observableNames;
   /* private FilteredList<Booking> filteredData;
   private SortedList<Booking> sortedData;
   private final ListView<Booking> listView; */
   TableView<Banking> bankingTableView = new TableView<>();

   public displayScene() {
      observableNames = FXCollections.observableArrayList(connect.getItems());
      /* filteredData = new FilteredList<>(observableNames, booking -> true);
      sortedData = new SortedList<>(filteredData);
      listView = new ListView<>(sortedData); */
   }
//////////////////////////////////////
    @Override
	
  public void start(Stage stage) {
  GridPane gridPane = new GridPane();


  gridPane1.setMinSize(600,400);
  gridPane1.setPadding(new Insets(10,10,10,10));
  gridPane1.setVgap(10);
  gridPane1.setHgap(10);
  gridPane1.setAlignment(Pos.CENTER);

  gridPane.setMinSize(600,400);
  gridPane.setPadding(new Insets(10,10,10,10));
  gridPane.setVgap(10);
  gridPane.setHgap(10);
  gridPane.setAlignment(Pos.CENTER);

  Button backBtn = new Button("back");
  Button viewBtn = new Button("view");

  gridPane.add(backBtn,0,7); 
  gridPane.add(viewBtn,2,7); 
  gridPane1.add(bankingTableView,0,0);
  /////////////////////
  gridPane.setVgap(5);
   
  
  
      ObservableList<Banking> itemList = FXCollections.observableArrayList(connect.getItems());
      bankingTableView.setItems(itemList);
      bankingTableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
      for (int i = 0; i <
            propertyLabel.length; i++) {
         TableColumn<Banking, Object> col = new TableColumn<>(propertyLabel[i]);
         col.setCellValueFactory(new PropertyValueFactory<>(propertyName[i]));
         bankingTableView.getColumns().add(col);
      }
      
      
      
      
   
      viewBtn.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +"-fx-background-insets: 0;\n" +"-fx-text-fill: white;"+"-fx-font-size:18pt;");
     backBtn.setStyle("-fx-background-color: linear-gradient(#ff5400, #be1d00);\n" +"-fx-background-insets: 0;\n" +"-fx-text-fill: white;"+"-fx-font-size:18pt;");
gridPane.setStyle("-fx-background-image:url('https://previews.123rf.com/images/kurashov/kurashov1006/kurashov100600038/7117190-sheet-of-stained-lined-paper.jpg'); ");  
gridPane1.setStyle("-fx-background-image:url('https://previews.123rf.com/images/kurashov/kurashov1006/kurashov100600038/7117190-sheet-of-stained-lined-paper.jpg'); ");  

       
   
   Scene scene1 = new Scene(gridPane1);

   
   
               viewBtn.setOnAction(new EventHandler<ActionEvent>() {
                   //moving to the next scene

            public void handle(ActionEvent event) {
                      stage.setScene(scene1);

            }
        });
               
                    

 Connection connection = null;
 //PreparedStatement statement = null;
 ResultSet resultSet = null;
 
   //Creating a scene object
        Scene scene = new Scene(gridPane);
        
        //Setting title to the stage
        stage.setTitle("Banking System");
        
        //Adding scene to the stage
        stage.setScene(scene);
        
        //Displaying the contents of the stage
        stage.show();
        
        backBtn.setOnAction((ActionEvent event) -> {
            AfterLogin bk = new AfterLogin();
             
      try {
          bk.start(stage);
      } catch (ClassNotFoundException ex) {
          Logger.getLogger(displayScene.class.getName()).log(Level.SEVERE, null, ex);
      }
         });     
   
  }
    /**
     * @param args the command line arguments
     */
      public void animation(){		
        launch();
		
    }
   
}
