import java.util.ArrayList;
import java.util.Scanner;

class Item {
    int id;
    String name;
    int quantity;
    double price;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name +
                ", Quantity: " + quantity + ", Price: " + price);
    }
}

public class Main {
    static ArrayList<Item> inventory = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Warehouse Inventory System ---");
            System.out.println("1. Add Item");
            System.out.println("2. View Items");
            System.out.println("3. Update Item");
            System.out.println("4. Delete Item");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    viewItems();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

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

        inventory.add(new Item(id, name, quantity, price));
        System.out.println("Item added successfully!");
    }

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

    static void updateItem() {
        System.out.print("Enter ID to update: ");
        int id = scanner.nextInt();

        for (Item item : inventory) {
            if (item.id == id) {
                scanner.nextLine(); 

                System.out.print("Enter new name: ");
                item.name = scanner.nextLine();

                System.out.print("Enter new quantity: ");
                item.quantity = scanner.nextInt();

                System.out.print("Enter new price: ");
                item.price = scanner.nextDouble();

                System.out.println("Item updated successfully!");
                return;
            }
        }

        System.out.println("Item not found!");
    }

    static void deleteItem() {
        System.out.print("Enter ID to delete: ");
        int id = scanner.nextInt();

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