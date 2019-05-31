package cl.rodrigo;

public class Persona extends Thread {

  private int edad;
  private double estatura;
  private String nombre;
  private Persona hermana;

  public Persona(String nombrePersona, int edadPersona, double estaturaPersona) {
    this.edad =  edadPersona;
    this.estatura = estaturaPersona;
    this.nombre = nombrePersona;
  }

  public void agregarHermana(Persona hermana) {
    this.hermana = hermana;
  }

  public String caminar(int pasos) {
    return "Hola, ya caminé " + pasos + " pasos";
  }

  public String obtenerDatos() {
    String respuesta = "Hola, soy " + this.nombre + ", mido " + this.estatura + ", tengo " + edad + " años";
    if (this.hermana != null) {
      respuesta = "Hola, soy " + this.nombre + ", mido " + this.estatura + ", tengo " + edad + " años y mi hermana se llama " + hermana.nombre;
    }
    return respuesta;
  }

  public void mostrarDatos() {
    System.out.println(this.obtenerDatos());
  }

  @Override
  public void run() {
    mostrarDatos();
  }
}