package enemigos;

import enemigos.Enemigo;

import java.util.Random;
import java.util.Scanner;

public class Esbirro extends Enemigo {
    private boolean se_ha_eliminado;
    private Random random = new Random();
    private  Scanner scanner = new Scanner(System.in);

    public Esbirro(){

        setAtaque(random.nextInt(10)+15);
        setVida(100);
        setDefensa(10);   //la defensa se complementa a la vida.
        setVida_total(getVida() + getDefensa());
        se_ha_eliminado = false;
    }

    public boolean getSe_ha_eliminado() {
        return se_ha_eliminado;
    }

    public int getAtaque() {
        return random.nextInt(10)+15;
    }
    public void setSe_ha_eliminado(boolean S){
        this.se_ha_eliminado = S;
    }
}


