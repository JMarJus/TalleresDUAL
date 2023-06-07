package nttdata.javat3.business;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementServiceImpl implements ManagementService {
  
  private HashMap<String, Student> studentsById = new HashMap<>();
  private HashMap<String, Employee> employeesById = new HashMap<>();
  private HashMap<String, School> schools = new HashMap<>();
  private List<Student> students = new ArrayList<>();
  private List<Employee> employees = new ArrayList<>();
  private List<School> allSchools = new ArrayList<>();
  
  /**
   * This method adds a person to the total amount registered.
   */
  public void registerPerson(String type, String dni, String name, String school, String studies, String category, String project) {
    switch(type) {
      case "S":
        if (schools.containsKey(school)) {
          Student newStudent = new Student(dni, name, school, studies);
          students.add(newStudent);
          studentsById.put(dni, newStudent);
          School currentSchool = schools.get(newStudent.getSchool());
          currentSchool.increaseSchooled();
        }
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
  
  public void registerSchool(String name, String location) {
    if (schools.containsKey(name)) {
      System.out.println("The school " + name + " already exists.");
    } else {
      School newSchool = new School(name, location);
      schools.put(name, newSchool);
      allSchools.add(newSchool);
    }
    School newSchool = new School(name, location);
    schools.put(name, newSchool);
  }
  
  public void showSchools() {
    for (int i = 0; i < allSchools.size(); i++) {
      School currentSchool = allSchools.get(i);
      System.out.println("Name: " + currentSchool.getName());
      System.out.println("Location: " + currentSchool.getLocation());
      System.out.println("Schooled students: " + currentSchool.getSchooled() + "\n");
    }
  }
  
  public void searchSchoolByName(String name) {
    if (schools.containsKey(name)) {
      School currentSchool = schools.get(name);
      System.out.println("Name: " + currentSchool.getName());
      System.out.println("Location: " + currentSchool.getLocation());
      System.out.println("Schooled students: " + currentSchool.getSchooled());
    } else {
      System.out.println("The school " + name + " doesn't exist.");
    }
  }
  
  public void showSchoolsTotalNumber() {
    System.out.println("The total number of schools registered is: " + allSchools.size());
  }

  /**
   * This method nullifies a specific person, and it will eventually be collected by the Garbage Collector.
   */
  public void unregisterPerson(String dni) {
    if (employeesById.containsKey(dni)) {
      Employee currentEmployee = employeesById.get(dni);
      currentEmployee = null;
    } else if (studentsById.containsKey(dni)) {
      Student currentStudent = studentsById.get(dni);
      School currentSchool = schools.get(currentStudent.getSchool());
      currentSchool.reduceSchooled();
      currentStudent = null;
    } else {
      System.out.println("The person with the DNI " + dni + " doesn't exist.");
    }
  }

  /**
   * This method nullifies a specific school, and it will eventually be collected by the Garbage Collector.
   */
  public void unregisterSchool(String name) {
    if (schools.containsKey(name)) {
      School currentSchool = schools.get(name);
      currentSchool = null;
    } else {
      System.out.println("The school " + name + " doesn't exist.");
    }
  }

  public void modifyPerson(String type, String dni) {
    switch(type) {
      case "S":
        if (studentsById.containsKey(dni)) {
          Scanner sc2 = new Scanner(System.in);
          Student currentStudent = studentsById.get(dni);
          System.out.println("Old name: " + currentStudent.getName());
          System.out.print("New name: ");
          String newName = sc2.nextLine();
          System.out.println("Old school: " + currentStudent.getSchool());
          System.out.print("New school: ");
          String newSchool = sc2.nextLine();
          if (!schools.containsKey(newSchool)) {
            System.out.println("The school " + newSchool + " doesn't exist.");
          } else {
            System.out.println("Old studies: " + currentStudent.getStudies());
            System.out.print("New studies: ");
            String newStudies = sc2.nextLine();
            currentStudent.setName(newName);
            schools.get(currentStudent.getSchool()).reduceSchooled();
            currentStudent.setSchool(newSchool);
            schools.get(newSchool).increaseSchooled();
            currentStudent.setStudies(newStudies);
          }
          sc2.close();
        } else {
          System.out.println("The student with the DNI " + dni + " doesn't exist.");
        }
        break;
      case "E":
        if (employeesById.containsKey(dni)) {
          Scanner sc2 = new Scanner(System.in);
          Employee currentEmployee = employeesById.get(dni);
          System.out.println("Old name: " + currentEmployee.getName());
          System.out.print("New name: ");
          String newName = sc2.nextLine();
          System.out.println("Old category: " + currentEmployee.getCategory());
          System.out.print("New category: ");
          String newCategory = sc2.nextLine();
          System.out.println("Old project: " + currentEmployee.getProject());
          System.out.print("New project: ");
          String newProject = sc2.nextLine();
          currentEmployee.setName(newName);
          currentEmployee.setCategory(newCategory);
          currentEmployee.setProject(newProject);
          sc2.close();
        } else {
          System.out.println("The employee with the DNI " + dni + " doesn't exist.");
        }
        break;
      default:
        System.out.println("The person's type must be S or E");
        break;
    }
  }

  public void modifySchool(String name) {
    if (schools.containsKey(name)) {
      Scanner sc2 = new Scanner(System.in);
      School currentSchool = schools.get(name);
      System.out.println("Old location: " + currentSchool.getLocation());
      System.out.print("New location: ");
      String newLocation = sc2.nextLine();
      currentSchool.setLocation(newLocation);
      sc2.close();
    } else {
      System.out.println("The school " + name + " doesn't exist.");
    }
  }
}
