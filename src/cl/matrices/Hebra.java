package cl.matrices;

public abstract class Hebra extends Thread {

  public static enum TIPO {
    COINCIDENCIA;
  }

  protected Matriz[] matrices;
  protected ZonaMatriz zonaMatriz;
  protected boolean usada = false;

  public void setMatrices(Matriz[] matrices) {
    this.matrices = matrices;
  }

  public void asignarAreaOperacion(ZonaMatriz zonaMatriz) {
    this.zonaMatriz = zonaMatriz;
  }

  public int obtenerCantidadMatrices() {
    return matrices.length;
  }

  public boolean fueUsada() {
    return usada;
  }

  @Override
  public abstract void run();

}