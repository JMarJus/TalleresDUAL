package polimeros;

import java.util.Scanner;

/**
 * Class: Main
 * 
 * @author Nicolás Castillo & Juan Martínez
 */
public class Main {

  /**
   * Method: Main
   * 
   * @param
   */
  public static void main(String[] args) {

    // Initialization

    Scanner sc = new Scanner(System.in);
    boolean notPolimer = false;
    StringBuilder polimer = new StringBuilder();
    MapaPolimeros thisMap = new MapaPolimeros();

    // Input loop

    int inputs = 2;

    do {
      polimer.delete(0, polimer.length() + 1);
      polimer.append(sc.nextLine());

      for (int i = 0; i < polimer.length() && !notPolimer; i++) {
        char curChar = polimer.charAt(i);
        if (!Character.isLetter(curChar) || curChar == 'ñ' || curChar == 'Ñ') {
          notPolimer = true;
        }
      }

      if (notPolimer) {
        System.out.println("The input is not a valid polimer. Please try again:");
        notPolimer = false;
      } else {
        inputs--;
        Polimero thisPolimer = new Polimero(polimer.toString());
        thisMap.addPolimer(thisPolimer, thisPolimer.simplifyPolimer(thisPolimer));
      }

    } while (inputs > 0);

    // Aftermath

    thisMap.showMap();

    sc.close();
  }
}
