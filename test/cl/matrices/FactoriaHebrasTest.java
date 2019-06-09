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
}