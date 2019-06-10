package cl.matrices;

import org.junit.Assert;
import org.junit.Test;

public class FactoriaHebrasTest {


  @Test
  public void obtieneHebraCoincidencia() {
    FactoriaHebras factoriaHebras = new FactoriaHebras();
    Class<HebraCoincidencia> claseEsperada = HebraCoincidencia.class;
    int dimension = 2;
    Matriz[] matrices = {new Matriz(dimension)};
    Hebra hebra = factoriaHebras.crearHebra(Hebra.TIPO.COINCIDENCIA, matrices);
    Class<?> claseResultante = hebra.getClass();
    Assert.assertEquals(claseEsperada, claseResultante);
  }

  @Test
  public void obtieneHebraPrimo() {
    FactoriaHebras factoriaHebras = new FactoriaHebras();
    Class<HebraPrimo> claseEsperada = HebraPrimo.class;
    int dimension = 2;
    Matriz[] matrices = {new Matriz(dimension)};
    Hebra hebra = factoriaHebras.crearHebra(Hebra.TIPO.PRIMO, matrices);
    Class<?> claseResultante = hebra.getClass();
    Assert.assertEquals(claseEsperada, claseResultante);
  }

  @Test
  public void obtieneHebraDivision() {
    FactoriaHebras factoriaHebras = new FactoriaHebras();
    Class<HebraDivision> claseEsperada = HebraDivision.class;
    int dimension = 2;
    Matriz[] matrices = {new Matriz(dimension)};
    Hebra hebra = factoriaHebras.crearHebra(Hebra.TIPO.DIVISION, matrices);
    Class<?> claseResultante = hebra.getClass();
    Assert.assertEquals(claseEsperada, claseResultante);
  }
}