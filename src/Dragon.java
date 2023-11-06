import java.util.Random;
import java.util.Scanner;

public class Dragon extends Enemigo{
    private boolean se_ha_eliminado;
    private int Escupe_Fuego;
    private boolean Escupe_Fuego_Disponible;
    private Random random = new Random();
    public Dragon(){
        Scanner scanner = new Scanner(System.in);

        setAtaque(random.nextInt(10)+20);
        Escupe_Fuego = random.nextInt(15)+25;
        setVida(120);
        setDefensa(0); //la defensa se complementa a la vida.;
        setVida_total(getVida() + getDefensa());

        Escupe_Fuego_Disponible = true;
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
    public void setSe_ha_eliminado(boolean S){
        this.se_ha_eliminado = S;
    }
    public void setEscupe_Fuego_Disponible(boolean s){
        Escupe_Fuego_Disponible = s;
    }
}
