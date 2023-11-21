package enemigos;

import enemigos.Enemigo;

import java.util.Random;
import java.util.Scanner;

public class Gigante extends Enemigo {
    private boolean se_ha_eliminado;
    private boolean curacion_disponible;
    private int curacion;
    private Random random = new Random();

    public Gigante(){
        Scanner scanner = new Scanner(System.in);
        setAtaque(random.nextInt(10)+7);
        setVida(100);
        setDefensa(50);   //la defensa se complementa a la vida.
        setVida_total(getVida() + getDefensa());
        curacion = 40;
        se_ha_eliminado =  false;
        curacion_disponible = true;
    }

    public int getCuracion() {
        return curacion;
    }
    public boolean getSe_ha_eliminado() {
        return se_ha_eliminado;
    }
    public boolean getCuracion_disponible() {
        return curacion_disponible;
    }


    public void setSe_ha_eliminado(boolean S){
        this.se_ha_eliminado = S;
    }
    public void setCuracion_disponible(boolean s){
        this.curacion_disponible = s;
    }
}
