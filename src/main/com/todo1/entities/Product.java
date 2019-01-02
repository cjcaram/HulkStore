package main.com.todo1.entities;

import java.util.Objects;

public class Product {
  
  private Long id;
  private String name;
  private int quantity;
  private String description;
  
  public Product(Long id, String name, int quantity, String description) {
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.description = description;
  }

  public Product() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  
  @Override
  public boolean equals(Object o) {
    if (o == this) return true;
    if (!(o instanceof Product)) return false;
    
    Product product = (Product) o;
    return id == product.id &&
        Objects.equals(name, product.name) &&
        Objects.equals(quantity, product.quantity) &&
        Objects.equals(description, product.description);
  }
  
  @Override
  public int hashCode() {
      return Objects.hash(id, name, quantity, description);
  }
}
