package test.com.todo1.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Collection;
import java.util.HashMap;

import org.junit.jupiter.api.Test;

import main.com.todo1.entities.Product;
import main.com.todo1.services.ProductService;

class ProductServiceTests {
  
  private final int EXPECTED_INITIAL_STOCK_SIZE = 2;
  private final static Long PRODUCT_ID_1 = 1L;
  private ProductService service = new ProductService();
  private Product testProd = new Product(99L, "Test Name", 100, "Test Description");
  
  @Test
  void initStockTest() {
    assertTrue(EXPECTED_INITIAL_STOCK_SIZE == service.listProducts().size());
  }
  
  @Test
  void listStockTest() {
    HashMap<Long, Product> expectedStock = new HashMap<>();
    expectedStock.put(1L, new Product(PRODUCT_ID_1, "Cubo Rubick", 5, "3*3 tema de Star Wars"));
    expectedStock.put(2L, new Product(2L, "Naipes", 7, "Con imagenes de Marvel"));
    for (Product actualProd : service.listProducts()) {
      assertEquals(actualProd, expectedStock.get(actualProd.getId()));
    }
  }
  
  @Test
  void removeProductToStockTest() {
    final int EXPECTED_STOCK_SIZE_AFTER_REMOVE = EXPECTED_INITIAL_STOCK_SIZE - 1;
    assertTrue(service.listProducts().size() == EXPECTED_INITIAL_STOCK_SIZE);
    Collection<Product> productList = service.listProducts();
    Product prodToRemove = productList.iterator().next();
    service.removeProduct(prodToRemove.getId());
    assertTrue(service.listProducts().size() == EXPECTED_STOCK_SIZE_AFTER_REMOVE);
    service.insertProduct(prodToRemove);
  }
  
  @Test
  void checkExistTest() {
    assertTrue(service.productExist(PRODUCT_ID_1));
  }
  
  @Test
  void insertProductToStockTest() {
    final int EXPECTED_STOCK_SIZE_AFTER_INSERT = EXPECTED_INITIAL_STOCK_SIZE + 1;
    assertTrue(service.listProducts().size() == EXPECTED_INITIAL_STOCK_SIZE);
    service.insertProduct(testProd);
    assertTrue(service.listProducts().size() == EXPECTED_STOCK_SIZE_AFTER_INSERT);
    service.removeProduct(testProd.getId());
  }
  
  @Test
  void withdrawProductTest() {
    Collection<Product> productList = service.listProducts();
    Product prodToWithdraw = productList.iterator().next();
    int withdrawAmount = prodToWithdraw.getQuantity();
    assertTrue(service.getOne(prodToWithdraw.getId()).getQuantity() == withdrawAmount);
    service.withdrawProductFromStock(prodToWithdraw, withdrawAmount);
    assertTrue(service.getOne(prodToWithdraw.getId()).getQuantity() == 0);
    service.addProductToStock(prodToWithdraw, withdrawAmount);
  }
  
  @Test
  void addProductToStockTest() {
    Collection<Product> productList = service.listProducts();
    Product prodToWithdraw = productList.iterator().next();
    int withdrawAmount = prodToWithdraw.getQuantity();
    assertTrue(service.getOne(prodToWithdraw.getId()).getQuantity() == withdrawAmount);
    service.addProductToStock(prodToWithdraw, withdrawAmount);
    assertTrue(service.getOne(prodToWithdraw.getId()).getQuantity() == withdrawAmount * 2);
    service.withdrawProductFromStock(prodToWithdraw, withdrawAmount);
  }
  
  @Test
  void addStockProductTest() {
    assertTrue(service.productExist(PRODUCT_ID_1));
  }
  
}
