package nttdata.javat1.game;

public class Game {
  // Playground size
  private double height = 100;
  private double width = 12;
  
  // Points
  private int points = 0;
  
  // If the coordinates will be shown
  private boolean show = false;
  
  // Obstacles (position is randomized)
  private BouncingObstacle obs1 = new BouncingObstacle(this);
  private BouncingObstacle obs2 = new BouncingObstacle(this);
  private BouncingObstacle obs3 = new BouncingObstacle(this);
  
  /**
   * Method for starting the game
   */
  public void launchAndStart() {
    Ball ball = new Ball();
    ball.launch(this);
  }
  
  // -- Getters and setters --

  public double getHeight() {
    return height;
  }

  public void setHeight(double height) {
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public void setWidth(double width) {
    this.width = width;
  }

  public int getPoints() {
    return points;
  }

  public void setPoints(int points) {
    this.points = points;
  }

  public boolean isShow() {
    return show;
  }

  public void setShow(boolean show) {
    this.show = show;
  }

  public BouncingObstacle getObs1() {
    return obs1;
  }

  public void setObs1(BouncingObstacle obs1) {
    this.obs1 = obs1;
  }

  public BouncingObstacle getObs2() {
    return obs2;
  }

  public void setObs2(BouncingObstacle obs2) {
    this.obs2 = obs2;
  }

  public BouncingObstacle getObs3() {
    return obs3;
  }

  public void setObs3(BouncingObstacle obs3) {
    this.obs3 = obs3;
  }
  
}
