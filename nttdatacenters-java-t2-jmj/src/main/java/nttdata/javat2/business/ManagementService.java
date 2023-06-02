package nttdata.javat2.business;

public interface ManagementService {
  public void registerEmployee(String name, String category);
  public void showEmployees();
  public void showEmployeeTotalNumber();
  public void searchEmployee(int id);
}
