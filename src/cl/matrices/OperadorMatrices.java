package cl.matrices;

import java.lang.Thread.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import cl.matrices.Hebra.TIPO;

public class OperadorMatrices {

  private Matriz[] matrices = null;
  private static int CANTIDAD_HEBRAS_COINCIDENCIA = 10;
  private static int CANTIDAD_HEBRAS_PRIMOS = 10;
  private static int CANTIDAD_HEBRAS_DIVISION = 10;
  private FactoriaHebras factoriaHebras = new FactoriaHebras();
  private Hebra[] hebrasCoincidencia = null;
  private Hebra[] hebrasPrimos = null;
  private Hebra[] hebrasDivision = null;
  private ZonaMatriz[] zonasCoincidencias = null;
  private ZonaMatriz[] zonasPrimos = null;
  private ZonaMatriz[] zonasDivision = null;
  private int[][] numerosPrimos = null;

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
          int[] indicesMatrices = { indiceMatriz };
          ZonaMatriz zona = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino, indicesMatrices);
          zonas[indiceZona] = zona;
          indiceZona++;
        }
      }
    }
    return zonas;
  }

  private ZonaMatriz[] obtieneZonasMatricesCoincidenciaExacta(Matriz[] matrices) {
    int dimension = matrices[0].getDimension();
    ZonaMatriz[] zonas = new ZonaMatriz[dimension*dimension];
    int indiceZona = 0;
    for (int fila = 1; fila <= dimension; fila++) {
      for (int columna = 1; columna <= dimension; columna++) {
        ZonaMatriz zona = new ZonaMatriz(fila, columna, fila, columna);
        zonas[indiceZona] = zona;
        indiceZona++;
      }
    }
    return zonas;
  }

  private ZonaMatriz[] obtieneZonasMatricesPrimos(Matriz[] matrices) {
    ZonaMatriz[] zonas = null;
    int totalFilasPorMatriz = matrices[0].getDimension();
    int totalColumnasPorMatriz = totalFilasPorMatriz;
    int totalMatrices = matrices.length;
    int totalDeHilosPorMatriz = CANTIDAD_HEBRAS_PRIMOS / totalMatrices;
    if (totalDeHilosPorMatriz == totalFilasPorMatriz) {
      zonas = new ZonaMatriz[CANTIDAD_HEBRAS_PRIMOS];
      int indiceZona = 0;
      for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
        for (int fila = 0; fila < totalFilasPorMatriz; fila++) {
          int filaInicio = fila + 1;
          int filaTermino = fila + 1;
          int columnaInicio = 1;
          int columnaTermino = totalColumnasPorMatriz;
          int[] indicesMatrices = { indiceMatriz };
          ZonaMatriz zona = new ZonaMatriz(filaInicio, columnaInicio, filaTermino, columnaTermino, indicesMatrices);
          zonas[indiceZona] = zona;
          indiceZona++;
        }
      }
    }
    return zonas;
  }

  private ZonaMatriz[] obtieneZonasMatricesDivision(Matriz[] matrices) {
    ZonaMatriz[] zonas = null;
    int totalFilasPorMatriz = matrices[0].getDimension();
    int totalColumnasPorMatriz = totalFilasPorMatriz;
    int totalMatrices = matrices.length;
    int totalDeHilosPorMatriz = CANTIDAD_HEBRAS_DIVISION / totalMatrices;
    if (totalDeHilosPorMatriz == totalFilasPorMatriz) {
      zonas = new ZonaMatriz[CANTIDAD_HEBRAS_DIVISION];
      int indiceZona = 0;
      for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
        for (int fila = 0; fila < totalFilasPorMatriz; fila++) {
          int filaInicio = fila + 1;
          int filaTermino = fila + 1;
          int columnaInicio = 1;
          int columnaTermino = totalColumnasPorMatriz;
          int[] indicesMatrices = { indiceMatriz };
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

  private Hebra[] obtieneHebrasCoincidenciaExacta(Matriz[] matrices) {
    int dimension = matrices[0].getDimension();
    Hebra[] hebras = new Hebra[dimension*dimension];
    for (int indice = 0; indice < dimension*dimension; indice++) {
      synchronized (hebras) {
        hebras[indice] = factoriaHebras.crearHebra(TIPO.COINCIDENCIAEXACTA, matrices);
      }
    }
    return hebras;
  }

  private Hebra[] obtieneHebrasPrimos(Matriz[] matrices) {
    Hebra[] hebras = new Hebra[CANTIDAD_HEBRAS_PRIMOS];
    for (int indice = 0; indice < CANTIDAD_HEBRAS_PRIMOS; indice++) {
      synchronized (hebras) {
        hebras[indice] = factoriaHebras.crearHebra(TIPO.PRIMO, matrices);
      }
    }
    return hebras;
  }

  private Hebra[] obtieneHebrasDivision(Matriz[] matrices) {
    Hebra[] hebras = new Hebra[CANTIDAD_HEBRAS_DIVISION];
    for (int indice = 0; indice < CANTIDAD_HEBRAS_DIVISION; indice++) {
      synchronized (hebras) {
        hebras[indice] = factoriaHebras.crearHebra(TIPO.DIVISION, matrices);
      }
    }
    return hebras;
  }

  public int[] buscarCoincidencias(int valorABuscar, Matriz[] matrices) {
    int[] resultados = new int[matrices.length];
    hebrasCoincidencia = obtieneHebrasCoincidencia(matrices);
    zonasCoincidencias = obtieneZonasMatricesCoincidencia(matrices);
    for (int indice = 0; indice < hebrasCoincidencia.length; indice++) {
      hebrasCoincidencia[indice].asignarAreaOperacion(zonasCoincidencias[indice]);
      HebraCoincidencia hebra = (HebraCoincidencia) hebrasCoincidencia[indice];
      hebra.setValorABuscar(valorABuscar);
      hebra.start();
    }

    synchronized (hebrasCoincidencia) {
      boolean busquedaRealizada = false;
      int cantidadHebras = hebrasCoincidencia.length;
      int[][] resultadosPorHebra = new int[matrices.length][cantidadHebras];
      while (!busquedaRealizada) {
        int hebrasEjecutadas = 0;
        for (int indice = 0; indice < cantidadHebras; indice++) {
          HebraCoincidencia hebra = (HebraCoincidencia) hebrasCoincidencia[indice];
          State estadoHebra = hebra.getState();
          if (estadoHebra == State.TERMINATED && hebra.fueUsada()) {
            int resultado = hebra.getResultado();
            ZonaMatriz zonaMatriz = zonasCoincidencias[indice];
            for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
              if (zonaMatriz.considerarMatriz(indiceMatriz)) {
                resultadosPorHebra[indiceMatriz][indice] = resultado;
              }
            }
            hebrasEjecutadas++;
          }
        }
        busquedaRealizada = (hebrasEjecutadas == cantidadHebras);
      }

      for (int indiceMatriz = 0; indiceMatriz < matrices.length; indiceMatriz++) {
        int[] resultado = resultadosPorHebra[indiceMatriz];
        for (int indiceResultado = 0; indiceResultado < resultado.length; indiceResultado++) {
          int valor = resultado[indiceResultado];
          resultados[indiceMatriz] += valor;
        }
      }

    }

    return resultados;
  }

  public void crearMatrices(int dimension) {
    int cantidadDeMatrices = 2;
    int maximoNumero = 9;
    matrices = new Matriz[cantidadDeMatrices];
    String[] nombreMatrices = { "A", "B" };
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

  private void mergePrimos(Map<Integer, int[][]> primos) {
    synchronized (numerosPrimos) {
      for (int indice = 0; indice < numerosPrimos.length; indice++) {
        Set<Integer> primosList = new TreeSet<>();
        for (Integer indiceHebra : primos.keySet()) {
          int[][] buffer = primos.get(indiceHebra);
          if (buffer[indice] != null) {
            for (int i = 0; i < buffer[indice].length; i++) {
              int valor = buffer[indice][i];
              if (valor > 0) {
                primosList.add(valor);
              }
            }
          }
        }
        if (primosList.size() > 3) {
          Set<Integer> tresPrimos = new HashSet<>();
          Iterator<Integer> iter = primosList.iterator();
          int indiceIter = 0;
          while (iter.hasNext() && indiceIter < 3) {
            tresPrimos.add(iter.next());
            indiceIter++;
          }
          primosList = tresPrimos;
        }
        Integer[] valores = (Integer[]) primosList.toArray(new Integer[0]);
        int[] valoresInt = new int[valores.length];
        for (int i = 0; i < valoresInt.length; i++) {
          valoresInt[i] = valores[i];
        }
        numerosPrimos[indice] = valoresInt;
      }
    }
  }

  private synchronized void esperaPorHebrasPrimos() {
    boolean busquedaRealizada = false;
    int cantidadHebras = hebrasPrimos.length;
    Map<Integer, int[][]> resultados = new HashMap<>();
    while (!busquedaRealizada) {
      int hebrasEjecutadas = 0;
      for (int indice = 0; indice < cantidadHebras; indice++) {
        HebraPrimo hebra = (HebraPrimo) hebrasPrimos[indice];
        State estadoHebra = hebra.getState();
        if (estadoHebra == State.TERMINATED && hebra.fueUsada()) {
          int[][] resultado = hebra.obtenerNumerosPrimos();
          resultados.put(indice, resultado);
          hebrasEjecutadas++;
        }
      }
      busquedaRealizada = (hebrasEjecutadas == cantidadHebras);
    }

    mergePrimos(resultados);
  }

  private synchronized void esperaPorHebrasDivision() {
    boolean transformacionRealizada = false;
    int cantidadHebras = hebrasDivision.length;
    while (!transformacionRealizada) {
      int hebrasEjecutadas = 0;
      for (int indice = 0; indice < cantidadHebras; indice++) {
        HebraDivision hebra = (HebraDivision) hebrasDivision[indice];
        State estadoHebra = hebra.getState();
        if (estadoHebra == State.TERMINATED && hebra.fueUsada()) {
          hebrasEjecutadas++;
        }
      }
      transformacionRealizada = (hebrasEjecutadas == cantidadHebras);
    }
  }

  public void operaNumerosPrimos(Matriz[] matrices) {
    numerosPrimos = new int[matrices.length][];
    hebrasPrimos = obtieneHebrasPrimos(matrices);
    zonasPrimos = obtieneZonasMatricesPrimos(matrices);
    for (int indice = 0; indice < hebrasPrimos.length; indice++) {
      hebrasPrimos[indice].asignarAreaOperacion(zonasPrimos[indice]);
      HebraPrimo hebra = (HebraPrimo) hebrasPrimos[indice];
      hebra.start();
    }

    esperaPorHebrasPrimos();

    hebrasDivision = obtieneHebrasDivision(matrices);
    zonasDivision = obtieneZonasMatricesDivision(matrices);
    for (int indice = 0; indice < hebrasDivision.length; indice++) {
      hebrasDivision[indice].asignarAreaOperacion(zonasDivision[indice]);
      HebraDivision hebra = (HebraDivision) hebrasDivision[indice];
      hebra.asignarNumerosPrimos(numerosPrimos);
      hebra.start();
    }

    esperaPorHebrasDivision();

  }

  public int[][] buscarCoincidenciasExactas(Matriz[] matrices) {
    int dimension = matrices[0].getDimension();
    int[][] resultados = new int[dimension][dimension];
    hebrasCoincidencia = obtieneHebrasCoincidenciaExacta(matrices);
    zonasCoincidencias = obtieneZonasMatricesCoincidenciaExacta(matrices);
    for (int indice = 0; indice < hebrasCoincidencia.length; indice++) {
      hebrasCoincidencia[indice].asignarAreaOperacion(zonasCoincidencias[indice]);
      HebraCoincidenciaExacta hebra = (HebraCoincidenciaExacta) hebrasCoincidencia[indice];
      hebra.start();
    }

    synchronized (hebrasCoincidencia) {
      boolean busquedaRealizada = false;
      int cantidadHebras = hebrasCoincidencia.length;
      while (!busquedaRealizada) {
        int hebrasEjecutadas = 0;
        for (int indice = 0; indice < cantidadHebras; indice++) {
          HebraCoincidenciaExacta hebra = (HebraCoincidenciaExacta) hebrasCoincidencia[indice];
          State estadoHebra = hebra.getState();
          if (estadoHebra == State.TERMINATED && hebra.fueUsada()) {
            int[][] resultado = hebra.getResultado();
            for (int i = 0; i < dimension; i++) {
              for (int j = 0; j < dimension; j++) {
                int valor = resultado[i][j];
                if (valor > 0) {
                  resultados[i][j] = valor;
                }
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

}