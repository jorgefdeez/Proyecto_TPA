import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int ID;
    private int nivelXP;
    private String resultado;
    private String eleccion_heroe;
    private int vida;
    private int ataque;
    private boolean esta_eliminado;

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public int getNivelXP() {
        return nivelXP;
    }

    public boolean getEsta_eliminado() {
        return esta_eliminado;
    }

    public String getResultado() {
        return resultado;
    }

    public String getEleccion_heroe() {
        return eleccion_heroe;
    }

    public void setNombre(String n) {
        this.nombre = n;
    }

    public void setID(int i) {
        ID = i;
    }

    public void setNivelXP(int xp) {
        this.nivelXP = xp;
    }

    public void setEsta_eliminado(boolean e) {
        this.esta_eliminado = e;
    }

    public void setResultado(String r) {
        this.resultado = r;
    }

    public void Seleccionar_heroe() {
        int eleccion;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Barbaro = 1");
        System.out.println("Mago = 2");
        System.out.println("Valquiria = 3");
        System.out.print("¿Qué héroe quieres utilizar?: ");
        eleccion = scanner.nextInt();
        switch (eleccion) {
            case 1:
                eleccion_heroe = "Barbaro";
                break;
            case 2:
                eleccion_heroe = "Mago";
                break;
            case 3:
                eleccion_heroe = "Valquiria";
                break;
            default:
                System.out.println("Opción no válida. Seleccionando Barbaro por defecto.");
                eleccion_heroe = "Barbaro";
        }
    }
}
