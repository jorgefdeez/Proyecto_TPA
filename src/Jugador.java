import java.util.Scanner;

public class Jugador {
    private String nombre;
    private int ID;
    private int nivelXP;
    private String resultado;
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
    public String getResultado(){
        return resultado;
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
    void setResultado(String r){
        this.resultado = r;
    }

}
