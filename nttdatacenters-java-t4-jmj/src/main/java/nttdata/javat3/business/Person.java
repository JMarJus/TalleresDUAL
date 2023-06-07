package nttdata.javat3.business;

public abstract class Person {
  private String dni;
  private String name;
  
  /**
   * Constructor for a new person
   * @param dni
   * @param name
   */
  protected Person(String dni, String name) {
    setDni(dni);
    setName(name);
  } protected Person() {}

  public String getDni() {
    return dni;
  }

  public void setDni(String dni) {
    this.dni = dni;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
  
  
}
