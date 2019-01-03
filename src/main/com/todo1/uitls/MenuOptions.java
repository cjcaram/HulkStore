package main.com.todo1.uitls;

public enum MenuOptions {
  INSERT(1, "Insertar un producto nuevo."),
  ADD(2, "Agregar Stock"),
  WITHDRAW(3, "Retirar Stock de un producto."),
  REMOVE(4, "Eliminar Producto."),
  LIST(5, "Listar Productos"),
  EXIT(6, "Salir.");

  private String optionMsg;
  private int optionValue;

  MenuOptions(int optionValue, String optionMsg) {
      this.optionMsg = optionMsg;
      this.optionValue = optionValue;
  }

  public String optionMsg() {
      return optionMsg;
  }
  
  public int optionValue() {
    return optionValue;
  }
}
