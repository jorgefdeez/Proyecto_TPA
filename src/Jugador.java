import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int ID;
    private int nivelXP;
    private int vida;
    private int ataque;
    private boolean esta_eliminado;

    public String getNombre(){
        return nombre;
    }
    public int getID(){
        return ID;
    }
    public int getNivelXP(){
        return nivelXP;
    }

    public boolean getEsta_eliminado() {
        return esta_eliminado;
    }

    void setNombre(String n){
        this.nombre = n;
    }
    void setID(int i){
        ID = i;
    }
    void setNivelXP(int xp){
        this.nivelXP = xp;
    }
    void setEsta_eliminado(boolean e){
        this.esta_eliminado = e;
    }
    public void IntroducirDatos(){
        Scanner scanner = new Scanner(System.in);

        String Nombre;
        int ID, xp;
        System.out.print("Introduce el nombre: ");
        setNombre(scanner.next());
        System.out.print("Introduce el ID: ");
        ID = scanner.nextInt();
        setID(ID);
        xp = 0; // al inicio del juego es 0.

    }
}
