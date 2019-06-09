package cl.matrices;

public class ZonaMatriz {

  private int filaInicio = 0;
  private int filaTermino = 0;
  private int columnaInicio = 0;
  private int columnaTermino = 0;
  private int[] indicesMatrices = null;

  public int getFilaInicio() {
    return filaInicio;
  }

  public void setFilaInicio(int filaInicio) {
    this.filaInicio = filaInicio;
  }

  public int getFilaTermino() {
    return filaTermino;
  }

  public void setFilaTermino(int filaTermino) {
    this.filaTermino = filaTermino;
  }

  public int getColumnaInicio() {
    return columnaInicio;
  }

  public void setColumnaInicio(int columnaInicio) {
    this.columnaInicio = columnaInicio;
  }

  public int getColumnaTermino() {
    return columnaTermino;
  }

  public void setColumnaTermino(int columnaTermino) {
    this.columnaTermino = columnaTermino;
  } 

  public ZonaMatriz(int filaInicio, int columnaInicio, int filaTermino, int columnaTermino) {
    this.filaInicio = filaInicio;
    this.filaTermino = filaTermino;
    this.columnaInicio = columnaInicio;
    this.columnaTermino = columnaTermino;
  }

  public ZonaMatriz(int filaInicio, int columnaInicio, int filaTermino, int columnaTermino, int[] indicesMatrices) {
    this.filaInicio = filaInicio;
    this.filaTermino = filaTermino;
    this.columnaInicio = columnaInicio;
    this.columnaTermino = columnaTermino;
    this.indicesMatrices = indicesMatrices;
  }

  public int[] getindicesMatrices() {
    return indicesMatrices;
  }

  public void setIndicesMatrices(int[] indicesMatrices) {
    this.indicesMatrices = indicesMatrices;
  }

  public boolean considerarMatriz(int indiceMatriz) {
    if (indicesMatrices == null) {
      return true;
    }
    for (int indice = 0; indice < indicesMatrices.length; indice++) {
      if (indicesMatrices[indice] == indiceMatriz) {
        return true;
      }
    }
    return false;
  }
}