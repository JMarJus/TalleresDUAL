package polimeros;

import java.util.HashMap;

/**
 * Class: represents the nexus between polimers and their simplifications
 * 
 * @author Nicolás Castillo & Juan Martínez
 */
public class MapaPolimeros {
  private HashMap<Polimero, String> polimerMap;

  /**
   * Method: constructor
   * 
   * @param
   */
  public MapaPolimeros() {
    polimerMap = new HashMap<>();
  }

  /**
   * Method: creates new relationship
   * 
   * @param
   */
  public void addPolimer(Polimero polimer, String simplification) {
    polimerMap.put(polimer, simplification);
  }

  /**
   * Method: shows a list with the full map
   * 
   * @param
   */
  public void showMap() {
    for (Polimero thisPolimer : this.polimerMap.keySet()) {
      String dominance = "";

      switch (CargasChecker.calcCharge(thisPolimer.getPolimer())) {
        case -1:
          dominance = "negative.";
          break;
        case 1:
          dominance = "positive.";
          break;
        default:
          dominance = "null (no charge dominance).";
      }
      System.out.println("The simplification of " + thisPolimer.getPolimer() + " is "
          + polimerMap.get(thisPolimer) + ", and its dominance is " + dominance);
    }
  }
}
