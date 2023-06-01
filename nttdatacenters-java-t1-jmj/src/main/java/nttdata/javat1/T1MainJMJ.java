package nttdata.javat1;
import nttdata.javat1.game.Game;
import java.util.Scanner;

public class T1MainJMJ {
  public static void main(String[] args) {
    Game pinball = new Game();
    Scanner sc = new Scanner(System.in);
    System.out.println("The pinball game will start. Input \"Y\" if you want to see the ball's coordinates during the fall.");
    if (sc.nextLine().equals("Y")) {
      pinball.setShow(true);
    }
    pinball.launchAndStart();
    System.out.println("Total points: " + pinball.getPoints());
    sc.close();
  }
}
