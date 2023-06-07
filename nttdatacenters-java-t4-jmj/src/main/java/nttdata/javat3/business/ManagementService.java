package nttdata.javat3.business;

public interface ManagementService {
  public void registerPerson(String type, String dni, String name, String school, String studies, String category, String project);
  public void showPeople(String type);
  public void searchPersonByDni(String type, String dni);
  public void showPeopleTotalNumber(String type);
  public void modifyPerson(String type, String dni);
  public void unregisterPerson(String dni);
  public void registerSchool(String name, String location);
  public void showSchools();
  public void modifySchool(String name);
  public void searchSchoolByName(String name);
  public void showSchoolsTotalNumber();
  public void unregisterSchool(String name);
}
