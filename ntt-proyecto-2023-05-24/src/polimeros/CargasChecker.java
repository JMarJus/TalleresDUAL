package polimeros;

/**
 * Class: method collection for polimer charge calculations
 * 
 * @author Nicolás Castillo & Juan Martínez
 */
public class CargasChecker {

  /**
   * Method: constructor (unused)
   * 
   * @param
   */
  private CargasChecker() {}

  /**
   * Method: positive charge counter
   * 
   * @param
   */
  public static int countPosCharge(String polimero) {
    int result = 0;

    for (int i = 0; i < polimero.length() - 1; i++) {
      char curChar = polimero.charAt(i);
      char postCurChar = polimero.charAt(i + 1);

      if ((Character.toLowerCase(curChar) == Character.toLowerCase(postCurChar))
          && (Character.isUpperCase(postCurChar) && Character.isUpperCase(curChar))) {
        result++;
      }
    }
    return result;
  }

  /**
   * Method: negative charge counter
   * 
   * @param
   */
  public static int countNegCharge(String polimero) {
    int result = 0;

    for (int i = 0; i < polimero.length() - 1; i++) {
      char curChar = polimero.charAt(i);
      char postCurChar = polimero.charAt(i + 1);

      if ((Character.toLowerCase(curChar) == Character.toLowerCase(postCurChar))
          && (Character.isLowerCase(postCurChar) && Character.isLowerCase(curChar))) {
        result++;
      }
    }
    return result;
  }

  /**
   * Method: dominance calculator
   * 
   * @param
   */
  public static int calcCharge(String polimero) {
    int charge = 0;

    if (countPosCharge(polimero) > countNegCharge(polimero)) {
      charge = 1;
    } else if (countPosCharge(polimero) < countNegCharge(polimero)) {
      charge = -1;
    }
    return charge;
  }
}
