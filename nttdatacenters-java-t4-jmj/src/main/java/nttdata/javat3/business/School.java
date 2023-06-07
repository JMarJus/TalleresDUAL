package nttdata.javat3.business;

public class School {
  private String name;
  private String location;
  private int schooled;
  
  public School(String name, String location) {
    setName(name);
    setLocation(location);
    setSchooled(0);
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public int getSchooled() {
    return schooled;
  }

  public void setSchooled(int schooled) {
    this.schooled = schooled;
  }

  public void reduceSchooled() {
    this.schooled -= 1;
  }

  public void increaseSchooled() {
    this.schooled += 1;
  }
  
}