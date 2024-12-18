package com.nttdata.logback;

import java.util.Random;

import ch.qos.logback.classic.Logger;
import org.slf4j.LoggerFactory;

/**
 * Main class
 * @author Juan Martinez Justicia
 */
public class App {
  /** Logger implementation */
  private static final Logger LOG = (Logger) LoggerFactory.getLogger(App.class);
  /** Number of loops for generation of files */
  private static final int LOGGER_CHECKER_LOOPS = 3750;
  /**
   * Method: main
   * @param args
   */
  public static void main(String[] args) {
    if (LOG.isTraceEnabled()) {
      LOG.trace("Started");
    }
    // Attempting generation of multiple 50KB size file outputs by using a loop
    for (int i = 0; i < LOGGER_CHECKER_LOOPS; i++) {
      if (LOG.isDebugEnabled()) {
        LOG.debug("Iteration number: " + (i + 1));
      }
    }
    // Generating random number and checking if it is greater than 100
    final int maxNumber = 100;
    final Random r = new Random();
    int randomNum = r.nextInt(maxNumber);
    if (LOG.isDebugEnabled()) {
      LOG.debug("Random number: " + randomNum);
    }
    greaterThan(randomNum, 50);
    if (LOG.isTraceEnabled()) {
      LOG.trace("Terminated");
    }
  }

  
  /**
   * Method: check if random number is bigger than maximum number
   * @param entryNum
   * @param maxNum
   */
  private static void greaterThan(final int entryNum, final int maxNum) {
    if (entryNum > maxNum) {
      System.out.println(entryNum + " is greater than " + maxNum);
      if (LOG.isWarnEnabled()) {
        LOG.warn("Great number");
      }
    }
  }
}
