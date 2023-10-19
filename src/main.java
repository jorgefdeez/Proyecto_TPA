import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int ID;
        Jugador J1 = new Jugador();
        System.out.print("Intro el nombre: ");
        nombre = scanner.next();
        J1.setNombre(nombre);
        System.out.print("Introdcue el ID(4 numeros enteros): ");
        ID = scanner.nextInt();
        J1.setID(ID);
        System.out.println("Bienvenido al juego " + J1.getNombre() + "!");
        MecanicaJuego juego = new MecanicaJuego();
        juego.jugar();
        /*
        System.out.println("Que heroe quieres usar? (Valquiria, Barbaro, Mago)");
        int eleccion = scanner.nextInt();
        switch (eleccion){
            case 1:
            {
                Valquiria V1;
                System.out.print("Bienvenido al juego " + J1.getNombre() + "!");
                MecanicaJuego juego = new MecanicaJuego();
                juego.jugar();
            }
            case 2:
            {
                Barbaro B1;
                System.out.print("Bienvenido al juego " + J1.getNombre() + "!");
                MecanicaJuego juego = new MecanicaJuego();
                juego.jugar();
            }
            case 3:
            {
                Mago M1;
                System.out.print("Bienvenido al juego " + J1.getNombre() + "!");
                MecanicaJuego juego = new MecanicaJuego();
                juego.jugar();
            }
            default:
                System.out.println("Opcion invalida...");
                break;
        }
        */




    }
}