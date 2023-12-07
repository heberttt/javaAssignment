package my.Classes;
 
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import my.Classes.*;
import static my.Classes.FileLocationInterface.userFilePath;

public class runOrder implements FileLocationInterface{
    private int OrderID;
    private String date;
    private String time;
    private String CustomerID;
    private String VendorID;
    private String OrderStatus;
    private String Menu;
    private String Location;
    private Customer customer;
    private Vendor vendor;
    private ArrayList<FoodMenu> MenusInCart;
    
    public runOrder(int OrderID, String date, String time, String CustomerID, String VendorID, String OrderStatus, String Menu, String Location)
    {
        this.OrderID = OrderID;
        this.date = date;
        this.time = time;
        this.CustomerID = CustomerID;
        this.VendorID = VendorID;
        this.OrderStatus = OrderStatus;
        this.Menu = Menu;
        this.Location = Location;
        
    }
    
    public runOrder(Customer customer, Vendor vendor, ArrayList<FoodMenu> MenusInCart, String Location)
    {
        this.vendor = vendor;
        this.customer = customer;
        this.Location = Location;
        this.MenusInCart = MenusInCart;
        
    }

    public int getOrderID() {
        return OrderID;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getVendorID() {
        return VendorID;
    }

    public String getOrderStatus() {
        return OrderStatus;
    }

    public String getMenu() {
        return Menu;
    }

    public String getLocation() {
        return Location;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setVendorID(String VendorID) {
        this.VendorID = VendorID;
    }

    public void setOrderStatus(String OrderStatus) {
        this.OrderStatus = OrderStatus;
    }

    public void setMenu(String Menu) {
        this.Menu = Menu;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }
    
     
    public int placeOrder(){
        String Menus = "";
        int totalPrice = 0;
        for (int i = 0 ; i < MenusInCart.size() ; i++){
            FoodMenu menu = MenusInCart.get(i);
            if (i == MenusInCart.size() - 1){
                Menus += menu.getId() + "!" + menu.getQuantity();
            }
            else{
                Menus += menu.getId() + "!" + menu.getQuantity() + ";";
            }
            totalPrice += Integer.parseInt(menu.getPrice()) * menu.getQuantity();
        }
        currentDate d = new currentDate();
        String date = d.getDate() + "/" + d.getMonth() + "/" + d.getYear();
        String finalOrder = String.valueOf(availableId()) + "," + date +  "," + d.getCurrentTime() + "," + customer.getId() + "," + vendor.getId() + ","+ "ongoing" + "," + Menus + "," + totalPrice + "," + Location;//continue
        
        try {
            // Create a BufferedWriter in append mode to write to the file
            BufferedWriter writer = new BufferedWriter(new FileWriter(ordersFilePath, true));

            writer.write(finalOrder + "\n");

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalPrice;
    }
    
    protected int availableId(){
       int biggestNum = 0;
       try {
        File myObj = new File(ordersFilePath);
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            if(data.equals("")){
                continue;
            }
            String[] dataArr = data.split(",");
            data = dataArr[0];
            
            if(biggestNum <= Integer.parseInt(data)){
                biggestNum = Integer.parseInt(data);
            }
        } 
        myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        } 
       int availableId = biggestNum + 1;
       return availableId;
    }
    
    
    
}
