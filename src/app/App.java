package app;

import java.util.Scanner;
import cl.matrices.Matriz;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Ingrese dimension de la matriz:");
        Scanner scanner = new Scanner(System.in);
        int dimension = Integer.valueOf(scanner.nextLine());
        Matriz matriz = new Matriz(dimension);
        matriz.llenarContinuo();
        System.out.println(matriz);
        scanner.close();
    }
}