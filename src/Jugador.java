import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int ID;
    private int nivelXP;

    public String getNombre(){
        return nombre;
    }
    public int getID(){
        return ID;
    }
    public int getNivelXP(){
        return nivelXP;
    }
    void setNombre(String n){
        this.nombre = n;
    }
    void setID(int i){
        this.ID = i;
    }
    void setNivelXP(int xp){
        this.nivelXP = xp;
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
