package cl.rodrigo;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

public class PersonaTest {

  @Test
  public void probarSumaDeDosNumeros() {
    int expectedResult = 4;
    int primerSumando = 2;
    int segundoSumando = 2;
    int result = primerSumando + segundoSumando;
    Assert.assertEquals(expectedResult, result);
  }

  @Test
  public void numberEnteredByConsoleIsOK() {
    int expected = 5;
    int result = 0;
    try {
      result = System.in.read();
    } catch (IOException e) {
      e.printStackTrace();
    }
    Assert.assertEquals(expected, result);
  }

}