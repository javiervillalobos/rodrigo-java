package cl.matrices;

import java.util.Arrays;

public class HebraPrimo extends Hebra {

  private int[][] numerosPrimos;

  public HebraPrimo(Matriz[] matrices) {
    setMatrices(matrices);
  }

  public HebraPrimo() {
  }

  public boolean esPrimo(int numero) {
    if (numero == 1) {
      return true;
    }
    int validador = 2;
    boolean esPrimo = true;
    while (validador <= numero) {
      int resto = numero % validador;
      if (resto == 0 && numero != validador) {
        esPrimo = false;
        break;
      }
      validador++;
    }
    return esPrimo;
  }

  public int[][] obtenerNumerosPrimos() {
    return numerosPrimos;
  }

  private boolean existeValor(int[] valores, int valor) {
    for (int indice = 0; indice < valores.length; indice++) {
      if (valores[indice] == valor) {
        return true;
      } else if (valores[indice] == 0) {
        return false;
      }
    }
    return false;
  }

  public void buscar() {
    int cantidadMatrices = obtenerCantidadMatrices();
    int[][] numerosHallados = new int[cantidadMatrices][];
    int[] halladosMatriz = null;

    for (int indiceMatriz = 0; indiceMatriz < cantidadMatrices; indiceMatriz++) {
      Matriz matriz = matrices[indiceMatriz];
      if (zonaMatriz == null) {
        zonaMatriz = new ZonaMatriz(1, 1, matriz.getDimension(), matriz.getDimension());
      }

      if (!zonaMatriz.considerarMatriz(indiceMatriz)) {
        continue;
      }

      int hallados = 0;
      int dimension = matrices[indiceMatriz].getDimension();
      halladosMatriz = new int[dimension * dimension];
      for (int fila = zonaMatriz.getFilaInicio(); fila <= zonaMatriz.getFilaTermino(); fila++) {
        for (int columna = zonaMatriz.getColumnaInicio(); columna <= zonaMatriz.getColumnaTermino(); columna++) {
          int valorMatriz = matriz.obtenerValor(fila, columna);
          if (esPrimo(valorMatriz) && !existeValor(halladosMatriz, valorMatriz)) {
            halladosMatriz[hallados] = valorMatriz;
            hallados++;
          }
        }
      }

      if (hallados > 0) {
        int topeCantidadPrimos = 3;
        int[] primos = new int[hallados > topeCantidadPrimos ? topeCantidadPrimos : hallados];
        int indicePrimos = 0;
        Arrays.sort(halladosMatriz);
        for (int indice = 0; indice < halladosMatriz.length; indice++) {
          if (halladosMatriz[indice] > 0) {
            primos[indicePrimos] = halladosMatriz[indice];
            indicePrimos++;
            if (indicePrimos == primos.length) {
              break;
            }
          }
        }
        numerosHallados[indiceMatriz] = primos;
      }
    }

    numerosPrimos = numerosHallados;
  }

  private void imprimeNumerosPrimos() {
    StringBuilder sb = new StringBuilder("Hebra " + this.toString() + "\n");
    for (int i = 0; i < matrices.length; i++) {
      sb.append("\t").append("matriz[" + i  + "] => ");
      int[] numeros = numerosPrimos[i];
      if (numeros != null) {
        for (int j = 0; j < numeros.length; j++) {
          sb.append(numeros[j]).append(j < numeros.length - 1 ? ", " : "");
        }
      } else {
        sb.append("null");
      }
      sb.append("\n");
    }
    sb.append("\n");
    System.out.println(sb.toString());
  }


  @Override
  public void run() {
    buscar();
    usada = true;
  }

}