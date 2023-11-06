import java.util.Random;
import java.util.Scanner;

public class MecanicaJuego extends Jugador {
    private int saludJugador;    //cuando tengamos los 3 heroes, estas variables iran en otra clases(Barbaro, Mago, Valquiria) y cada heroe tendra una vida, un ataque y unas habilidades distintas.
    private int saludEnemigo;   //en enemigo sera igual
    private int defensaEnemigo;
    private int ataqueEnemigo;
    private int saludTotalEnemigo;
    private Scanner scanner;
    private boolean ataqueEspecialDisponible = true;
    private Random random = new Random();

    Esbirro E1 = new Esbirro();
    Gigante G1 = new Gigante();
    Dragon D1 = new Dragon();
    //Jugador J = new Jugador();  //la funcion boolean esta_eliminado debe depende de las clases Barbaro, Mago y Valquiria.
    public void jugar(String heroe_seleccionado) {

        switch (heroe_seleccionado){
            case "Barbaro":
                Barbaro B1 = new Barbaro();
                //implementar el codigo a partir del primer while cambiando las variables y metodos de jugador por las de barbaro
                break;
            case "Mago":
                Mago M1 = new Mago();
                //implementar el codigo a partir del primer while cambiando las variables y metodos de jugador por las de Mago
                break;
            case "Valquiria":
                Valquiria V1 = new Valquiria();
                //implementar el codigo a partir del primer while cambiando las variables y metodos de jugador por las de Valquiria

                break;
            default: break;
        }


        while (!E1.getSe_ha_eliminado() && !G1.getSe_ha_eliminado() && !D1.getSe_ha_eliminado() && !J.getEsta_eliminado()) {
            //ESBIRRO
            int contE = 1;
            if (contE == 1) {
                System.out.println("\nPRIMER NIVEL: ESBIRRO");
                System.out.println("Salud del Esbirro: " + E1.getVida_total() + "(Vida: " + E1.getVida() + " y Defensa: " + E1.getDefensa() + ")");
                contE++;
            }
            saludJugador = 100;
            saludEnemigo = E1.getVida_total();
            defensaEnemigo = E1.getDefensa();
            saludTotalEnemigo = E1.getVida_total();
            scanner = new Scanner(System.in);
            ataqueEnemigo = E1.getAtaque();

            while (saludJugador > 0 && E1.getVida_total() > 0) {
                System.out.println("\nTu salud: " + saludJugador);
                System.out.println("Vida total del Esbirro: " + E1.getVida_total());
                System.out.println("1. Ataque normal (20 de daño)");
                System.out.println("2. Ataque especial (35 de daño y solo un uso)");
                System.out.print("Elige tu acción:");

                int opcion = scanner.nextInt();
                scanner.nextLine();
                int ataqueJugador = 20;

                switch (opcion) {
                    case 1: {
                        // Ataque normal
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        E1.setVida_total(saludTotalEnemigo);
                        System.out.println("Has atacado al esbirro y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                    case 2: {
                        // Ataque especial
                        if (ataqueEspecialDisponible) {
                            int ataqueEspecialJugador = 35;
                            saludTotalEnemigo = saludTotalEnemigo - ataqueEspecialJugador;
                            E1.setVida_total(saludTotalEnemigo);
                            System.out.println("Has realizado un ataque especial al esbirro y le has hecho " + ataqueEspecialJugador + " puntos de daño.");
                            ataqueEspecialDisponible = false;
                        } else {
                            System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                            saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                            E1.setVida_total(saludTotalEnemigo);
                            System.out.println("Has atacado al esbirro y le has hecho " + ataqueJugador + " puntos de daño.");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida...");
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        E1.setVida_total(saludTotalEnemigo);
                        System.out.println("Has atacado al esbirro y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                }
                // verificar si el enemigo está derrotado
                if (E1.getVida_total() <= 0) {
                    E1.setSe_ha_eliminado(true);    //lo marcamos como eliminado.
                    break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                }

                // Turno del enemigo
                saludJugador = saludJugador - ataqueEnemigo;
                System.out.println("El esbirro te ha atacado y te ha hecho " + E1.getAtaque() + " puntos de daño.");

                // verificar si el jugador está derrotado
                if (saludJugador <= 0) {
                    J.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                }
            }
            if (E1.getSe_ha_eliminado()) {
                System.out.println("Has derrotado al esbirro!\n");
            }
            if (J.getEsta_eliminado()) {
                System.out.println("El Esbirro te ha derrotado. Has perdido:(\n");
                break;  // Sal del juego cuando el jugador es derrotado
            }

            //GIGANTE
            int contG = 1;
            if (contG == 1) {
                System.out.println("****SEGUNDO NIVEL: GIGANTE****");
                System.out.println("Salud del Gigante: " + G1.getVidaTotal() + "(Vida: " + G1.getVida() + " y Defensa: " + G1.getDefensa() + ")");
                contG++;
            }
            saludJugador = 100;
            saludEnemigo = G1.getVidaTotal();
            defensaEnemigo = G1.getDefensa();
            saludTotalEnemigo = G1.getVidaTotal();
            scanner = new Scanner(System.in);
            ataqueEnemigo = G1.getAtaque();
            ataqueEspecialDisponible = true; //nueva partida con todos los recursos del heroe disponible otra vez.
            int curacionGigante = G1.getCuracion();

            while (saludJugador > 0 && G1.getVidaTotal() > 0) {
                int eleccion_ataque_gigante = random.nextInt(2) + 1;

                System.out.println("\nTu salud: " + saludJugador);
                System.out.println("Vida total del Gigante: " + G1.getVidaTotal());
                System.out.println("1. Ataque normal (20 de daño)");
                System.out.println("2. Ataque especial (35 de daño y solo un uso)");
                System.out.print("Elige tu acción:");

                int opcion = scanner.nextInt();
                scanner.nextLine();
                int ataqueJugador = 20;

                switch (opcion) {
                    case 1: {
                        // Ataque normal
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        G1.setVidaTotal(saludTotalEnemigo);
                        System.out.println("Has atacado al Gigante y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                    case 2: {
                        // Ataque especial
                        if (ataqueEspecialDisponible) {
                            int ataqueEspecialJugador = 35;
                            saludTotalEnemigo = saludTotalEnemigo - ataqueEspecialJugador;
                            G1.setVidaTotal(saludTotalEnemigo);
                            System.out.println("Has realizado un ataque especial al Gigante y le has hecho " + ataqueEspecialJugador + " puntos de daño.");
                            ataqueEspecialDisponible = false;
                        } else {
                            System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                            saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                            G1.setVidaTotal(saludTotalEnemigo);
                            System.out.println("Has atacado al Gigante y le has hecho " + ataqueJugador + " puntos de daño.");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida...");
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        G1.setVidaTotal(saludTotalEnemigo);
                        System.out.println("Has atacado al Gigante y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                }
                // verificar si el enemigo está derrotado
                if (G1.getVidaTotal() <= 0) {
                    G1.setSe_ha_eliminado(true);    //Lo marcamos como eliminado.
                    break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                }

                // Turno del enemigo
                switch (eleccion_ataque_gigante) {
                    case 1:
                        saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                        System.out.println("El Gigante te ha atacado y te ha hecho " + G1.getAtaque() + " puntos de daño.");
                        break;
                    case 2:
                        if (G1.getCuracion_disponible() && G1.getVida() < 120) {
                            saludTotalEnemigo = saludTotalEnemigo + curacionGigante;  //habilidad de curación
                            G1.setVidaTotal(saludTotalEnemigo);
                            System.out.println("El gigante se ha curado " + G1.getCuracion() + " de vida.");
                            G1.setCuracion_disponible(false);
                        } else {
                            saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                            System.out.println("El Gigante te ha atacado y te ha hecho " + G1.getAtaque() + " puntos de daño.");
                        }
                        break;
                    default:
                        break;

                }
                // verificar si el jugador está derrotado
                if (saludJugador <= 0) {
                    J.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                }
            }
            if (G1.getSe_ha_eliminado()) {
                System.out.println("Has derrotado al Gigante!\n");
            }

            if (J.getEsta_eliminado()) {
                System.out.println("El Gigante te ha derrotado. Has perdido:(\n");
                break;  // Sal del juego cuando el jugador es derrotado
            }

            //DRAGON
            int contD = 1;
            if (contD == 1) {
                System.out.println("****TERCER NIVEL: DRAGON****");
                System.out.println("Salud del Dragon: " + D1.getVida_total() + "(Vida: " + D1.getVida() + " y Defensa: " + D1.getDefensa() + ")");
                contD++;
            }
            saludJugador = 100;
            saludEnemigo = D1.getVida_total();
            defensaEnemigo = D1.getDefensa();
            saludTotalEnemigo = D1.getVida_total();
            int EscupeFuego = D1.getEscupe_Fuego(); // ataque especial dragon
            scanner = new Scanner(System.in);
            ataqueEnemigo = D1.getAtaque();
            ataqueEspecialDisponible = true; //nueva partida con todos los recursos del heroe disponible otra vez.


            while (saludJugador > 0 && D1.getVida_total() > 0) {
                int eleccion_ataque_dragon= random.nextInt(2) + 1;

                System.out.println("\nTu salud: " + saludJugador);
                System.out.println("Vida total del Dragon: " + D1.getVida_total());
                System.out.println("1. Ataque normal (20 de daño)");
                System.out.println("2. Ataque especial (35 de daño y solo un uso)");
                System.out.print("Elige tu acción:");

                int opcion = scanner.nextInt();
                scanner.nextLine();
                int ataqueJugador = 20;

                switch (opcion) {
                    case 1: {
                        // Ataque normal
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        D1.setVida_total(saludTotalEnemigo);
                        System.out.println("Has atacado al Dragon y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                    case 2: {
                        // Ataque especial
                        if (ataqueEspecialDisponible) {
                            int ataqueEspecialJugador = 35;
                            saludTotalEnemigo = saludTotalEnemigo - ataqueEspecialJugador;
                            D1.setVida_total(saludTotalEnemigo);
                            System.out.println("Has realizado un ataque especial al Dragon y le has hecho " + ataqueEspecialJugador + " puntos de daño.");
                            ataqueEspecialDisponible = false;
                        } else {
                            System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                            saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                            D1.setVida-total(saludTotalEnemigo);
                            System.out.println("Has atacado al Dragon y le has hecho " + ataqueJugador + " puntos de daño.");
                        }
                        break;
                    }
                    default: {
                        System.out.println("Opcion invalida...");
                        saludTotalEnemigo = saludTotalEnemigo - ataqueJugador;
                        D1.setVida_total(saludTotalEnemigo);
                        System.out.println("Has atacado al Dragon y le has hecho " + ataqueJugador + " puntos de daño.");
                        break;
                    }
                }
                // verificar si el enemigo está derrotado
                if (D1.getVida_total() <= 0) {
                    D1.setSe_ha_eliminado(true);    //Lo marcamos como eliminado.
                    break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                }

                // Turno del enemigo
                switch (eleccion_ataque_dragon){
                    case 1:
                        saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                        System.out.println("El Dragon te ha atacado y te ha hecho " + D1.getAtaque() + " puntos de daño.");
                        break;
                    case 2:
                        if (D1.getEscupe_Fuego_Disponible() && saludJugador > 60) {
                            saludJugador = saludJugador - EscupeFuego;  //habilidad especial Dragon
                            System.out.println("El Dragon a usado EscupeFuego y te ha hecho " + D1.getEscupe_Fuego() + " de daño.");
                            D1.setEscupe_Fuego_Disponible(false);
                        } else {
                            saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                            System.out.println("El Dragon te ha atacado y te ha hecho " + D1.getAtaque() + " puntos de daño.");
                        }
                        break;
                    default:
                        break;

                }
                // verificar si el jugador está derrotado
                if (saludJugador <= 0) {
                    J.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                }
            }
            if (G1.getSe_ha_eliminado()) {
                System.out.println("Has derrotado al Dragon!");
            }

            if (J.getEsta_eliminado()) {
                System.out.println("El Dragon te ha derrotado. Has perdido:(\n");
                break;  // Sal del juego cuando el jugador es derrotado
            }

            if(E1.getSe_ha_eliminado() && G1.getSe_ha_eliminado() && D1.getSe_ha_eliminado()){
                System.out.println("Enhorabuena has vencido a los tres enemigos, has ganado!!\n");
            }

        }

    }
    public String hasta_donde_llego_jugador() {
        if (!E1.getSe_ha_eliminado()) {
            return "No ha pasado del primer nivel...";
        }
        if (!G1.getSe_ha_eliminado()) {
            return "No ha pasado del segundo nivel...";
        }
        if (!D1.getSe_ha_eliminado()) {
            return "No ha pasado del tercer nivel...";
        }
        return "Ha ganado";
    }

}
