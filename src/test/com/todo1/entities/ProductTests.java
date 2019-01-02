package test.com.todo1.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import main.com.todo1.entities.Product;


class ProductTests {
  
  private static final Long ID = 1L;
  private static final String NAME= "Remera Star Wars";
  private static final int QUANTITY = 100;
  private static final String DESCRIPTION = "Talle L, 100% algodón.";
  

  @Test
  void testConstructorUsingFields() {
    Product product = new Product(ID, NAME, QUANTITY, DESCRIPTION);
    assertEquals(new Product(ID, NAME, QUANTITY, DESCRIPTION), product);
  }
  
  @Test
  void testGettersAndSetters() {
    Product product = new Product();
    product.setId(ID);
    product.setName(NAME);
    product.setQuantity(QUANTITY);
    product.setDescription(DESCRIPTION);
    
    assertEquals(ID, product.getId());
    assertEquals(NAME, product.getName());
    assertEquals(QUANTITY, product.getQuantity());
    assertEquals(DESCRIPTION, product.getDescription());
  }

}
