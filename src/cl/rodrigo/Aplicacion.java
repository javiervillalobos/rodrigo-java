package cl.rodrigo;

public class Aplicacion {

  public static void main(String[] args) {

    Persona[] personas = new Persona[100];
    for (int i = 0; i < 100; i++) {
      String nombre = "persona" + i;
      int edad = (i + 1) * 10;
      double estatura = 1 + 0.15*i;
      Persona persona = new Persona(nombre, edad, estatura);
      persona.agregarHermana(new Persona("Loca", 10, 1.80));
      personas[i] = persona;
    }
    
    for (int i = 0; i < 100; i++) {
      personas[i].start();
    }
  }
}