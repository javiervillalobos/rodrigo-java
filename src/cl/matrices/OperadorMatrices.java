package cl.matrices;

import java.lang.Thread.State;
import java.util.Random;

import cl.matrices.Hebra.TIPO;

public class OperadorMatrices {

  private Matriz[] matrices = null;
  private static int CANTIDAD_HEBRAS_COINCIDENCIA = 10;
  private FactoriaHebras factoriaHebras = new FactoriaHebras();
  private Hebra[] hebrasCoincidencia = null;
  private ZonaMatriz[] zonas = null;

  private ZonaMatriz[] obtieneZonasMatricesCoincidencia(Matriz[] matrices) {
    ZonaMatriz[] zonas = null;
    int totalFilasPorMatriz = matrices[0].getDimension();
    int totalColumnasPorMatriz = totalFilasPorMatriz;
    int totalMatrices = matrices.length;
    int totalDeHilosPorMatriz = CANTIDAD_HEBRAS_COINCIDENCIA / totalMatrices;
    if (totalDeHilosPorMatriz == totalFilasPorMatriz) {
      zonas = new ZonaMatriz[CANTIDAD_HEBRAS_COINCIDENCIA];
      int indiceZona = 0; 
      for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
        for (int fila = 0; fila < totalFilasPorMatriz; fila++) {
          int filaInicio = fila + 1;
          int filaTermino = fila + 1;
          int columnaInicio = 1;
          int columnaTermino = totalColumnasPorMatriz;
          int[] indicesMatrices = {indiceMatriz};
          ZonaMatriz zona = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino, indicesMatrices);
          zonas[indiceZona] = zona;
          indiceZona++;
        }
      }
    }
    return zonas;
  }

  private Hebra[] obtieneHebrasCoincidencia(Matriz[] matrices) {
    Hebra[] hebras = new Hebra[CANTIDAD_HEBRAS_COINCIDENCIA];
    for (int indice = 0; indice < CANTIDAD_HEBRAS_COINCIDENCIA; indice++) {
      synchronized (hebras) {
        hebras[indice] = factoriaHebras.crearHebra(TIPO.COINCIDENCIA, matrices);
      }
    }
    return hebras;
  }

  public int[] buscarCoincidencias(int valorABuscar, Matriz[] matrices) {
    int[] resultados = new int[matrices.length];
    if (hebrasCoincidencia == null) {
      hebrasCoincidencia = obtieneHebrasCoincidencia(matrices);
      zonas = obtieneZonasMatricesCoincidencia(matrices);
      for (int indice = 0; indice < hebrasCoincidencia.length; indice++) {
        hebrasCoincidencia[indice].asignarAreaOperacion(zonas[indice]);
        HebraCoincidencia hebra = (HebraCoincidencia) hebrasCoincidencia[indice];
        hebra.setValorABuscar(valorABuscar);
        hebra.start();
      }
    }
            
    synchronized (hebrasCoincidencia) {
      boolean busquedaRealizada = false;
      int hebrasEjecutadas = 0;
      int cantidadHebras = hebrasCoincidencia.length;
      while (!busquedaRealizada) {
        for (int indice = 0; indice < cantidadHebras; indice++) {
          HebraCoincidencia hebra = (HebraCoincidencia) hebrasCoincidencia[indice];
          State estadoHebra = hebra.getState();
          if (estadoHebra == State.TERMINATED && hebra.fueUsada()) {
            int resultado = hebra.getResultado();
            ZonaMatriz zonaMatriz = zonas[indice];
            for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
              if (zonaMatriz.considerarMatriz(indiceMatriz)) {
                resultados[indiceMatriz] += resultado;
              }
            }
            hebrasEjecutadas++;
          }
        }
        busquedaRealizada = (hebrasEjecutadas == cantidadHebras);
      }
    }

    return resultados;
  }

  public void crearMatrices(int dimension) {
    int cantidadDeMatrices = 2;
    int maximoNumero = 9;
    matrices = new Matriz[cantidadDeMatrices];
    String[] nombreMatrices = {"A", "B"};
    Random generadorNumeros = new Random(System.currentTimeMillis());
    for (int indice = 0; indice < cantidadDeMatrices; indice++) {
      matrices[indice] = new Matriz(nombreMatrices[indice], dimension);
      for (int fila = 1; fila <= dimension; fila++) {
        for (int columna = 1; columna <= dimension; columna++) {
          int valor = generadorNumeros.nextInt(maximoNumero) + 1;
          matrices[indice].agregarValor(fila, columna, valor);
        }
      }
    }
    hebrasCoincidencia = null;
  }

  public Matriz[] getMatrices() {
    return matrices;
  }

}