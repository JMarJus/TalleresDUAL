package nttdata.javat2.business;
import java.util.HashMap;

public class ManagementServiceImpl implements ManagementService {
  
  /** Tool for saving each employee and securing the maximum number of employees is not surpassed */
  private int employeeNum = 0;
  private HashMap<Integer, Employee> employees = new HashMap<>();
  
  /**
   * This method adds an employee to the total amount registered and generates a random ID number between 100000 and 999999, securing it has 6 ciphers.
   * It then registers a new employee based on this data and saves it.
   */
  public void registerEmployee(String name, String category) {
    try {
      employeeNum += 1;
      int id = (int)(Math.random() * (999999 - 100000 + 1) + 100000); // This line gives a SonarLint error because it asks for the use of java.util.Random.nextInt(), but the usage of that method requires tampering with static properties
      Employee newEmployee = new Employee(id, name, category, employeeNum);
      employees.put(id, newEmployee);
      System.out.println("The ID of the employee " + name + " is " + id);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  /**
   * This method outputs the ID, name and category of all employees, ordered by antiquity.
   */
  public void showEmployees() {
    if (employees.size() > 0) {
      for (int i = 0; i < employees.size(); i++) {
        Employee currentEmployee = employees.get(i);
        System.out.println("Employee with ID " + currentEmployee.getId() + ":");
        System.out.println("Name: " + currentEmployee.getName());
        System.out.println("Category: " + currentEmployee.getCategory() + "\n");
      }
    } else {
      System.out.println("The employee list is currently empty");
    }
  }

  
  /**
   * This method outputs the total number of registered employees.
   */
  public void showEmployeeTotalNumber() {
    System.out.println("The current total number of employees is: " + employeeNum);
    System.out.println("The maximum number of registered employees is: " + Employee.getEmployeelimit());
  }

  
  /**
   * This method outputs a specific employee given the ID.
   */
  public void searchEmployee(int id) {
    if (employees.containsKey(id)) {
      Employee currentEmployee = employees.get(id);
      System.out.println("Employee with ID " + id + ":");
      System.out.println("Name: " + currentEmployee.getName());
      System.out.println("Category: " + currentEmployee.getCategory());
    } else {
      System.out.println("The employee with ID " + id + " doesn't exist.");
    }
  }
}
