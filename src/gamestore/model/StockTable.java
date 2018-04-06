/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gamestore.model;
//gamestore.model.StockTable
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Admin
 */
public class StockTable {
   private final SimpleStringProperty vProductID = new SimpleStringProperty("");
   private final SimpleStringProperty vProductRate = new SimpleStringProperty("");
   private final SimpleStringProperty vProductDesc = new SimpleStringProperty("");
   private final SimpleStringProperty vProductQty = new SimpleStringProperty("");


public StockTable() {
        this("", "", "","");
    }
 
    public StockTable(String ProductID, String ProductRate, String ProductDesc, String ProductQty) {
        setProductID(ProductID);
        setProductRate(ProductRate);
        setProductDesc(ProductDesc);
          setProductQty(ProductQty);
       
    }

    public String getProductID() {
        return vProductID.get();
    }
 
    public void setProductID(String ProductID) {
        vProductID.set(ProductID);
    }
        
    public String geProductRate() {
        return vProductRate.get();
    }
    
    public void setProductRate(String ProductRate) {
        vProductRate.set(ProductRate);
    }
    
    public String getProductDesc() {
        return vProductDesc.get();
    }
     public void setProductDesc(String ProductDesc) {
        vProductDesc.set(ProductDesc);
    }
     
      public String getProductQty() {
        return vProductQty.get();
    }
     public void setProductQty(String ProductQty) {
        vProductQty.set(ProductQty);
    }
}
