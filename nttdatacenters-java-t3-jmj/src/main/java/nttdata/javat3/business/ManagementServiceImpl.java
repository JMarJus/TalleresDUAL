package nttdata.javat3.business;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ManagementServiceImpl implements ManagementService {
  
  private HashMap<String, Student> studentsById = new HashMap<>();
  private HashMap<String, Employee> employeesById = new HashMap<>();
  private List<Student> students = new ArrayList<>();
  private List<Employee> employees = new ArrayList<>();
  
  /**
   * This method adds a person to the total amount registered.
   */
  public void registerPerson(String type, String dni, String name, String school, String studies, String category, String project) {
    switch(type) {
      case "S":
        Student newStudent = new Student(dni, name, school, studies);
        students.add(newStudent);
        studentsById.put(dni, newStudent);
        break;
      case "E":
        Employee newEmployee = new Employee(dni, name, category, project);
        employees.add(newEmployee);
        employeesById.put(dni, newEmployee);
        break;
      default:
        System.out.println("The person's type must be S or E");
        break;
    }
  }
  
  /**
   * This method outputs all properties of the specified category of people, ordered by antiquity.
   */
  public void showPeople(String type) {
    if (type.equals("S") || type.equals("A")) {
      if (!students.isEmpty()) {
        for (int i = 0; i < students.size(); i++) {
          Student currentStudent = students.get(i);
          System.out.println("DNI: " + currentStudent.getDni());
          System.out.println("Name: " + currentStudent.getName());
          System.out.println("School: " + currentStudent.getSchool());
          System.out.println("Studies: " + currentStudent.getStudies() + "\n");
        }
      } else {
        System.out.println("The student list is currently empty");
      }
    }
    if (type.equals("E") || type.equals("A")) {
      if (!employees.isEmpty()) {
        for (int i = 0; i < employees.size(); i++) {
          Employee currentEmployee = employees.get(i);
          System.out.println("DNI: " + currentEmployee.getDni());
          System.out.println("Name: " + currentEmployee.getName());
          System.out.println("Category: " + currentEmployee.getCategory());
          System.out.println("Project: " + currentEmployee.getProject() + "\n");
        }
      } else {
        System.out.println("The employee list is currently empty");
      }
    }
  }
  
  /**
   * This method outputs a specific employee given the ID.
   */
  public void searchPersonByDni(String type, String dni) {
    switch(type) {
      case "S":
        if (studentsById.containsKey(dni)) {
          Student currentStudent = studentsById.get(dni);
          System.out.println("Name: " + currentStudent.getName());
          System.out.println("School: " + currentStudent.getSchool());
          System.out.println("Studies: " + currentStudent.getStudies());
        } else {
          System.out.println("The student with the DNI " + dni + " doesn't exist.");
        }
        break;
      case "E":
        if (employeesById.containsKey(dni)) {
          Employee currentEmployee = employeesById.get(dni);
          System.out.println("Name: " + currentEmployee.getName());
          System.out.println("Category: " + currentEmployee.getCategory());
          System.out.println("Project: " + currentEmployee.getProject());
        } else {
          System.out.println("The employee with the DNI " + dni + " doesn't exist.");
        }
        break;
      default:
        System.out.println("The person's type must be S or E");
        break;
    }
  }
  
  /**
   * This method outputs the total registered number of a specified type of people.
   */
  public void showPeopleTotalNumber(String type) {
    switch(type) {
      case "A":
        System.out.println("The total number of people registered is: " + (students.size() + employees.size()));
        break;
      case "S":
        System.out.println("The total number of students registered is: " + students.size());
        break;
      case "E":
        System.out.println("The total number of employees registered is: " + employees.size());
        break;
      default:
        System.out.println("The input must be S, E or A");
        break;
    }
  }
}
