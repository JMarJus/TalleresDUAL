package nttdata.javat3.business;

public class Student extends Person {
  private String school;
  private String studies;
  
  /**
   * Constructor for a new student
   * @param person
   * @param school
   * @param studies
   */
  public Student(String dni, String name, String school, String studies) {
    setDni(dni);
    setName(name);
    setSchool(school);
    setStudies(studies);
  }

  public String getSchool() {
    return school;
  }

  public void setSchool(String school) {
    this.school = school;
  }

  public String getStudies() {
    return studies;
  }

  public void setStudies(String studies) {
    this.studies = studies;
  }
  
}
