package nttdata.javat3.business;

public interface ManagementService {
  public void registerPerson(String type, String dni, String name, String school, String studies, String category, String project);
  public void showPeople(String type);
  public void searchPersonByDni(String type, String dni);
  public void showPeopleTotalNumber(String type);
}
