import java.util.Scanner;
import java.util.Random;

public class Mago extends Jugador {
    private boolean se_ha_eliminado;
    private int ataque;
    private int FireBall;
    private int vida;
    private int magia;
    private int ataquetotal;
    private boolean esta_disponible_vortice = true;
    private Random random = new Random();

    public Mago(){
        Scanner scanner = new Scanner(System.in);
        ataque = 17;
        magia = 7;
        ataquetotal = ataque + magia;
        FireBall = ataquetotal*2;
        vida = 100;
    }
    public int ataque_normal(int vida_enemigo){    //ataque basico.
        int vida_enemigo_despues_ataque_normal;
        vida_enemigo_despues_ataque_normal = vida_enemigo-ataquetotal;
        return vida_enemigo_despues_ataque_normal;
    }
    public int FireBall(int vida_enemigo){ //ataque especial.
        return vida_enemigo-FireBall;
    }
    public int voritce_de_energia(int vida_enemigo){   //hablidad especial
        int danio = (vida_enemigo*variable_aleatoria())/100;
        esta_disponible_vortice = false;
        return danio;
    }
    void setEsta_disponible_vortice(boolean s){
        esta_disponible_vortice = s;
    }
    public int variable_aleatoria(){
        int aux = random.nextInt(11) + 35;
        return aux;
    };
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVida() {
        return vida;
    }

    public int getAtaque() {
        return ataque;
    }
    public int getMagia(){
        return magia;
    }
    public int getAtaquetotal(){
        return ataquetotal;
    }
    public boolean getEsta_disponible_vortice() {
        return esta_disponible_vortice;
    }
}
