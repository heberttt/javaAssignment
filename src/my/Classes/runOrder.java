package my.Classes;

public class runOrder {
    private int OrderID;
    private String date;
    private String time;
    private String CustomerID;
    private String VendorID;
    private String OrderStatus;
    private String Menu;
    private String Location;
    
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
    
    
    
    
}
