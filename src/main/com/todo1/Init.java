package main.com.todo1;

import java.util.Scanner;

import main.com.todo1.uitls.Constants;
import main.com.todo1.uitls.MenuOptions;

public class Init {

  public static void main(String[] args) {
    int optionSelected = 0;
    Scanner scan;
    
    System.out.println(Constants.WELCOME_MSG);
    System.out.println(Constants.HYPEN_SEPARATORS);
    System.out.println(Constants.SELECT_OPTION_MSG);
    
    
    while (optionSelected != MenuOptions.EXIT.optionValue()) {
      
      for (MenuOptions op : MenuOptions.values()) {
        System.out.println(op.optionValue() + " - " + op.optionMsg());
      }
      
      scan = new Scanner(System.in);
      optionSelected = scan.nextInt();
      
      if (MenuOptions.INSERT.optionValue() == optionSelected) {
        
      } else if (MenuOptions.REMOVE.optionValue() == optionSelected) {
        
      } else if (MenuOptions.LIST.optionValue() == optionSelected) {
        
      } else if (MenuOptions.EXIT.optionValue() == optionSelected) {
        break;
      } else {
        System.out.println(Constants.ERROR_OPTION_MSG);
      }
    }
    System.out.println(Constants.BYE_MSG);
    
  }
}
