/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package afterlogin;

public class Banking{

   private String Id;
    private String Amount;
	

    public Banking() {
      this.Id = "";
	  this.Amount = "";
	  
	  
	  
//this.Price = 0;
     // this.Quantity = 0;
    }

    public Banking(String Id, String Amount ) {
      this.Id = Id;
      this.Amount  = Amount;
	  
	  
    }


    public String getId() {

        return Id;
    }
    public void setId(String Id) {

        this.Id = Id;
    }
    public String getAmount() {

        return Amount;
    }
    public void setAmount(String Amount) {

        this.Amount = Amount;
    }
	 
}


