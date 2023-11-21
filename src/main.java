import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int op;
        int ID;
        ArrayList<Jugador> lista_jugadores = new ArrayList<>();

        System.out.print("¿Cuántos jugadores van a ser?: ");
        op = scanner.nextInt();

        for (int i = 0; i < op; i++) {
            // Cambié Jugador a una clase concreta que extiende Jugador
            Jugador J1 = new Jugador();

            System.out.print("Introduce el nombre: ");
            nombre = scanner.next();
            J1.setNombre(nombre);
            System.out.print("Introduce el ID (4 números enteros): ");
            ID = scanner.nextInt();
            J1.setID(ID);
            J1.Seleccionar_heroe();
            String heroe_seleccionado = J1.getEleccion_heroe();

            if (heroe_seleccionado.equals("Valquiria")) {
                System.out.println("¡Bienvenido al juego " + J1.getNombre() + ", eres una " + heroe_seleccionado + "!");
            } else {
                System.out.println("¡Bienvenido al juego " + J1.getNombre() + ", eres un " + heroe_seleccionado + "!");
            }

            MecanicaJuego juego = new MecanicaJuego();
            juego.jugar(heroe_seleccionado);

            String resultado = juego.hasta_donde_llego_jugador();
            J1.setResultado(resultado);
            lista_jugadores.add(J1);
        }

        System.out.println("*******REGISTRO DE PARTIDA*******");
        for (Jugador jugador : lista_jugadores) {
            System.out.println("Nombre: " + jugador.getNombre());
            System.out.println("ID: " + jugador.getID());
            System.out.println("Resultado: " + jugador.getResultado() + "\n");
        }
    }
}
