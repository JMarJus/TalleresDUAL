package polimeros;

/**
 * Class: represents a polimer
 * 
 * @author Nicolás Castillo & Juan Martínez
 */
public class Polimero {

  /**
   * Attribute: character string of the polimer
   */
  private String polimer;

  /**
   * Method: constructor
   * 
   * @param
   */
  public Polimero(String polimer) {
    this.setPolimer(polimer);
  }

  /**
   * Method: polimer simplificator
   * 
   * @param
   */
  public String simplifyPolimer(Polimero polimer) {
    StringBuilder simplification = new StringBuilder(polimer.polimer);

    for (int i = 0; i < simplification.length() - 1; i++) {
      char curChar = simplification.charAt(i);
      char postCurChar = simplification.charAt(i + 1);

      if ((Character.toLowerCase(curChar) == Character.toLowerCase(postCurChar))
          && ((Character.isLowerCase(curChar) && Character.isUpperCase(postCurChar))
              || (Character.isLowerCase(postCurChar) && Character.isUpperCase(curChar)))) {
        simplification.deleteCharAt(i);
        simplification.deleteCharAt(i);
        i--;
      }
    }

    return simplification.toString();
  }

  /**
   * @return
   */
  public String getPolimer() {
    return polimer;
  }

  /**
   * @param
   */
  public void setPolimer(String polimer) {
    this.polimer = polimer;
  }
}
