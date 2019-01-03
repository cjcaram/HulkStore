package main.com.todo1.services;

import java.util.Collection;
import java.util.HashMap;

import main.com.todo1.entities.Product;

public class ProductService {
  
  private static HashMap<Long, Product> stock = initStock();
  
  private static HashMap<Long, Product> initStock() {
    HashMap<Long, Product> existingProducts = new HashMap<>();
    existingProducts.put(1L, new Product(1L, "Cubo Rubick", 5, "3*3 tema de Star Wars"));
    existingProducts.put(2L, new Product(2L, "Naipes", 7, "Con imagenes de Marvel"));
    return existingProducts;
  }
  
  
  public void insertProduct(Product prod) {
    stock.put(prod.getId(), prod);
  }

  public Collection<Product> listProducts() {
    return stock.values();
  }
  
  public Product getOne(Long id) {
    return stock.get(id);
  }
  
  public boolean productExist(Long id) {
    return stock.containsKey(id);
  }

  public void withdrawProductFromStock(Product prod, int amount) {
    prod.setQuantity(prod.getQuantity() - amount);
    insertProduct(prod);
  }
  
  public void addProductToStock(Product prod, int amount) {
    prod.setQuantity(prod.getQuantity() + amount);
    insertProduct(prod);
  }


  public void removeProduct(Long id) {
    if (stock.containsKey(id)) {
      stock.remove(id);
    }
  }
  

}
