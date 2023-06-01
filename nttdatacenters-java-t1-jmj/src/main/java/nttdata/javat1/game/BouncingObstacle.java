package nttdata.javat1.game;

public class BouncingObstacle {
  // Obstacle
  private double posX;
  private double posY;
  private double radius;
  
  /**
   * Constructor for the different and randomized bouncing obstacles spread through the playground
   */
  public BouncingObstacle(Game pinball) {
    radius = Math.random() * (3 - 1 + 1) + 1; // Even though the property is called "radius", the obstacles are squares as of this version
    posX = Math.random() * (pinball.getWidth() - radius*2 + 1) + radius;
    posY = Math.random() * (pinball.getHeight() - radius*2 + 1) + radius;
  }
  
  /**
   * Reaction for encounter with ball (alters trajectory and adds a point on touch)
   */
  public void ballCheck(Game pinball, Ball ball) {
    // If the ball is making contact with the obstacle's area
    if (ball.getPosX() <= posX + radius && ball.getPosX() >= posX - radius && ball.getPosY() <= posY + radius && ball.getPosY() >= posY - radius) {
        // Change the direction according to the touch position
        double diffX = ball.getPosX() - posX;
        ball.setAccX(Math.signum(diffX) * 0.5);
        ball.setSpdX(diffX);
        double diffY = ball.getPosY() - posY;
        ball.setSpdY(diffY);
        pinball.setPoints(pinball.getPoints() + 1);
    }
  }
}