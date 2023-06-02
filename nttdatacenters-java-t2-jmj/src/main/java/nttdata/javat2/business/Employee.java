package nttdata.javat2.business;

public class Employee {
  private int id;
  private String name;
  private String category;
  private static final String COMPANY = "NTT";
  private static final int EMPLOYEE_LIMIT = 30;
  
  /**
   * Constructor for a new employee
   * @param id
   * @param name
   * @param category
   */
  public Employee(int id, String name, String category, int employeeNum) {
    if (employeeNum <= getEmployeelimit()) {
      setId(id);
      setName(name);
      setCategory(category);
    } else {
      throw new IllegalArgumentException("The limit of employees has already been reached.");
    }
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCategory() {
    return category;
  }

  public void setCategory(String category) {
    this.category = category;
  }

  public String getCompany() {
    return COMPANY;
  }

  public static int getEmployeelimit() {
    return EMPLOYEE_LIMIT;
  }
  
  
}
