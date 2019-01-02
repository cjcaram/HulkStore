package main.com.todo1.uitls;

public enum MenuOptions {
  INSERT(1, "Insertar un producto nuevo."),
  REMOVE(2, "Retirar un producto."),
  LIST(3, "Listar Productos"),
  EXIT(4, "Salir.");

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
