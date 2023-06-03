package nttdata.javat3;
import java.util.Scanner;

import nttdata.javat3.business.*;

public class T3MainJMJ {
  public static void main(String[] args) {
    ManagementService management = new ManagementServiceImpl();
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Employee Database.");
    int option = 0;
    do {
      System.out.println("\nChoose an option from this menu:");
      System.out.println("1) Register a new person");
      System.out.println("2) Show a specific person");
      System.out.println("3) Show all persons, students or employees");
      System.out.println("4) Show total number of registered persons, students or employees");
      System.out.println("5) Terminate program");
      option = sc.nextInt();
      sc.nextLine();
      switch(option) {
        case 1:
          System.out.println("Please input the DNI of the new person:");
          String dni = sc.nextLine();
          System.out.println("Please input the name of the new person:");
          String name = sc.nextLine();
          System.out.println("Please input the type of the new person (S for student, E for employee):");
          String type1 = sc.nextLine();
          String school = "";
          String studies = "";
          String category = "";
          String project = "";
          switch(type1) {
            case "S":
              System.out.println("Please input the school of the new student:");
              school = sc.nextLine();
              System.out.println("Please input the studies of the new student:");
              studies = sc.nextLine();
              break;
            case "E":
              System.out.println("Please input the category of the new employee:");
              category = sc.nextLine();
              System.out.println("Please input the project of the new employee:");
              project = sc.nextLine();
              break;
            default:
              break;
          }
          management.registerPerson(type1, dni, name, school, studies, category, project);
          break;
        case 2:
          System.out.println("Please input the DNI of the existing person:");
          String nif = sc.nextLine();
          System.out.println("Please input the type of the existing person (S for student, E for employee):");
          String type2 = sc.nextLine();
          management.searchPersonByDni(type2, nif);
          break;
        case 3:
          System.out.println("Please input the type of people you want to list (S for student, E for employee, A for all):");
          String type3 = sc.nextLine();
          management.showPeople(type3);
          break;
        case 4:
          System.out.println("Please input the type of people you want to count (S for student, E for employee, A for all):");
          String type4 = sc.nextLine();
          management.showPeopleTotalNumber(type4);
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
