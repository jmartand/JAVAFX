
package gamestore;

import gamestore.model.Product;
import gamestore.model.ProductQueries;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.collections.ObservableList;

import java.sql.*;

public class ProductsController {
   
    @FXML private  TableView<Product> ProductTable;
    @FXML private TextField productID;
    @FXML private TextField ProductTitle;
    @FXML private TextField ProductDesc;
    @FXML private TextField ProductRate;
    @FXML private TextField ProductQty;
     private ProductsController painController;
    /*
    @FXML private TableColumn<Product, Product> coverCol;
    @FXML private TableColumn<Product, String> titleCol;
    @FXML private TableColumn<Product, Double> priceCol;  
    @FXML private TableColumn<Product, Double> qtyCol;   
    @FXML private TableColumn<Product, Product> removeCol;
    @FXML private Label subtotalLabel;    
    //@FXML private Button checkoutButton;

    private MainController mainController;
    double total = 0 ;
    public Hyperlink updatedCartButton;
    public BorderPane mainBorderPaneForCheckoutUse;
    
    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.GERMANY);
       
    public void initialize() {
        cartTable.setPlaceholder(new Label("Your shopping cart is empty..."));
    }
    
    public void setCart(MainController mainController) {
        this.mainController = mainController;
        cartTable.setItems(mainController.getCartItems());
        
        for (Product product : cartTable.getItems()) {
            total = total + product.getPrice();
        }
        String currencyPrice = currencyFormatter.format(total);
        subtotalLabel.setText(currencyPrice);    
        
        coverCol.setCellValueFactory(img -> new ReadOnlyObjectWrapper<>(img.getValue()));
        coverCol.setCellFactory(img -> new TableCell<Product, Product>(){
            private final ImageView coverImageView = new ImageView();
            @Override 
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if(product == null) {
                    setGraphic(null);
                    return;
                }
                coverImageView.setImage(new Image(product.getCover()));
                coverImageView.setFitHeight(50);
                coverImageView.setFitWidth(100);
                setGraphic(coverImageView);
            }
        });
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        priceCol.setCellValueFactory(new PropertyValueFactory<>("price"));
        priceCol.setCellFactory(col -> new TableCell<Product, Double>(){
            @Override
            public void updateItem(Double price, boolean empty) {
                super.updateItem(price, empty);
                if(empty) {
                    setGraphic(null);
                } else {
                    String currencyPrice = currencyFormatter.format(price);
                    Label priceLabel = new Label(currencyPrice);
                    setGraphic(priceLabel);
                }
            }
        });
        removeCol.setCellValueFactory(param -> new ReadOnlyObjectWrapper<>(param.getValue()));
        removeCol.setCellFactory(param -> new TableCell<Product,Product>(){
            private final Hyperlink removeFromCart = new Hyperlink("");
            @Override
            protected void updateItem(Product product, boolean empty) {
                super.updateItem(product, empty);
                if(product == null) {
                    setGraphic(null);
                    return;
                }
                HBox removeHBox = new HBox();
                TextField quantity = new TextField("1");
                quantity.setPrefWidth(35.0);
                quantity.setAlignment(Pos.CENTER_RIGHT);
                quantity.setEditable(false);
                quantity.setStyle("-fx-background-radius: 0;");
                removeHBox.setAlignment(Pos.CENTER);
                removeHBox.getChildren().addAll(quantity, removeFromCart);
                setGraphic(removeHBox);
                Image deleteIcon = new Image(getClass().getResourceAsStream("/resources/images/icons/ic_delete_black_18dp_1x.png"));
                removeFromCart.setGraphic(new ImageView(deleteIcon));
                removeFromCart.setStyle("-fx-text-fill: black;");
                removeFromCart.setOnAction(e -> {
                    getTableView().getItems().remove(product);
                    total = total - product.getPrice();
                    String currencyPrice = currencyFormatter.format(total);
                    subtotalLabel.setText(currencyPrice);
                    updatedCartButton.setText("Cart (" + String.valueOf(mainController.getCartItems().size()) + ")");
                });
            }
        });        
    }
    
    public void continueShopping(ActionEvent event) throws Exception {
        mainController.gotoStore(event);
    }
    //AddNewProduct
     */
     public void AddNewProduct(ActionEvent event) throws Exception {
        //mainController.gotoStore(event);
        String ProductID=productID.getText();
         System.out.println(ProductID);
        String Title=ProductTitle.getText();
        String Price=ProductRate.getText();
        String Description=ProductDesc.getText();
        String Qty=ProductQty.getText();  
        try{  
                 Class.forName("com.mysql.jdbc.Driver");  
               Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wingamestore","root","");
               String query = " insert into products (ProductID, Title, Price, Description, Qty)"
                + " values (?, ?, ?, ?, ?)";

             // create the mysql insert preparedstatement
                PreparedStatement preparedStmt = con.prepareStatement(query);
                preparedStmt.setString (1, ProductID);
                preparedStmt.setString (2, Title);
                preparedStmt.setString(3, Price);
                preparedStmt.setString(4, Description);
                preparedStmt.setString(5, Qty);
      
                // execute the preparedstatement
                preparedStmt.execute();
      
                con.close();
    }
    catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
    }  
        
     
     public void DeleteSelectedProduct(ActionEvent event) throws Exception {
        //mainController.gotoStore(event);
        String ProductID=productID.getText();
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wingamestore","root","");
        String sql = "DELETE FROM products WHERE ProductID=?";
        PreparedStatement statement = con.prepareStatement(sql);
        statement.setString(1, ProductID);
 
        int rowsDeleted = statement.executeUpdate();
        if (rowsDeleted > 0)
        {
            System.out.println("A user was deleted successfully!");
        }
     }
     /*
    public void proceedToCheckout(ActionEvent event) throws IOException {
        if(!mainController.getCartItems().isEmpty()) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Checkout.fxml"));
            GridPane checkout = loader.load();
            CheckoutController checkoutController = loader.getController();
            //checkoutController.setCheckoutPage(this);
            checkoutController.checkoutCartButton = updatedCartButton;
            mainBorderPaneForCheckoutUse.setCenter(checkout);
        }
    } 
    
 
    
    public Customer getLoggedCustomer() {
        return mainController.getLoggedCustomer();
    }*/
       public List<Product> getAllProduct() {
           
           ProductQueries  pq= new ProductQueries();
                
          return pq.getAllProducts();
    }
       
       /*
        public void setCart(ProductsController productController) {
        this.productController = productController;
       ProductTable.setItems(productController.getAllProduct());
        }*/
}
