package nttdata.javat3.business;

public class Employee extends Person {
  private String category;
  private String project;
  
  /**
   * Constructor for a new employee
   * @param person
   * @param category
   * @param employeeNum
   */
  public Employee(String dni, String name, String category, String project) {
    setDni(dni);
    setName(name);
    setCategory(category);
    setProject(project);
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getProject() {
    return project;
  }

  public void setProject(String project) {
    this.project = project;
  }
  
}
