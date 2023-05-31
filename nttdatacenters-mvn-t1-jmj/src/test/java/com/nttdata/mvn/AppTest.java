package com.nttdata.mvn;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
  // Test del metodo para sumar dos numeros
  @Test
  public void sumaTest() {
    double result = App.suma(2, 3);
    double expected = 5;
    assertEquals(result, expected);
  }
}