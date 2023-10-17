import java.util.Random;
import java.util.Scanner;

public class MecanicaJuego {
    private int saludJugador;    //cuando tengamos los 3 heroes, estas variables iran en otra clases(Barbaro, Mago, Valquiria) y cada heroe tendra una vida, un ataque y unas habilidades distintas.
    private int saludEnemigo;   //en enemigo sera igual
    private Random random;
    private Scanner scanner;
    private boolean ataqueEspecialDisponible = true;

    public MecanicaJuego() {
        saludJugador = 100;
        saludEnemigo = 100;
        random = new Random();
        scanner = new Scanner(System.in);
    }

    public void jugar() {
        System.out.println("Bienvenido al juego!");

        while (saludJugador > 0 && saludEnemigo > 0) {
            System.out.println("\nTu salud: " + saludJugador);
            System.out.println("Salud del enemigo: " + saludEnemigo);
            System.out.println("1. Ataque normal (15 de daño)");
            System.out.println("2. Ataque especial (35 de daño y solo un uso)");
            System.out.println("Elige tu acción:");


            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion){
                case 1:
                {
                    // Ataque normal
                    int ataqueJugador = 15;
                    saludEnemigo = saludEnemigo - ataqueJugador;
                    System.out.println("Has atacado al enemigo y le has hecho " + ataqueJugador + " puntos de daño.");
                    break;
                }
                case 2: {
                    // Ataque especial
                    if(ataqueEspecialDisponible){
                        int ataqueEspecialJugador = 35;
                        saludEnemigo = saludEnemigo - ataqueEspecialJugador;
                        System.out.println("Has realizado un ataque especial y le has hecho " + ataqueEspecialJugador + " puntos de daño.");
                        ataqueEspecialDisponible = false;
                    }else{
                        System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                        int ataqueJugador = random.nextInt(21);
                        saludEnemigo -= ataqueJugador;
                        System.out.println("Has atacado al enemigo y le has hecho " + ataqueJugador + " puntos de daño.");
                    }
                    break;
                }
                default: {
                    System.out.println("Opcion invalida...");
                    int ataqueJugador = random.nextInt(21);
                    saludEnemigo = saludEnemigo - ataqueJugador;
                    System.out.println("Has atacado al enemigo y le has hecho " + ataqueJugador + " puntos de daño.");
                    break;
                }
            }
            // verificar si el enemigo está derrotado
            if (saludEnemigo <= 0) {
                System.out.println("Has derrotado al enemigo! Has ganado!");
                break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
            }

            // Turno del enemigo
            int ataqueEnemigo = random.nextInt(10)+20; // Ataque aleatorio entre 0 y 20
            saludJugador = saludJugador - ataqueEnemigo;
            System.out.println("El enemigo te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");

            // verificar si el jugador está derrotado
            if (saludJugador <= 0) {
                System.out.println("El enemigo te ha derrotado! Has perdido!");
            }
        }
    }
}


