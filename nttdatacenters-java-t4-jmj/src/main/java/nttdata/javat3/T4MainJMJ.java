package nttdata.javat3;
import java.util.Scanner;

import nttdata.javat3.business.*;

public class T4MainJMJ {
  public static void main(String[] args) {
    ManagementService management = new ManagementServiceImpl();
    Scanner sc = new Scanner(System.in);
    System.out.println("Welcome to the Formation Database.");
    int option = 0;
    String type = "";
    String school = "";
    String studies = "";
    String category = "";
    String project = "";
    String location = "";
    do {
      System.out.println("\nChoose an option from this menu:");
      System.out.println(" 1) Register a new person");
      System.out.println(" 2) Show a specific person");
      System.out.println(" 3) Modify a specific person");
      System.out.println(" 4) Show all persons, students or employees");
      System.out.println(" 5) Show total number of registered persons, students or employees");
      System.out.println(" 6) Unregister a specific person");
      System.out.println(" 7) Register a new school");
      System.out.println(" 8) Show a specific school");
      System.out.println(" 9) Modify a specific school");
      System.out.println("10) Show all schools");
      System.out.println("11) Show total number of registered schools");
      System.out.println("12) Unregister a specific school");
      System.out.println(" 0) Terminate program");
      option = sc.nextInt();
      sc.nextLine();
      switch(option) {
        case 1:
          System.out.println("Please input the DNI of the new person:");
          String dni = sc.nextLine();
          System.out.println("Please input the name of the new person:");
          String name = sc.nextLine();
          System.out.println("Please input the type of the new person (S for student, E for employee):");
          type = sc.nextLine();
          switch(type) {
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
          management.registerPerson(type, dni, name, school, studies, category, project);
          break;
        case 2:
          System.out.println("Please input the DNI of the existing person:");
          dni = sc.nextLine();
          System.out.println("Please input the type of the existing person (S for student, E for employee):");
          type = sc.nextLine();
          management.searchPersonByDni(type, dni);
          break;
        case 3:
          System.out.println("Please input the DNI of the existing person:");
          dni = sc.nextLine();
          System.out.println("Please input the type of the existing person (S for student, E for employee):");
          type = sc.nextLine();
          management.modifyPerson(type, dni);
          break;
        case 4:
          System.out.println("Please input the type of people you want to list (S for student, E for employee, A for all):");
          type = sc.nextLine();
          management.showPeople(type);
          break;
        case 5:
          System.out.println("Please input the type of people you want to count (S for student, E for employee, A for all):");
          type = sc.nextLine();
          management.showPeopleTotalNumber(type);
          break;
        case 6:
          System.out.println("Please input the DNI of the existing person:");
          dni = sc.nextLine();
          management.unregisterPerson(dni);
          break;
        case 7:
          System.out.println("Please input the name of the new school:");
          school = sc.nextLine();
          System.out.println("Please input the location of the new school:");
          location = sc.nextLine();
          management.registerSchool(school, location);
          break;
        case 8:
          System.out.println("Please input the name of the existing school:");
          name = sc.nextLine();
          management.searchSchoolByName(name);
          break;
        case 9:
          System.out.println("Please input the name of the existing school:");
          school = sc.nextLine();
          management.modifySchool(school);
          break;
        case 10:
          management.showSchools();
          break;
        case 11:
          management.showSchoolsTotalNumber();
          break;
        case 12:
          System.out.println("Please input the name of the school:");
          school = sc.nextLine();
          management.unregisterSchool(school);
          break;
        case 0:
          System.out.println("Terminating program...");
          break;
        default:
          System.out.println("Please input a valid number");
          break;
      }
    } while (option != 0);
    sc.close();
  }
}
