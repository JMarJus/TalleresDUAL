package nttdata.javat1;
import nttdata.javat1.game.Game;
import java.util.Scanner;

public class T1MainJMJ {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean newGame = true;
    
    // A new game will be started
    while (newGame) {
      Game pinball = new Game();
      System.out.println("The pinball game will start. Input 1 if you want to see the ball's coordinates, input 2 if you want to see the bounces and clashes during the fall, input 3 if you want to see all, and input 0 if you want to see nothing.");
      String input = "";
      
      // The user must input a number from 0 to 3 before continuing
      do {
        input = sc.nextLine();
        if (input.equals("0")) {
          pinball.setCoordinates(false);
          pinball.setEvents(false);
        } else if (input.equals("1")) {
          pinball.setCoordinates(true);
          pinball.setEvents(false);
        } else if (input.equals("2")) {
          pinball.setCoordinates(false);
          pinball.setEvents(true);
        } else if (input.equals("3")) {
          pinball.setCoordinates(true);
          pinball.setEvents(true);
        } else {
          System.out.println("Please, input a number from 0 to 3.");
        }
      } while (!input.equals("1") && !input.equals("2") && !input.equals("3") && !input.equals("0"));
      pinball.launchAndStart();
      System.out.println("Total points: " + pinball.getPoints());
      
      // The user can terminate the program or continue playing
      System.out.println("Input \"Y\" to play again. Otherwise, the program will terminate.");
      input = sc.nextLine();
      if (!input.equals("Y")) {
        newGame = false;
      }
    }
    sc.close();
  }
}