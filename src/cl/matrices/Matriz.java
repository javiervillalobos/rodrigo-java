package cl.matrices;

public class Matriz {

  private int[][] contenido;
  private int dimension = 0;
  private String nombre = null;

  public Matriz(String nombre, int dimension) {
    this(dimension);
    this.nombre = nombre;
  }

  public Matriz(int dimension) {
    contenido = new int[dimension][dimension];
    this.dimension = dimension;
  }

  public int obtenerValor(int fila, int columna) {
    int colIndex = columna - 1;
    int rowIndex = fila - 1;
    return contenido[rowIndex][colIndex];
  }

  public String mostrar() {
    String result = null;
    StringBuilder sb = new StringBuilder();
    int penultimaPosicion = dimension - 1;
    for (int row = 0; row < dimension; row++) {
      sb.append("|");
      for (int col = 0; col < dimension; col++) {
        int valor = contenido[row][col];
        sb.append(valor);
        if (col < penultimaPosicion) {
          sb.append(" ");
        }
      }
      sb.append("|").append(row < penultimaPosicion ? "\n" : "");
    }
    result = sb.toString();
    return result;
  }

  public void agregarValor(int fila, int columna, int valor) {
    int colIndex = columna - 1;
    int rowIndex = fila - 1;
    contenido[rowIndex][colIndex] = valor;
  }

  public int getDimension() {
    return dimension;
  }

  public String getNombre() {
    return nombre;
  }
}