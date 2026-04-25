import java.util.ArrayList; // use Array list
import java.util.Scanner;  // get user input

// represent the warehouse iteam
class Item {
    int id;
    String name;
    int quantity;
    double price;
    
// Constructor - initializes item details when object is created
    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
// Method to display item details
    void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Quantity: " + quantity + ", Price: " + price);
    }
}

// Main class
public class Main {
     // ArrayList to store all inventory items
    static ArrayList<Item> inventory = new ArrayList<>();
    
      // Scanner object to read user input
    static Scanner scanner = new Scanner(System.in);
    

    public static void main(String[] args) {
        int choice;
// Loop runs until user chooses to exit
        do {
            System.out.println("\n--- Warehouse Inventory System ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();// Read user choice
            
  // Perform action based on user choice
            switch (choice) {
                case 1:
                    addItem(); // Add new item
                    break;
                case 2:
                    viewItems();// Display all items
                    break;
                case 3:
                    updateItem();// Update existing item
                    break;
                case 4:
                    deleteItem(); // Delete item
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
    
   // Method to add a new item to the inventory
    static void addItem() {
        System.out.print("Enter ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        
  // Add new item to the list
        inventory.add(new Item(id, name, quantity, price));
        System.out.println("Item added successfully!");
    }
    
// Method to display all items
    static void viewItems() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory.");
            return;
        }
        
          
        System.out.println("\n--- Inventory List ---");
        for (Item item : inventory) {
            item.display();
        }
    }
    
// Loop through each item and display it
    static void updateItem() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();
        
 // Search for item by ID
        for (Item item : inventory) {
            if (item.id == id) {
                scanner.nextLine(); 

                System.out.print("Enter new name: ");
                item.name = scanner.nextLine();

                System.out.print("Enter new quantity: ");
                item.quantity = scanner.nextInt();

                System.out.print("Enter new price: ");
                item.price = scanner.nextDouble();
                
// If item not found
                System.out.println("Item updated successfully!");
                return;
            }
        }

        System.out.println("Item not found!");
    }
    
// Method to delete an item
    static void deleteItem() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();
        
 // Search for item and remove it
        
        for (Item item : inventory) {
            if (item.id == id) {
                inventory.remove(item);
                System.out.println("Item deleted successfully!");
                return;
            }
        }

        System.out.println("Item not found!");
    }
}
