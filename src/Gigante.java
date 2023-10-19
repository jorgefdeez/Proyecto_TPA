import java.util.Random;
import java.util.Scanner;

public class Gigante{
    private boolean se_ha_eliminado;
    private boolean curacion_disponible;
    private int ataque;
    private int Curacion;
    private int vida;
    private int defensa;
    private int vidaTotal;
    private Random random = new Random();

    public Gigante(){
        Scanner scanner = new Scanner(System.in);

        ataque = random.nextInt(10)+7;
        Curacion = 30;  //habilidad del gigante, se cura.
        vida = 100;
        defensa = 50;   //la defensa se complementa a la vida.
        vidaTotal = vida + defensa;
        se_ha_eliminado =  false;
        curacion_disponible = true;
    }
    public int getVida() {
        return vida;
    }
    public int getAtaque() {
        return ataque = random.nextInt(10)+7;
    }
    public int getDefensa() {
        return defensa;
    }

    public int getVidaTotal() {
        return vidaTotal;
    }

    public int getCuracion() {
        return Curacion;
    }
    public boolean getSe_ha_eliminado() {
        return se_ha_eliminado;
    }
    public boolean getCuracion_disponible() {
        return curacion_disponible;
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
    public void setCuracion_disponible(boolean s){
        this.curacion_disponible = s;
    }
}
