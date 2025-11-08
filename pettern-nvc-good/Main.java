// Tanpa Pettern ////

// import java.util.ArrayList;
// import java.util.Scanner;
// import model.Product;

// public class Main {
    
//     private final ArrayList<Product> productList = new ArrayList<>();
//     private final Scanner scanner = new Scanner(System.in);
    
//     public Main() {
//         // Data awal
//         productList.add(new Product(1, "Laptop ASUS", 9500000));
//         productList.add(new Product(2, "Monitor Dell", 2500000));
//     }
    
//     public void startMenuLoop() {
//         boolean running = true;
//         while (running) {
//             System.out.println("\n--- APLIKASI TANPA PATTERN ---");
//             System.out.println("1. Tampilkan Semua Produk");
//             System.out.println("2. Tambah Produk Baru");
//             System.out.println("3. Keluar");
//             System.out.print("Pilih opsi: ");
//             try {
//                 int choice = Integer.parseInt(scanner.nextLine());
//                 switch (choice) {
//                     case 1:
//                         displayAllProducts();
//                         break;
//                     case 2:
//                         addNewProduct();
//                         break;
//                     case 3:
//                         running = false;
//                         System.out.println("Terima kasih telah menggunakan aplikasi!");
//                         break;
//                     default:
//                         System.out.println("Opsi tidak valid.");
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Input tidak valid. Masukkan angka.");
//             }
//         }
//         scanner.close();
//     }
    
//     private void displayAllProducts() {
//         System.out.println("\n--- Daftar Produk ---");
//         if (productList.isEmpty()) {
//             System.out.println("Tidak ada produk tersedia.");
//         } else {
//             for (Product product : productList) {
//                 System.out.println(product.getId() + " - " + product.getName() + " Rp. " + product.getPrice());
//             }
//         }
//     }
    
//     private void addNewProduct() {
//         System.out.print("Masukkan Nama Produk: ");
//         String name = scanner.nextLine();
        
//         if (name.trim().isEmpty()) {
//             System.out.println("Error: Nama produk tidak boleh kosong.");
//             return;
//         }
        
//         System.out.print("Masukkan Harga Produk: ");
//         String priceString = scanner.nextLine();
//         try {
//             long price = Long.parseLong(priceString);
//             if (price <= 0) {
//                 throw new IllegalArgumentException("Harga harus angka positif di atas nol!");
//             }
//             int newId = productList.size() + 1;
//             productList.add(new Product(newId, name, price));
//             System.out.println("Produk berhasil ditambahkan!");
//         } catch (NumberFormatException e) {
//             System.out.println("Error: Harga tidak valid. Masukkan angka.");
//         } catch (IllegalArgumentException e) {
//             System.out.println("Error: " + e.getMessage());
//         }
//     }

//     public static void main(String[] args) {
//         Main app = new Main();
//         app.startMenuLoop();

//     }
// }


// MVC Pattern /////////
// import java.util.Scanner;

// import controller.*;
// import view.*;

// public class Main {
//     public static void main(String[] args) {
        
//         Scanner scanner = new Scanner(System.in);
//         ProductConsoleView view = new ProductConsoleView(scanner);
//         ProductController controller = new ProductController(view);

//         while (true){
//             System.out.println("\n ==== Menu MVC ====");
//             System.out.println("1. Tampilkan Produk");
//             System.out.println("2. Tambah Produk");
//             System.out.println("3. Keluar");
//             System.out.print("Pilih: ");

//             try {
//                 int choice = Integer.parseInt(scanner.nextLine());
//                 if (choice == 3 ) break;
//                 controller.handleMenuChoice(choice);
//             } catch (Exception e) {
//                 view.displayError("input tidak valid. masukan angka. ");
//             }
//         }   
//         scanner.close();
//     }
// }


// Service layer Pattern /////

// import java.util.List;
// import java.util.Scanner;

// import model.Product;
// import service.ProductServiceDefault;

// public class Main {

//     private final ProductServiceDefault productService = new ProductServiceDefault();
//     private final Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         Main app = new Main();
//         app.startMenuLoop();
//         app.scanner.close();
//     }

//     public void startMenuLoop() {
//         boolean running = true;
//         while (running) {
//             System.out.println("\n--- APLIKASI SERVICE LAYER PATTERN ---");
//             System.out.println("1. Tampilkan Semua Produk");
//             System.out.println("2. Tambah Produk Baru");
//             System.out.println("3. Keluar");
//             System.out.print("Pilih opsi: ");

//             try {
//                 int choice = Integer.parseInt(scanner.nextLine());
//                 switch (choice) {
//                     case 1:
//                         displayAllProducts();
//                         break;
//                     case 2:
//                         addNewProduct();
//                         break;
//                     case 3:
//                         running = false;
//                         System.out.println("Terima kasih telah menggunakan aplikasi!");
//                         break;
//                     default:
//                         System.out.println("Opsi tidak valid.");
//                 }
//             } catch (NumberFormatException e) {
//                 System.out.println("Input tidak valid. Masukkan angka.");
//             }
//         }
//     }

//     private void displayAllProducts() {
//         System.out.println("\n--- Daftar Produk ---");
//         List<Product> products = productService.getAllProducts();
//         for (Product product : products) {
//             System.out.println(product.getId() + " - " + product.getName()
//                     + " - Rp. " + product.getPrice());
//         }
//     }

//     private void addNewProduct() {
//         System.out.print("Masukkan Nama Produk: ");
//         String name = scanner.nextLine();
//         System.out.print("Masukkan Harga Produk: ");
//         String priceString = scanner.nextLine();

//         try {
//             long price = Long.parseLong(priceString);
//             productService.addProduct(name, price);
//             System.out.println("Produk berhasil ditambahkan!");
//         } catch (NumberFormatException e) {
//             System.out.println("Error: Harga tidak valid.");
//         } catch (IllegalArgumentException e) {
//             System.out.println("Error: " + e.getMessage());
//         }
//     }
// }

// Dao Pattern /////////

// import java.util.ArrayList;
// import java.util.Scanner;

// import dao.ProductDao;
// import dao.memory.ProductDaoInMemory;
// import model.Product;

// public class Main {
//     private final ProductDao productDao = new ProductDaoInMemory();
//     private final Scanner scanner = new Scanner(System.in);

//     public static void main(String[] args) {
//         Main app = new Main();
//         app.startMenuLoop();
//         app.scanner.close();
//     }

//     public void startMenuLoop() {
//         boolean running = true;
//         while (running) {
//             System.out.println("\n--- APLIKASI DAO PATTERN ---");
//             System.out.println("1. Tampilkan Semua Produk");
//             System.out.println("2. Tambah Produk Baru");
//             System.out.println("3. Keluar");
//             System.out.print("Pilih opsi: ");
//             try {
//                 int choice = Integer.parseInt(scanner.nextLine());
//                 switch (choice) {
//                     case 1:
//                         displayProducts();
//                         break;
//                     case 2:
//                         addNewProduct();
//                         break;
//                     case 3:
//                         running = false;
//                         break;
//                     default:
//                         System.out.println("Opsi tidak valid.");
//                 }
//             } catch (Exception e) {
//                 System.out.println("Input error: " + e.getMessage());
//             }
//         }
//     }

//     private void displayProducts() {
//         System.out.println("\n--- Daftar Produk ---");
//         ArrayList<Product> products = productDao.findAll();
//         for (Product product : products) {
//             System.out.println(product);
//         }
//     }

//     private void addNewProduct() {
//         System.out.print("Nama Produk: ");
//         String name = scanner.nextLine();
//         System.out.print("Harga Produk: ");
//         long price = Long.parseLong(scanner.nextLine());
//         if (price <= 0) {
//             System.out.println("Error: Harga harus angka positif lebih dari 0.");
//             return;
//         }
//         int newId = productDao.findAll().size() + 1;
//         Product newProduct = new Product(newId, name, price);
//         productDao.save(newProduct);
//         System.out.println("Produk berhasil ditambahkan!");
//     }
// }

// MVC + Service Layer + DAO Pattern


import java.util.Scanner;

import controller.ProductController;
import dao.ProductDao;
import dao.memory.ProductDaoInMemory;
import service.ProductService;
import service.ProductServiceDefault;
import view.ProductConsoleView;

public class Main {
    public static void main(String[] args) {
        ProductDao productDao = new ProductDaoInMemory();
        ProductService productService = new ProductServiceDefault(productDao);
        
        Scanner scanner = new Scanner(System.in);
        ProductConsoleView productView = new ProductConsoleView(scanner);
        
        ProductController productController = new ProductController(productService, productView);
        
        while (true) {
            productView.displayMenu();
            int menuChoice = productView.getMenuChoiceFromUser();
            productController.handleMenuChoice(String.valueOf(menuChoice));
        }
    }
}