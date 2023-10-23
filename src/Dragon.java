import java.util.Random;
import java.util.Scanner;

public class Dragon extends Enemigo{
    private boolean se_ha_eliminado;
    private int ataque;
    private int Escupe_Fuego;
    private int vida;
    private int defensa;
    private int vidaTotal;
    private boolean Escupe_Fuego_Disponible;
    private Random random = new Random();
    public Dragon(){
        Scanner scanner = new Scanner(System.in);

        ataque = random.nextInt(10)+20;
        Escupe_Fuego = random.nextInt(15)+25;
        vida = 120;
        defensa = 0;   //la defensa se complementa a la vida.
        vidaTotal = vida + defensa;
        Escupe_Fuego_Disponible = true;
    }
    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque = random.nextInt(10)+15;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getVidaTotal() {
        return vidaTotal;
    }
    public int getEscupe_Fuego() {
        return Escupe_Fuego;
    }
    public boolean getSe_ha_eliminado() {
        return se_ha_eliminado;
    }
    public boolean getEscupe_Fuego_Disponible() {
        return Escupe_Fuego_Disponible;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }
    public void setVidaTotal(int vidaTotal) {
        this.vidaTotal = vidaTotal;
    }
    public void setSe_ha_eliminado(boolean S){
        this.se_ha_eliminado = S;
    }
    public void setEscupe_Fuego_Disponible(boolean s){
        Escupe_Fuego_Disponible = s;
    }
}
