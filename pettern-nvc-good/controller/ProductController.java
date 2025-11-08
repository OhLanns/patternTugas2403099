// package controller;


// import view.ProductConsoleView;
// import java.util.ArrayList;
// import model.Product;

// public class ProductController{
//     private final ProductConsoleView view;
//     private final ArrayList<Product> model = new ArrayList<>();

//     public ProductController(ProductConsoleView view){
//         this.view = view;
//         model.add(new Product(1, "Laptop ASUS", 950));
//     }

//     public void handleMenuChoice(int choice){
//         switch (choice) {
//             case 1: 
//             displayProductsAction();
//             break;
//             case 2: 
//             addProduct();
//             break;
//             case 3:
//             view.displayMessage("keluar dari aplikasi");
//             break;
//             default:
//             view.displayError("pilihan tidak valid");
//         }
//     }

//     private void displayProductsAction(){
//         view.displayAllProducts(model);
//     }

//     private void addProduct(){
//         String name = view.getProductNameFromUser();
//         String priceStr = view.getProductPriceFromUser();
//         try{
//             double price = Double.parseDouble(priceStr);
//             if (price <= 0 ) {
//                 throw new IllegalArgumentException("harga hatus positif lebih dari 0 ");
//             }
//             int newId = model.size()+1;
//             model.add(new Product(newId, name, (long) price));
//             view.displayMessage("Produk ditambahkan");
//         } catch(IllegalArgumentException e){
//             view.displayError("gagal menambah produk: "+ e.getMessage());
//         }
//     }
// }


package controller;

import service.ProductService;
import view.ProductConsoleView;

public class ProductController {
    private final ProductService service;
    private final ProductConsoleView view;

    public ProductController(ProductService service, ProductConsoleView view) {
        this.service = service;
        this.view = view;
    }

    public void handleMenuChoice(String menuChoice) {
        try {
            int menu = Integer.parseInt(menuChoice);
            switch (menu) {
                case 1:
                    showAllProducts();
                    break;
                case 2:
                    addNewProduct();
                    break;
                case 3:
                    view.displayMessage("Aplikasi ditutup.");
                    System.exit(0);
                    break;
                default:
                    view.displayError("Opsi tidak valid.");
                    break;
            }
        } catch (NumberFormatException e) {
            view.displayError("Input tidak valid. Masukkan angka.");
        }
    }

    private void addNewProduct() {
        String name = view.getProductNameFromUser();
        long price = view.getProductPriceFromUser();
        try {
            service.addProduct(name, price);
            view.displayMessage("Produk berhasil ditambahkan!");
        } catch (Exception e) {
            view.displayError("Gagal menambah produk: " + e.getMessage());
        }
    }

    private void showAllProducts() {
        view.displayAllProducts(service.getAllProducts());
    }
}