package main.com.todo1.views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.com.todo1.entities.Product;
import main.com.todo1.services.ProductService;
import main.com.todo1.uitls.Constants;
import main.com.todo1.uitls.MenuOptions;

public class View {
  
  private static final String YES = "S";
  private static final String NO = "N";
  private static ProductService service = new ProductService();
  private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  
  public static void showMainScreen() {
    
    System.out.println(Constants.WELCOME_MSG);
    System.out.println(Constants.HYPEN_SEPARATORS);
    System.out.println(Constants.SELECT_OPTION_MSG);
    
    selectTaskFromMenu();
    
    System.out.println(Constants.BYE_MSG);
  }
  
  private static void selectTaskFromMenu() {
    int optionSelected = 0;
    while (optionSelected != MenuOptions.EXIT.optionValue()) {
      showMenuOption();
      optionSelected = readInt();
      if (MenuOptions.INSERT.optionValue() == optionSelected) {
        insertView();
      } else if (MenuOptions.WITHDRAW.optionValue() == optionSelected) {
        withdrawStock();
      } else if (MenuOptions.REMOVE.optionValue() == optionSelected) {
        removeStock();
      } else if (MenuOptions.ADD.optionValue() == optionSelected) {
        addStock();
      } else if (MenuOptions.LIST.optionValue() == optionSelected) {
        listStock();
      } else if (MenuOptions.EXIT.optionValue() == optionSelected) {
        break;
      } else {
        System.out.println(Constants.ERROR_OPTION_MSG);
      }
      System.out.println(Constants.HYPEN_SEPARATORS);
    }
  }

  private static void listStock() {
    for (Product prod : service.listProducts()) {
      System.out.println(prod.toString());
    }
  }

  private static void showMenuOption() {
    for (MenuOptions op : MenuOptions.values()) {
      System.out.println(op.optionValue() + " - " + op.optionMsg());
    }
  }
  
  private static void insertView() {
    Product prod = new Product();
    prod.setId(getId());
    System.out.print("Nombre:");
    prod.setName(readString());
    System.out.print("Descripción:");
    prod.setDescription(readString());
    System.out.print("Cantidad:");
    prod.setQuantity(readInt());
    service.insertProduct(prod);
    System.out.println(Constants.SUCCESS_MSG);
  }
  
  private static Long getId() {
    Long id = -1L;
    boolean isInsertion = true;
    while (isInsertion) {
      System.out.print("Identificador Numerico:");
      id = readLong();
      if (service.productExist(id)) {
        System.out.println("Ya existe un producto con este identificador, desea sobreescribirlo? (" + YES + ")i o (" + NO + ")o");
        String answer = readString();
        if (answer.toUpperCase().contains(YES)) {
          isInsertion = false;
        }
      } else {
        break;
      }
    }
    return id;
  }

  private static void addStock() {
    Product prod = selectProduct();
    if (prod != null) {
      System.out.println("Ingrese cantidad a agregar: ");
      int amount = readInt();
      service.addProductToStock(prod, amount);
      System.out.println(Constants.SUCCESS_MSG);
    }
  }
  
  private static void withdrawStock() {
    Product prod = selectProduct();
    if (prod != null) {
      System.out.println("Ingrese cantidad a retirar: ");
      int amount = readInt();
      if (amount > prod.getQuantity()) {
        System.out.println("No puede retirar una cantidad mayor a la existente.");
      } else {
        service.withdrawProductFromStock(prod, amount);
        System.out.println(Constants.SUCCESS_MSG);
      }
    }
  }
  
  private static void removeStock() {
    Product prod = selectProduct();
    if (prod != null) {
      System.out.println("Confirma que desea borrar este producto? (" + YES + ")i o (" + NO + ")o");
      String answer = readString();
      if (answer.toUpperCase().contains(YES)) {
        service.removeProduct(prod.getId());
        System.out.println(Constants.SUCCESS_MSG);
      }
    }
  }
  
  private static Product selectProduct() {
    Product prod = null;
    System.out.print("Ingrese el identificador del producto: ");
    Long id = readLong();
    prod = service.getOne(id);
    if (prod != null) {
      System.out.println("Producto seleccionado: " + prod.toString());
    } else 
    {
      System.out.println("No se encontro el producto indicado.");
    }
    System.out.println("");
    return prod;
  }
  
  private static int readInt() {
    Integer result = null;
    while (result == null) {
      try {
        result = Integer.parseInt(br.readLine());
      } catch (NumberFormatException e) {
        handleNumericFormatException();
      } catch (IOException e) {
        handleIOException();
      }
    }
    return result;
  }
  
  private static String readString() {
    String result = null;
    while (result == null) {
      try {
        result = br.readLine();
      } catch (IOException e) {
        handleIOException();
      }
    }
    return result;
  }
  
  private static Long readLong() {
    Long result = null;
    while (result == null) {
      try {
        result = Long.valueOf(br.readLine());
      } catch (NumberFormatException e) {
        handleNumericFormatException();
      } catch (IOException e) {
        handleIOException();
      }
    }
    return result;
  }
  
  private static void handleNumericFormatException () {
    System.out.println(Constants.NUMERIC_ERROR_MSG);
    System.out.println(Constants.TRY_AGAIN_MSG);
  }
  
  private static void handleIOException () {
    System.out.println(Constants.UNEXPECTED_ERROR_MSG);
    System.out.println(Constants.TRY_AGAIN_MSG);
  }
  

}
