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

}