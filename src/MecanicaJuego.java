import enemigos.Dragon;
import enemigos.Esbirro;
import enemigos.Gigante;

import java.util.Random;
import java.util.Scanner;

public class MecanicaJuego extends Jugador {
    private int saludJugador;    //cuando tengamos los 3 heroes, estas variables iran en otra clases(Barbaro, Mago, Valquiria) y cada heroe tendra una vida, un ataque y unas habilidades distintas.
    private int saludEnemigo;   //en enemigo sera igual
    private int defensaEnemigo;
    private int ataqueEnemigo;
    private int saludTotalEnemigo;
    private Scanner scanner;
    private int ataqueEspecialDisponible = 2;
    private Random random = new Random();

    Esbirro E1 = new Esbirro();
    Gigante G1 = new Gigante();
    Dragon D1 = new Dragon();
    //Jugador J = new Jugador();  //la funcion boolean esta_eliminado debe depende de las clases Barbaro, Mago y Valquiria.
    public void jugar(String heroe_seleccionado) {

        switch (heroe_seleccionado){
            case "Barbaro":
                Barbaro B1 = new Barbaro();
                int salud_inicial = B1.getVidaTotal();
                while (!E1.getSe_ha_eliminado() && !G1.getSe_ha_eliminado() && !D1.getSe_ha_eliminado() && !B1.getEsta_eliminado()) {
                    //ESBIRRO
                    int contE = 1;
                    if (contE == 1) {
                        System.out.println("\nPRIMER NIVEL: ESBIRRO");
                        System.out.println("Salud del Esbirro: " + E1.getVida_total() + "(Vida: " + E1.getVida() + " y Defensa: " + E1.getDefensa() + ")");
                        contE++;
                    }
                    saludJugador = salud_inicial;
                    saludEnemigo = E1.getVida_total();
                    defensaEnemigo = E1.getDefensa();
                    saludTotalEnemigo = E1.getVida_total();
                    scanner = new Scanner(System.in);

                    while (saludJugador > 0 && E1.getVida_total() > 0) {
                        ataqueEnemigo = E1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Esbirro: " + E1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (17 de daño)");
                        System.out.println("2. ATAQUE DE ESPADA (17*2 de daño y solo 2 usos)");
                        System.out.println("3. ENFURECIMIENTO (duplicas el daño durante 2 turnos)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int duracion_enfurecimiento_aux = B1.getDuracion_enfurecimiento();  //duracion 3 turnos
                                if (B1.getSe_esta_usando_enfurecimiento() && B1.getDuracion_enfurecimiento()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos del ENFURECIMIENTO, te quedan " + (B1.getDuracion_enfurecimiento()-1) +" trunos de ENFURECIMIENTO" );
                                    saludTotalEnemigo = B1.ataque_normal_enfuerecido(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17*2 + " puntos de daño.");
                                    duracion_enfurecimiento_aux--;
                                    B1.setDuracion_enfurecimiento(duracion_enfurecimiento_aux);
                                }else{
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = B1.Ataque_de_espada(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado ATAQUE DE ESPADA al esbirro y le has hecho " +  17*2 + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE DE ESPADA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(B1.getEnfurecimiento_disponible()){
                                    System.out.println("Has usado ENFURECIMIENTO");
                                    B1.enfurecimiento();
                                    B1.setEnfurecimiento_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado enfurecimiento... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                E1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                break;
                            }
                        }
                        // verificar si el enemigo está derrotado
                        if (E1.getVida_total() <= 0) {
                            E1.setSe_ha_eliminado(true);    //lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        saludJugador = saludJugador - ataqueEnemigo;    //El esbirro nos ataca y actualizamos la vida del barbaro con el setVidatotal.
                        B1.setVidaTotal(saludJugador);
                        System.out.println("El esbirro te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");

                        // verificar si el jugador está derrotado
                        if (B1.getVidaTotal() <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (E1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al esbirro!\n");
                    }
                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Esbirro te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    //GIGANTE
                    B1.setSe_esta_usando_enfurecimiento(false); //para que no empiece el nuevo nivel bajo los efectos del enfurecimiento.
                    B1.setEnfurecimiento_disponible(true);  //reseteamos el enfurecimiento para que se pueda usar en el nuevo nivel.
                    B1.setDuracion_enfurecimiento(2);   //reiniciamos el enfurecimiento.
                    int contG = 1;
                    if (contG == 1) {
                        System.out.println("****SEGUNDO NIVEL: GIGANTE****");
                        System.out.println("Salud del Gigante: " + G1.getVida_total() + "(Vida: " + G1.getVida() + " y Defensa: " + G1.getDefensa() + ")");
                        contG++;
                    }
                    saludJugador = salud_inicial;   //RESETEAMOS LA VIDA DEL JUGADOR AL EMPEZAR NUEVO NIVEL.
                    saludEnemigo = G1.getVida();
                    defensaEnemigo = G1.getDefensa();
                    saludTotalEnemigo = G1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.
                    int curacionGigante = G1.getCuracion();

                    while (saludJugador > 0 && G1.getVida_total() > 0) {
                        int eleccion_ataque_gigante = random.nextInt(2) + 1;
                        ataqueEnemigo = G1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Gigante: " + G1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (17 de daño)");
                        System.out.println("2. ATAQUE DE ESPADA (17*2 de daño y solo 2 usos)");
                        System.out.println("3. ENFURECIMIENTO (duplicas el daño durante 2 turnos)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int duracion_enfurecimiento_aux = B1.getDuracion_enfurecimiento();  //duracion 3 turnos
                                if (B1.getSe_esta_usando_enfurecimiento() && B1.getDuracion_enfurecimiento()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos del ENFURECIMIENTO, te quedan " + (B1.getDuracion_enfurecimiento()-1) +" trunos de ENFURECIMIENTO" );
                                    saludTotalEnemigo = B1.ataque_normal_enfuerecido(saludTotalEnemigo);  //quitar int vida_enemigo_despues_ataque y poner saludTotalEnemigo.
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + (17*2) + " puntos de daño.");
                                    duracion_enfurecimiento_aux--;
                                    B1.setDuracion_enfurecimiento(duracion_enfurecimiento_aux);
                                }else{
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = B1.Ataque_de_espada(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado ATAQUE DE ESPADA al Gigante y le has hecho " +  (17*2) + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE DE ESPADA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + (17) + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(B1.getEnfurecimiento_disponible()){
                                    System.out.println("Has usado ENFURECIMIENTO");
                                    B1.enfurecimiento();
                                    B1.setEnfurecimiento_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado enfurecimiento... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                G1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                break;
                            }
                        }
                        // verificar si el enemigo está derrotado
                        if (G1.getVida_total() <= 0) {
                            G1.setSe_ha_eliminado(true);    //Lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        switch (eleccion_ataque_gigante) {
                            case 1:
                                saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                B1.setVidaTotal(saludJugador);
                                System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                break;
                            case 2:
                                if (G1.getCuracion_disponible() && G1.getVida_total() < 120) {
                                    saludTotalEnemigo = saludTotalEnemigo + curacionGigante;  //habilidad de curación
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("El gigante se ha curado " + G1.getCuracion() + " de vida.");
                                    G1.setCuracion_disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                    B1.setVidaTotal(saludJugador);
                                    System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (G1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Gigante!\n");
                    }

                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Gigante te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    //DRAGON
                    B1.setSe_esta_usando_enfurecimiento(false); //para que no empiece el nuevo nivel bajo los efectos del enfurecimiento.
                    B1.setEnfurecimiento_disponible(true);  //reseteamos el enfurecimiento para que se pueda usar en el nuevo nivel.
                    B1.setDuracion_enfurecimiento(2);   //reiniciamos el enfurecimiento.

                    int contD = 1;
                    if (contD == 1) {
                        System.out.println("****TERCER NIVEL: DRAGON****");
                        System.out.println("Salud del Dragon: " + D1.getVida_total() + "(Vida: " + D1.getVida() + " y Defensa: " + D1.getDefensa() + ")");
                        contD++;
                    }
                    saludJugador = salud_inicial;
                    saludEnemigo = D1.getVida_total();
                    defensaEnemigo = D1.getDefensa();
                    saludTotalEnemigo = D1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.


                    while (saludJugador > 0 && D1.getVida_total() > 0) {
                        int eleccion_ataque_dragon= random.nextInt(2) + 1;
                        ataqueEnemigo = D1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.


                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Dragon: " + D1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (17 de daño)");
                        System.out.println("2. ATAQUE DE ESPADA (17*2 de daño y solo 2 usos)");
                        System.out.println("3. ENFURECIMIENTO (duplicas el daño durante 2 turnos)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int duracion_enfurecimiento_aux = B1.getDuracion_enfurecimiento();  //duracion 3 turnos
                                if (B1.getSe_esta_usando_enfurecimiento() && B1.getDuracion_enfurecimiento()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos del ENFURECIMIENTO, te quedan " + (B1.getDuracion_enfurecimiento()-1) +" trunos de ENFURECIMIENTO" );
                                    saludTotalEnemigo = B1.ataque_normal_enfuerecido(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 34 + " puntos de daño.");
                                    duracion_enfurecimiento_aux--;
                                    B1.setDuracion_enfurecimiento(duracion_enfurecimiento_aux);
                                }else{
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = B1.Ataque_de_espada(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado un ATAQUE DE ESPADA al Dragon y le has hecho " +  17*2 + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE DE ESPADA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(B1.getEnfurecimiento_disponible()){
                                    System.out.println("Has usado ENFURECIMIENTO");
                                    B1.enfurecimiento();
                                    B1.setEnfurecimiento_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado enfurecimiento... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                D1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
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
                                B1.setVidaTotal(saludJugador);
                                System.out.println("El Dragon te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                break;
                            case 2:
                                if (D1.getEscupe_Fuego_Disponible() && saludJugador > 60) {
                                    saludJugador = saludJugador - D1.getEscupe_Fuego();  //habilidad especial enemigos.Dragon
                                    System.out.println("El Dragon a usado EscupeFuego y te ha hecho " + D1.getEscupe_Fuego() + " de daño.");
                                    D1.setEscupe_Fuego_Disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                    System.out.println("El Dragon te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (D1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Dragon!");
                    }

                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Dragon te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    if(E1.getSe_ha_eliminado() && G1.getSe_ha_eliminado() && D1.getSe_ha_eliminado()){
                        System.out.println("Enhorabuena has vencido a los tres enemigos, has ganado!!\n");
                    }

                }
                break;
            case "Mago":        //resetear vortice de energia en cada enemigo, errores a la hora de quitar vida en gigante y dragon, errores en el texto del println.
                Mago M1 = new Mago();
                int vida_inicial = M1.getVida();
                while (!E1.getSe_ha_eliminado() && !G1.getSe_ha_eliminado() && !D1.getSe_ha_eliminado() && !M1.getEsta_eliminado()) {
                    //ESBIRRO
                    int contE = 1;
                    if (contE == 1) {
                        System.out.println("\nPRIMER NIVEL: ESBIRRO");
                        System.out.println("Salud del enemigos.Esbirro: " + E1.getVida_total() + "(Vida: " + E1.getVida() + " y Defensa: " + E1.getDefensa() + ")");
                        contE++;
                    }
                    saludJugador = vida_inicial;
                    saludEnemigo = E1.getVida_total();
                    defensaEnemigo = E1.getDefensa();
                    saludTotalEnemigo = E1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEnemigo = E1.getAtaque();
                    ataqueEspecialDisponible = 2;

                    while (saludJugador > 0 && E1.getVida_total() > 0) {
                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Esbirro: " + E1.getVida_total());
                        System.out.println("1. Ataque normal (17 de daño + 7 de magia)");
                        System.out.println("2. FireBall ((ataque normal)*2 de daño y solo 2 usos)");
                        System.out.println("3. Vortice de energia(Roba un porcentaje de la vida del enemigo y se cura la mitad del daño que ocasione)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1 -> {
                                // Ataque normal
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                E1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho 17+7 puntos de daño.");
                            }
                            case 2 -> {
                                // Ataque especial
                                if (ataqueEspecialDisponible > 0) {
                                    saludTotalEnemigo = M1.FireBall(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado Fireball contra el esbirro y le has hecho (17+7)*2 puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho 17+7 puntos de daño.");
                                }
                            }
                            case 3 -> {
                                if (M1.getEsta_disponible_vortice() && M1.getVida()<70) {
                                    int danio = M1.voritce_de_energia(saludTotalEnemigo);
                                    saludTotalEnemigo = saludTotalEnemigo - danio;
                                    E1.setVida_total(saludTotalEnemigo);
                                    saludJugador = saludJugador +(danio/2);    //El esbirro nos ataca y actualizamos la vida del barbaro con el setVidatotal.
                                    M1.setVida(saludJugador);
                                    System.out.println("Has usado vortice de energia y has hecho al esbirro " + danio + " puntos de daño y te has curado " + danio/2 + " puntos de salud.");

                                } else {
                                    System.out.println("Ya has usado voritce de energia o tienes demasiada salud como para curarte...");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho 17+7 puntos de daño.");
                                }
                            }
                            default -> {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                E1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho 17+7 puntos de daño.");
                            }
                        }
                        // verificar si el enemigo está derrotado
                        if (E1.getVida_total() <= 0) {
                            E1.setSe_ha_eliminado(true);    //lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        saludJugador = saludJugador - ataqueEnemigo;    //El esbirro nos ataca y actualizamos la vida del barbaro con el setVidatotal.
                        M1.setVida(saludJugador);
                        System.out.println("El esbirro te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");

                        // verificar si el jugador está derrotado
                        if (M1.getVida() <= 0) {
                            M1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (E1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al esbirro!\n");
                    }
                    if (M1.getEsta_eliminado()) {
                        System.out.println("El Esbirro te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    //GIGANTE
                    int contG = 1;
                    if (contG == 1) {
                        System.out.println("****SEGUNDO NIVEL: GIGANTE****");
                        System.out.println("Salud del enemigos.Gigante: " + G1.getVida_total() + "(Vida: " + G1.getVida() + " y Defensa: " + G1.getDefensa() + ")");
                        contG++;
                    }
                    saludJugador = vida_inicial;   //RESETEAMOS LA VIDA DEL JUGADOR AL EMPEZAR NUEVO NIVEL.
                    saludEnemigo = G1.getVida();
                    defensaEnemigo = G1.getDefensa();
                    saludTotalEnemigo = G1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEnemigo = G1.getAtaque();
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.
                    int curacionGigante = G1.getCuracion();
                    M1.setEsta_disponible_vortice(true);


                    while (saludJugador > 0 && G1.getVida_total() > 0) {
                        int eleccion_ataque_gigante = random.nextInt(2) + 1;

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Gigante: " + G1.getVida_total());
                        System.out.println("1. Ataque normal (17 de daño + 7 de magia)");
                        System.out.println("2. FireBall ((ataque normal)*2 de daño y solo 2 usos)");
                        System.out.println("3. Vortice de energia(Roba un porcentaje de la vida del enemigo y se cura la mitad del daño que ocasione)");
                        System.out.print("Elige tu acción:");
                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1 -> {
                                // Ataque normal
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                G1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al gigante y le has hecho 17+7 puntos de daño.");
                            }
                            case 2 -> {
                                // Ataque especial
                                if (ataqueEspecialDisponible > 0) {
                                    saludTotalEnemigo = M1.FireBall(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado Fireball contra el gigante y le has hecho (17+7)*2 puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ataque especial, se efectuara un ataque normal.");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al gigante y le has hecho 17+7 puntos de daño.");
                                }
                            }
                            case 3 -> {
                                if (M1.getEsta_disponible_vortice() && M1.getVida()<70) {
                                    int danio = M1.voritce_de_energia(saludTotalEnemigo);
                                    saludTotalEnemigo = saludTotalEnemigo - danio;
                                    G1.setVida_total(saludTotalEnemigo);
                                    saludJugador = saludJugador +(danio/2);    //El esbirro nos ataca y actualizamos la vida del barbaro con el setVidatotal.
                                    M1.setVida(saludJugador);
                                    System.out.println("Has usado vortice de energia y has hecho al gigante " + danio + " puntos de daño y te has curado " + danio/2 + " puntos de salud.");

                                } else {
                                    System.out.println("Ya has usado voritce de energia o tienes demasiada salud como para curarte...");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al gigante y le has hecho 17+7 puntos de daño.");
                                }
                            }
                            default -> {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                G1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al gigante y le has hecho 17+7 puntos de daño.");
                            }

                        }
                        // verificar si el enemigo está derrotado
                        if (G1.getVida_total() <= 0) {
                            G1.setSe_ha_eliminado(true);    //Lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        switch (eleccion_ataque_gigante) {
                            case 1:
                                saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                M1.setVida(saludJugador);
                                System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                break;
                            case 2:
                                if (G1.getCuracion_disponible() && G1.getVida_total() < 120) {
                                    saludTotalEnemigo = saludTotalEnemigo + curacionGigante;  //habilidad de curación
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("El gigante se ha curado " + G1.getCuracion() + " de vida.");
                                    G1.setCuracion_disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                    M1.setVida(saludJugador);
                                    System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            M1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (G1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Gigante!\n");
                    }

                    if (M1.getEsta_eliminado()) {
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
                    saludJugador = vida_inicial;
                    saludEnemigo = D1.getVida();
                    //System.out.println(D1.getVida());
                    defensaEnemigo = D1.getDefensa();
                    saludTotalEnemigo = D1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEnemigo = D1.getAtaque();
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.
                    M1.setEsta_disponible_vortice(true);


                    while (saludJugador > 0 && D1.getVida() > 0) {
                        int eleccion_ataque_dragon= random.nextInt(2) + 1;

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Dragon: " + D1.getVida_total());
                        System.out.println("1. Ataque normal (17 de daño + 7 de magia)");
                        System.out.println("2. FireBall ((ataque normal)*2 de daño y solo 2 usos)");
                        System.out.println("3. Vortice de energia(Roba un porcentaje de la vida del enemigo y se cura la mitad del daño que ocasione)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                D1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al Dragon y le has hecho 17+7 puntos de daño.");
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = M1.FireBall(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado Fireball contra el Dragon y le has hecho (17+7)*2 puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado Fireball, se efectuara un ataque normal.");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho 17+7 puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(M1.getEsta_disponible_vortice()){
                                    int danio = M1.voritce_de_energia(saludTotalEnemigo);
                                    saludTotalEnemigo = saludTotalEnemigo - danio;
                                    D1.setVida_total(saludTotalEnemigo);
                                    M1.setVida(saludJugador + (danio/2));  //curamos al mago con la mitad del daño ejercido
                                    System.out.println("Has usado vortice de energia y has hecho al Dragon " + danio + " puntos de daño y te has curado " + danio/2 + " puntos de salud.");
                                }
                                else{
                                    System.out.println("Ya has usado voritce de energia...");
                                    saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho 17+7 puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida... Efectuaras un ataque normal");
                                saludTotalEnemigo = M1.ataque_normal(saludTotalEnemigo);
                                D1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al Dragon y le has hecho 17+7 puntos de daño.");
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
                                M1.setVida(saludJugador);
                                System.out.println("El Dragon te ha atacado y te ha hecho " + D1.getAtaque() + " puntos de daño.");
                                break;
                            case 2:
                                if (D1.getEscupe_Fuego_Disponible() && saludJugador > 60) {
                                    saludJugador = saludJugador - D1.getEscupe_Fuego();
                                    M1.setVida(saludJugador);
                                    System.out.println("El Dragon a usado EscupeFuego y te ha hecho " + D1.getEscupe_Fuego() + " de daño.");
                                    D1.setEscupe_Fuego_Disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;
                                    M1.setVida(saludJugador);
                                    System.out.println("El enemigos.Dragon te ha atacado y te ha hecho " + D1.getAtaque() + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            M1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (D1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Dragon!");
                    }

                    if (M1.getEsta_eliminado()) {
                        System.out.println("El Dragon te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    if(E1.getSe_ha_eliminado() && G1.getSe_ha_eliminado() && D1.getSe_ha_eliminado()){
                        System.out.println("Enhorabuena has vencido a los tres enemigos, has ganado!!\n");
                    }

                }
                break;

            case "Valquiria":
                /*
                Valquiria V1 = new Valquiria();
                int salud_inicialV = V1.getVidaTotal();
                while (!E1.getSe_ha_eliminado() && !G1.getSe_ha_eliminado() && !D1.getSe_ha_eliminado() && !V1.getEsta_eliminado()) {
                    //ESBIRRO
                    int contE = 1;
                    if (contE == 1) {
                        System.out.println("\nPRIMER NIVEL: ESBIRRO");
                        System.out.println("Salud del Esbirro: " + E1.getVida_total() + "(Vida: " + E1.getVida() + " y Defensa: " + E1.getDefensa() + ")");
                        contE++;
                    }
                    saludJugador = salud_inicialV;
                    saludEnemigo = E1.getVida_total();
                    defensaEnemigo = E1.getDefensa();
                    saludTotalEnemigo = E1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEspecialDisponible = 2;


                    while (saludJugador > 0 && E1.getVida_total() > 0) {
                        ataqueEnemigo = E1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Esbirro: " + E1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (15 de daño)");
                        System.out.println("2. ATAQUE DE HACHA (15*2 de daño y solo 2 usos)");
                        System.out.println("3. TRANSFORMACION IRACUNDA (aumentas la vida, y el daño(durante 2 turnos))");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int Duracion_transformacion_iracunda_aux = V1.getDuracion_transformacion_iracunda();  //duracion 2 turnos
                                if (V1.getSe_esta_usando_transformacion_iracunda() && V1.getDuracion_transformacion_iracunda()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos de la TRANSFORMACION IRACUNDA, te quedan " + (V1.getDuracion_transformacion_iracunda()-1) +" trunos de TRNASFORMACION IRACUNDA" );
                                    saludTotalEnemigo = V1.ataque_normal_enfuerecido(saludTotalEnemigo);    //implementar en valquuiria
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 15+4 + " puntos de daño.");
                                    Duracion_transformacion_iracunda_aux--;
                                    V1.setDuracion_transformacion_iracunda(Duracion_transformacion_iracunda_aux);
                                }else{
                                    saludTotalEnemigo = V1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 15 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = V1.Ataque_con_hacha(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado ATAQUE CON HACHA al esbirro y le has hecho " +  15*2 + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE CON HACHA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = V1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 15 + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(V1.getTransformacion_iracunda_disponible()){
                                    System.out.println("Has usado TRANSFORMACION IRACUNDA");
                                    V1.transformacion_iracunda();
                                    V1.setTransformacion_iracunda_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado TRANSFORMACION IRACUNDA... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = V1.ataque_normal(saludTotalEnemigo);
                                    E1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 15 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = V1.ataque_normal(saludTotalEnemigo);
                                E1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 15 + " puntos de daño.");
                                break;
                            }
                        }
                        // verificar si el enemigo está derrotado
                        if (E1.getVida_total() <= 0) {
                            E1.setSe_ha_eliminado(true);    //lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        saludJugador = saludJugador - ataqueEnemigo;    //El esbirro nos ataca y actualizamos la vida del barbaro con el setVidatotal.
                        B1.setVidaTotal(saludJugador);
                        System.out.println("El esbirro te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");

                        // verificar si el jugador está derrotado
                        if (B1.getVidaTotal() <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (E1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al esbirro!\n");
                    }
                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Esbirro te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    //GIGANTE
                    B1.setSe_esta_usando_enfurecimiento(false); //para que no empiece el nuevo nivel bajo los efectos del enfurecimiento.
                    B1.setEnfurecimiento_disponible(true);  //reseteamos el enfurecimiento para que se pueda usar en el nuevo nivel.
                    B1.setDuracion_enfurecimiento(2);   //reiniciamos el enfurecimiento.
                    int contG = 1;
                    if (contG == 1) {
                        System.out.println("****SEGUNDO NIVEL: GIGANTE****");
                        System.out.println("Salud del Gigante: " + G1.getVida_total() + "(Vida: " + G1.getVida() + " y Defensa: " + G1.getDefensa() + ")");
                        contG++;
                    }
                    saludJugador = salud_inicial;   //RESETEAMOS LA VIDA DEL JUGADOR AL EMPEZAR NUEVO NIVEL.
                    saludEnemigo = G1.getVida();
                    defensaEnemigo = G1.getDefensa();
                    saludTotalEnemigo = G1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.
                    int curacionGigante = G1.getCuracion();

                    while (saludJugador > 0 && G1.getVida_total() > 0) {
                        int eleccion_ataque_gigante = random.nextInt(2) + 1;
                        ataqueEnemigo = G1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.

                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Gigante: " + G1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (17 de daño)");
                        System.out.println("2. ATAQUE DE ESPADA (17*2 de daño y solo 2 usos)");
                        System.out.println("3. ENFURECIMIENTO (duplicas el daño durante 2 turnos)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int duracion_enfurecimiento_aux = B1.getDuracion_enfurecimiento();  //duracion 3 turnos
                                if (B1.getSe_esta_usando_enfurecimiento() && B1.getDuracion_enfurecimiento()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos del ENFURECIMIENTO, te quedan " + (B1.getDuracion_enfurecimiento()-1) +" trunos de ENFURECIMIENTO" );
                                    saludTotalEnemigo = B1.ataque_normal_enfuerecido(saludTotalEnemigo);  //quitar int vida_enemigo_despues_ataque y poner saludTotalEnemigo.
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + (17*2) + " puntos de daño.");
                                    duracion_enfurecimiento_aux--;
                                    B1.setDuracion_enfurecimiento(duracion_enfurecimiento_aux);
                                }else{
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = B1.Ataque_de_espada(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado ATAQUE DE ESPADA al Gigante y le has hecho " +  (17*2) + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE DE ESPADA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Gigante y le has hecho " + (17) + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(B1.getEnfurecimiento_disponible()){
                                    System.out.println("Has usado ENFURECIMIENTO");
                                    B1.enfurecimiento();
                                    B1.setEnfurecimiento_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado enfurecimiento... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                G1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                break;
                            }
                        }
                        // verificar si el enemigo está derrotado
                        if (G1.getVida_total() <= 0) {
                            G1.setSe_ha_eliminado(true);    //Lo marcamos como eliminado.
                            break;  //rompo el bucle para que no continue el juego cunado derrotas al enemigo.
                        }

                        // Turno del enemigo
                        switch (eleccion_ataque_gigante) {
                            case 1:
                                saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                B1.setVidaTotal(saludJugador);
                                System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                break;
                            case 2:
                                if (G1.getCuracion_disponible() && G1.getVida_total() < 120) {
                                    saludTotalEnemigo = saludTotalEnemigo + curacionGigante;  //habilidad de curación
                                    G1.setVida_total(saludTotalEnemigo);
                                    System.out.println("El gigante se ha curado " + G1.getCuracion() + " de vida.");
                                    G1.setCuracion_disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                    B1.setVidaTotal(saludJugador);
                                    System.out.println("El Gigante te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (G1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Gigante!\n");
                    }

                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Gigante te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    //DRAGON
                    B1.setSe_esta_usando_enfurecimiento(false); //para que no empiece el nuevo nivel bajo los efectos del enfurecimiento.
                    B1.setEnfurecimiento_disponible(true);  //reseteamos el enfurecimiento para que se pueda usar en el nuevo nivel.
                    B1.setDuracion_enfurecimiento(2);   //reiniciamos el enfurecimiento.

                    int contD = 1;
                    if (contD == 1) {
                        System.out.println("****TERCER NIVEL: DRAGON****");
                        System.out.println("Salud del Dragon: " + D1.getVida_total() + "(Vida: " + D1.getVida() + " y Defensa: " + D1.getDefensa() + ")");
                        contD++;
                    }
                    saludJugador = salud_inicial;
                    saludEnemigo = D1.getVida_total();
                    defensaEnemigo = D1.getDefensa();
                    saludTotalEnemigo = D1.getVida_total();
                    scanner = new Scanner(System.in);
                    ataqueEspecialDisponible = 2; //nueva partida con todos los recursos del heroe disponible otra vez.


                    while (saludJugador > 0 && D1.getVida_total() > 0) {
                        int eleccion_ataque_dragon= random.nextInt(2) + 1;
                        ataqueEnemigo = D1.getAtaque(); //para que se actualice el ataque aleatorio del enemigo.


                        System.out.println("\nTu salud: " + saludJugador);
                        System.out.println("Vida total del Dragon: " + D1.getVida_total());
                        System.out.println("1. ATAQUE NORMAL (17 de daño)");
                        System.out.println("2. ATAQUE DE ESPADA (17*2 de daño y solo 2 usos)");
                        System.out.println("3. ENFURECIMIENTO (duplicas el daño durante 2 turnos)");
                        System.out.print("Elige tu acción:");

                        int opcion = scanner.nextInt();
                        scanner.nextLine();

                        switch (opcion) {
                            case 1: {
                                // Ataque normal
                                int duracion_enfurecimiento_aux = B1.getDuracion_enfurecimiento();  //duracion 3 turnos
                                if (B1.getSe_esta_usando_enfurecimiento() && B1.getDuracion_enfurecimiento()>0){    //ataque normal enfurecido
                                    System.out.println("Estas usando el atauqe normal bajo los efectos del ENFURECIMIENTO, te quedan " + (B1.getDuracion_enfurecimiento()-1) +" trunos de ENFURECIMIENTO" );
                                    saludTotalEnemigo = B1.ataque_normal_enfuerecido(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 34 + " puntos de daño.");
                                    duracion_enfurecimiento_aux--;
                                    B1.setDuracion_enfurecimiento(duracion_enfurecimiento_aux);
                                }else{
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 2: {
                                // Ataque especial
                                if (ataqueEspecialDisponible>0) {
                                    saludTotalEnemigo = B1.Ataque_de_espada(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has realizado un ATAQUE DE ESPADA al Dragon y le has hecho " +  17*2 + " puntos de daño.");
                                    ataqueEspecialDisponible--;
                                } else {
                                    System.out.println("Ya has usado el ATAQUE DE ESPADA 2 veces, se efectuara un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al Dragon y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            case 3:{
                                if(B1.getEnfurecimiento_disponible()){
                                    System.out.println("Has usado ENFURECIMIENTO");
                                    B1.enfurecimiento();
                                    B1.setEnfurecimiento_disponible(false);
                                }
                                else{
                                    System.out.println("Ya has usado enfurecimiento... Se efecturada un ataque normal.");
                                    saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                    D1.setVida_total(saludTotalEnemigo);
                                    System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion invalida...");
                                saludTotalEnemigo = B1.ataque_normal(saludTotalEnemigo);
                                D1.setVida_total(saludTotalEnemigo);
                                System.out.println("Has atacado al esbirro y le has hecho " + 17 + " puntos de daño.");
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
                                B1.setVidaTotal(saludJugador);
                                System.out.println("El Dragon te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                break;
                            case 2:
                                if (D1.getEscupe_Fuego_Disponible() && saludJugador > 60) {
                                    saludJugador = saludJugador - D1.getEscupe_Fuego();  //habilidad especial enemigos.Dragon
                                    System.out.println("El Dragon a usado EscupeFuego y te ha hecho " + D1.getEscupe_Fuego() + " de daño.");
                                    D1.setEscupe_Fuego_Disponible(false);
                                } else {
                                    saludJugador = saludJugador - ataqueEnemigo;    //ataque del gigante
                                    System.out.println("El Dragon te ha atacado y te ha hecho " + ataqueEnemigo + " puntos de daño.");
                                }
                                break;
                            default:
                                break;

                        }
                        // verificar si el jugador está derrotado
                        if (saludJugador <= 0) {
                            B1.setEsta_eliminado(true);  //marcamos al jugador como eliminado;
                        }
                    }
                    if (D1.getSe_ha_eliminado()) {
                        System.out.println("Has derrotado al Dragon!");
                    }

                    if (B1.getEsta_eliminado()) {
                        System.out.println("El Dragon te ha derrotado. Has perdido:(\n");
                        break;  // Sal del juego cuando el jugador es derrotado
                    }

                    if(E1.getSe_ha_eliminado() && G1.getSe_ha_eliminado() && D1.getSe_ha_eliminado()){
                        System.out.println("Enhorabuena has vencido a los tres enemigos, has ganado!!\n");
                    }

                }
                break;
                */
            default: break;
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
