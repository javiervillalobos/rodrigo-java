package cl.matrices;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Aplicacion {

  public int preguntaNumerica(Scanner consola, String pregunta) {
    System.out.println(pregunta);
    while (consola.hasNextLine()) {
      String respuesta = consola.nextLine();
      Pattern patronNumeros = Pattern.compile("^\\d+$");
      Matcher validador = patronNumeros.matcher(respuesta);
      boolean valido = validador.matches();
      if (valido) {
        return Integer.valueOf(respuesta);
      } else {
        return -1;
      }
    }
      
    return -1;
  }

  public boolean confirmarSalir(Scanner consola, String pregunta) {
    System.out.println(pregunta);
    while (consola.hasNextLine()) {
      String respuesta = consola.nextLine();
      Pattern patronNumeros = Pattern.compile("^[sSnN]{1}$");
      Matcher validador = patronNumeros.matcher(respuesta);
      boolean valido = validador.matches();
      if (valido) {
        return true;
      } else {
        return false;
      }
    }
      
    return false;
  }

  public static void main(String[] args) {
    Menu menu = new Menu();
    Aplicacion aplicacion = new Aplicacion();
    OperadorMatrices operadorMatrices = new OperadorMatrices();
    System.out.println(menu.mostrar());

    Scanner consola = new Scanner(System.in);
    boolean salir = false;
    int dimension = 0;
    while (!salir) {
      int opcion = aplicacion.preguntaNumerica(consola, "Elija una opción: ");
      if (opcion != -1) {
        switch(opcion) {
          case 5: 
            boolean confirmar = aplicacion.confirmarSalir(consola, menu.obtenerPregunta(opcion));
            if (confirmar) {
              salir = true;
            } else {
              System.out.println(menu.mostrar());
            }
            break;
          case 1:
            dimension = aplicacion.preguntaNumerica(consola, menu.obtenerPregunta(opcion));
            if (dimension > 1) {
              operadorMatrices.crearMatrices(dimension);
              System.out.println("Las 2 matrices de dimensión " + dimension + " han sido creadas");
              Matriz[] matrices = operadorMatrices.getMatrices();
              for (int indice = 0; indice < matrices.length; indice++) {
                Matriz matriz = matrices[indice];
                System.out.println("\nMatriz " + matriz.getNombre());
                System.out.println(matriz.mostrar());
              }
              System.out.println("\n" + menu.mostrar());
            } else {
              System.out.println("Ingrese un valor numérico mayor o igual a 2");
              System.out.println(menu.mostrar());
            }
            break;
          case 2:
            int valor = aplicacion.preguntaNumerica(consola, menu.obtenerPregunta(opcion));
            if (valor > 0 && valor < 10) {
              if ((operadorMatrices.getMatrices() == null)) {
                System.out.println("Aún no han sido creadas las matrices. Ingrese a opción 1");
                System.out.println(menu.mostrar());
              } else {
                int[] resultado = operadorMatrices.buscarCoincidencias(valor, operadorMatrices.getMatrices());
                Matriz[] matrices = operadorMatrices.getMatrices();
                StringBuilder respuesta = new StringBuilder();
                int penultimo = matrices.length - 1;
                for (int indice = 0; indice < matrices.length; indice++) {
                  Matriz matriz = matrices[indice];
                  respuesta.append("Matriz ").append(matriz.getNombre()).append(" = ")
                    .append(resultado[indice]).append(" valores igual a " + valor).append(indice < penultimo ? " vs ": "");
                }
                System.out.println("\nResultado: " + respuesta + "\n");
                System.out.println(menu.mostrar());
              }
            } else {
              System.out.println("Ingrese un valor numérico mayor o igual a 2");
              System.out.println(menu.mostrar());
            }
            break;
          case 3:
            if ((operadorMatrices.getMatrices() == null)) {
              System.out.println("Aún no han sido creadas las matrices. Ingrese a opción 1");
              System.out.println(menu.mostrar());
            } else {
              Matriz[] matrices = operadorMatrices.getMatrices();
              operadorMatrices.operaNumerosPrimos(matrices);
              matrices = operadorMatrices.getMatrices();
              System.out.println("Matrices transformadas:");
              for (int indice = 0; indice < matrices.length; indice++) {
                Matriz matriz = matrices[indice];
                System.out.println("\nMatriz " + matriz.getNombre());
                System.out.println(matriz.mostrar());
              }
              valor = 1;
              int[] resultado = operadorMatrices.buscarCoincidencias(valor, operadorMatrices.getMatrices());
              StringBuilder respuesta = new StringBuilder();
              int penultimo = matrices.length - 1;
              for (int indice = 0; indice < matrices.length; indice++) {
                Matriz matriz = matrices[indice];
                respuesta.append("Matriz ").append(matriz.getNombre()).append(" = ")
                  .append(resultado[indice]).append(" valores igual a " + valor).append(indice < penultimo ? " vs ": "");
              }
              System.out.println("\nResultado: " + respuesta + "\n");
              System.out.println(menu.mostrar());
            }
            break;
          case 4:
            if ((operadorMatrices.getMatrices() == null)) {
              System.out.println("Aún no han sido creadas las matrices. Ingrese a opción 1");
              System.out.println(menu.mostrar());
            } else {
              dimension = operadorMatrices.getMatrices()[0].getDimension();
              int[][] resultado = operadorMatrices.buscarCoincidenciasExactas(operadorMatrices.getMatrices());
              StringBuilder sb = new StringBuilder("Resultados:\n");
              for (int i = 0; i < dimension; i++) {
                for (int j = 0; j < dimension; j++) {
                  valor = resultado[i][j];
                  if (valor > 0) {
                    sb.append("\t");
                    for (int indice = 0; indice < operadorMatrices.getMatrices().length; indice++) {
                      Matriz matriz = operadorMatrices.getMatrices()[indice];
                      sb.append("Matriz").append(matriz.getNombre()).append("[")
                        .append(i + 1).append(", ").append(j + 1).append("]").append("=").append(valor)
                        .append(indice < operadorMatrices.getMatrices().length - 1 ? " y " : "");
                    }
                    sb.append("\n");
                  }
                }
              }

              System.out.println(sb.toString() + "\n");
              System.out.println(menu.mostrar());
            }
            break;
        }
      } else {
        System.out.println("La respuesta indicada no es válida\n");
        System.out.println(menu.mostrar());
      }
    }
    consola.close();

  }
}