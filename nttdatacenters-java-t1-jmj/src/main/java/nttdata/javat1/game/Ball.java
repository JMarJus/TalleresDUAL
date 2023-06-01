package nttdata.javat1.game;


public class Ball {
  // Ball properties
  private double spdX;
  private double spdY;
  private double accX;
  private double accY;
  private double posX;
  private double posY;
  
  /**
   * Method for calculating the posX in which the ball will start and initializing the rest of properties
   */
  public void launch(Game pinball) {
    // Initialization of properties
    posX = Math.random() * pinball.getWidth();
    posY = 0;
    accX = 0;
    accY = 0.1;
    spdX = 0;
    spdY = 0;
    
    // Upon finishing initialization, the fall will start
    fall(pinball);
  }
  
  /**
   * Method for calculating speed and acceleration properties when falling, all while the ball is not at the bottom of the playground
   */
  public void fall(Game pinball) {
    for (posY = 0; posY < pinball.getHeight(); posY += spdY) {
      // Show coordinates
      if (pinball.isCoordinates()) {
        System.out.println("(" + posX + ", " + posY + ")");
      }
      
      // If the horizontal speed has reached zero or horizontal acceleration shares its signum, both properties will stop having effect
      if (spdX == 0 || Math.signum(spdX) == Math.signum(accX)) {
        spdX = 0;
        accX = 0;
      }
      
      // For every step, the speed will change according to the acceleration and the position will be updated (posY on loop)
      spdY += accY;
      spdX += accX;
      posX += spdX;
      
      // If the ball goes out of bounds (X), the horizontal direction is reversed and an additional horizontal step is taken
      if (posX < 0 || posX > pinball.getWidth()) {
        spdX = -spdX;
        accX = -accX;
        posX += spdX;
        // Show clash
        if (pinball.isEvents()) {
          System.out.println("Wall clash!");
        }
      }
      
      // For every step, check if the ball is making contact with any of the obstacles
      pinball.getObs1().ballCheck(pinball, this);
      pinball.getObs2().ballCheck(pinball, this);
      pinball.getObs3().ballCheck(pinball, this);
    }
  }
  
  // -- Getters and setters --

  public double getSpdX() {
    return spdX;
  }

  public void setSpdX(double spdX) {
    this.spdX = spdX;
  }

  public double getSpdY() {
    return spdY;
  }

  public void setSpdY(double spdY) {
    this.spdY = spdY;
  }

  public double getAccX() {
    return accX;
  }

  public void setAccX(double accX) {
    this.accX = accX;
  }

  public double getAccY() {
    return accY;
  }

  public void setAccY(double accY) {
    this.accY = accY;
  }

  public double getPosX() {
    return posX;
  }

  public void setPosX(double posX) {
    this.posX = posX;
  }

  public double getPosY() {
    return posY;
  }

  public void setPosY(double posY) {
    this.posY = posY;
  }
}