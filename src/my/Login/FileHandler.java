
package my.Login;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
     public static List<Vendor> readVendorsFromFile(String filePath) throws IOException {
        List<Vendor> vendors = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                 if (data.length == 3) { // Ensure that there are three elements in the data array
                    Vendor vendor = new Vendor(data[0], data[1], data[2]);
                    vendors.add(vendor);
                } else {
                    System.err.println("Invalid data format: " + line);
                }
                 
               
            }
        }

        return vendors;
    }
}
