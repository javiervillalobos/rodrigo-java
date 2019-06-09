package cl.matrices;

public class Menu {

  private String[] opciones;
  private String[] preguntas;

  public Menu() {
    opciones = new String[3];
    opciones[0] = "Crear matrices";
    opciones[1] = "Buscar coincidencias de un valor";
    opciones[2] = "Salir";

    preguntas = new String[3];
    preguntas[0] = "Ingrese dimensión de las matrices";
    preguntas[1] = "Ingrese valor a buscar";
    preguntas[2] = "¿Está seguro que desea salir? (S/N)";
  }

  public String mostrar() {
    StringBuilder sb = new StringBuilder();
    sb.append("\n");
    for (int opcion = 0; opcion < opciones.length; opcion++) {
      sb.append(opcion + 1).append(") ").append(opciones[opcion]).append("\n");
    }
    return sb.toString();
  }

  public String obtenerPregunta(int opcion) {
    return preguntas[opcion - 1];
  }


}