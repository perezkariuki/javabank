/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterlogin;
 import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.*;

public class Connecting {
static final String DRIVER = "com.mysql.jdbc.Driver";
static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bankdatabase";
static final String USER = "root";
static final String PASSWORD = "";

   private Banking accessItems(ResultSet rs) {
      Banking banking = new Banking();
      try {
         banking.setId(rs.getString("Id"));
		 banking.setAmount(rs.getString("Amount"));
		 
		 
		 
		 
		 
         
      } catch (SQLException ex) {
        System.out.println("A SQLException occurred " + ex);
      }
      return banking;
   }
   public List<Banking> getItems() {
      String sql = "SELECT * FROM bank ORDER BY Id";
      List<Banking> list = new ArrayList<>();
      try {
         Class.forName(DRIVER);
         Connection con = DriverManager.getConnection(DATABASE_URL, USER, PASSWORD);
         Statement stmt = con.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         while (rs.next()) {
            Banking banking = accessItems(rs);
            list.add(banking);
         }
         rs.close();
         con.close();
      } catch (ClassNotFoundException | SQLException ex) {
        Logger.getLogger(Banking.class.getName()).log(Level.SEVERE,null, ex);
      }
      return list;
   }


}
 

