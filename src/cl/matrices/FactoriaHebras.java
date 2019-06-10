package cl.matrices;

import cl.matrices.Hebra.TIPO;

public class FactoriaHebras {

  public FactoriaHebras() {
  }

  public synchronized Hebra crearHebra(TIPO tipoHebra, Matriz[] matrices) {
    Hebra hebra = null;
    switch (tipoHebra) {
    case COINCIDENCIA:
      hebra = new HebraCoincidencia();
      hebra.setMatrices(matrices);
      break;
    case PRIMO:
      hebra = new HebraPrimo();
      hebra.setMatrices(matrices);
      break;
    case DIVISION:
      hebra = new HebraDivision();
      hebra.setMatrices(matrices);
      break;
    case COINCIDENCIAEXACTA:
      hebra = new HebraCoincidenciaExacta();
      hebra.setMatrices(matrices);
      break;
    }
    return hebra;
  }
}