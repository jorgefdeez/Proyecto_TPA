import java.util.Scanner;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nombre;
        int op;
        int ID;
        ArrayList<Jugador> lista_jugadores = new ArrayList<Jugador>();

        System.out.print("Cuantos jugadores van a ser?: ");
        op = scanner.nextInt();

        for(int i=0;i<op;i++){
            Jugador J1 = new Jugador();

            System.out.print("Intro el nombre: ");
            nombre = scanner.next();
            J1.setNombre(nombre);
            System.out.print("Introdcue el ID(4 numeros enteros): ");
            ID = scanner.nextInt();
            J1.setID(ID);
            J1.Seleccionar_heroe();
            if(J1.getSeleccion_heroe() == "Valquiria"){
                System.out.println("Bienvenido al juego " + J1.getNombre() + " eres una " + J1.getSeleccion_heroe() + "!");
            }else{
                System.out.println("Bienvenido al juego " + J1.getNombre() + "eres un " + J1.getSeleccion_heroe() + "!");
            }
            MecanicaJuego juego = new MecanicaJuego();
            juego.jugar();

            String resultado = juego.hasta_donde_llego_jugador();
            J1.setResultado(resultado);
            lista_jugadores.add(J1);

        }
        System.out.println("*******REGISTRO DE PARTIDA*******");
        for(int i = 0;i<lista_jugadores.size();i++){
            System.out.println("Nombre: " + lista_jugadores.get(i).getNombre());
            System.out.println("ID: " + lista_jugadores.get(i).getID());
            System.out.println("Resultado: " + lista_jugadores.get(i).getResultado() + "\n");
        }

    }
}