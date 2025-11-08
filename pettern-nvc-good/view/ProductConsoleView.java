// package view;

// import java.util.ArrayList;
// import java.util.Scanner;
// import model.Product;

// public class ProductConsoleView {
//     private final Scanner scanner;
//     public ProductConsoleView(Scanner scanner) {
//         this.scanner = scanner;
//     }

//     public void displayAllProducts(ArrayList<Product> products) {
//         System.out.println("\n--- Daftar Produk ---");
//         if (products.isEmpty()) {
//             System.out.println("Tidak ada produk tersedia.");
//         } else {
//             for (Product product : products) {
//                 System.out.println(product.getId() + " - " + product.getName() + " Rp. " + product.getPrice());
//             }
//         }
//     }

//     public String getProductNameFromUser (){
//         System.out.print("Masukkan Nama Produk: ");
//         return scanner.nextLine();
//     }
//     public String getProductPriceFromUser (){
//         System.out.print("Masukkan Harga Product: ");
//         return scanner.nextLine();
//     }
//     public void displayMessage (String message){
//         System.out.println("INFO: " + message);
//     }
//     public void displayError (String message){
//         System.out.println("ERROR: " + message);
//     }
// }

// ProductConsoleView.java

package view;

import java.util.ArrayList;
import java.util.Scanner;
import model.Product;

public class ProductConsoleView {
    private final Scanner scanner;
    
    public ProductConsoleView(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void displayMenu() {
        System.out.println("--- APLIKASI + SERVICE LAYER + DAO PATTERN ---");
        System.out.println("1. Tampilkan semua produk");
        System.out.println("2. Tambah produk baru");
        System.out.println("3. Keluar");
        System.out.print("Pilih opsi: ");
    }
    
    public void displayAllProducts(ArrayList<Product> products) {
        System.out.println("\n--- Daftar Produk ---");
        if (products.isEmpty()) {
            System.out.println("Tidak ada produk tersedia.");
        } else {
            for (Product product : products) {
                System.out.println(product.getId() + " - " + product.getName() 
                    + " - Rp " + product.getPrice());
            }
        }
    }
    
    public void displayMessage(String message) {
        System.out.println("INFO: " + message);
    }
    
    public void displayError(String message) {
        System.out.println("ERROR: " + message);
    }
    
    public String getProductNameFromUser() {
        System.out.print("Masukkan Nama Produk: ");
        return scanner.nextLine();
    }
    
    public long getProductPriceFromUser() {
        System.out.print("Masukkan Harga Produk: ");
        return Long.parseLong(scanner.nextLine());
    }
    
    public int getMenuChoiceFromUser() {
        return Integer.parseInt(scanner.nextLine());
    }
}