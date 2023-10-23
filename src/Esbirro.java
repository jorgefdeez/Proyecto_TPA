import java.util.Random;
import java.util.Scanner;

public class Esbirro extends Enemigo{
    private boolean se_ha_eliminado;
    private int ataque;
    private int vida;
    private int defensa;
    private int vidaTotal;
    private Random random = new Random();
    private  Scanner scanner = new Scanner(System.in);

    public Esbirro(){

        ataque = random.nextInt(10)+15;
        vida = 100;
        defensa = 10;   //la defensa se complementa a la vida.
        vidaTotal = vida + defensa;
        se_ha_eliminado = false;
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

    public boolean getSe_ha_eliminado() {
        return se_ha_eliminado;
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
}


