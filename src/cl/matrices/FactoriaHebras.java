package cl.matrices;

import cl.matrices.Hebra.TIPO;

public class FactoriaHebras {

  public FactoriaHebras() {
  }

	public Hebra crearHebra(TIPO tipoHebra, Matriz[] matrices) {
		switch (tipoHebra) {
      case COINCIDENCIA:
        Hebra hebra = new HebraCoincidencia();
        hebra.setMatrices(matrices);
        return hebra;
    }
    return null;
  }
}