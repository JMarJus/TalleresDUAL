package nttdata.javat2;
import java.util.Scanner;
import nttdata.javat2.business.*;

public class T2MainJMJ {
  public static void main(String[] args) {
    ManagementService management = new ManagementServiceImpl();
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Employee Database.");
    int option = 0;
    do {
      System.out.println("\nChoose an option from this menu:");
      System.out.println("1) Register a new employee");
      System.out.println("2) Show a specific employee");
      System.out.println("3) Show all employees");
      System.out.println("4) Show total number of registered employees");
      System.out.println("5) Terminate program");
      option = sc.nextInt();
      sc.nextLine();
      switch(option) {
        case 1:
          System.out.println("Please input the name of the new employee:");
          String name = sc.nextLine();
          System.out.println("Please input the category of the new employee:");
          String category = sc.nextLine();
          management.registerEmployee(name, category);
          break;
        case 2:
          System.out.println("Please input the ID of the existing employee:");
          int id = sc.nextInt();
          management.searchEmployee(id);
          break;
        case 3:
          management.showEmployees();
          break;
        case 4:
          management.showEmployeeTotalNumber();
          break;
        case 5:
          System.out.println("Terminating program...");
          break;
        default:
          System.out.println("Please input a valid number");
          break;
      }
    } while (option != 5);
    sc.close();
  }
}
