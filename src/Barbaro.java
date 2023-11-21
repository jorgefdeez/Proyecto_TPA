import java.util.Scanner;

public class Barbaro extends Jugador {
    private boolean se_ha_eliminado;
    private int ataque;
    private int ataque_de_espada;
    private int vida;
    private int armadura;
    private int vidaTotal;
    private boolean enfurecimiento_disponible = true;
    private boolean se_esta_usando_enfurecimiento = false;
    private int duracion_enfurecimiento = 2;


    public Barbaro(){
        Scanner scanner = new Scanner(System.in);
        ataque = 17;
        ataque_de_espada = 17*2;
        vida = 100;
        armadura = 50;   //la defensa se complementa a la vida.
        vidaTotal = vida + armadura;
    }
    public int ataque_normal(int vida_enemigo){    //ataque basico.
        return vida_enemigo-ataque;
    }
    public int Ataque_de_espada(int vida_enemigo){  //ataque especial, dos veces por partida.
        return vida_enemigo-ataque_de_espada;
    }
    public void enfurecimiento(){   //habilidad especial, una vez por partida.
        se_esta_usando_enfurecimiento = true;
    }
    public int ataque_normal_enfuerecido(int vida_enemigo){    //ataque enfurecido x2 de daño.
        int vida_enemigo_despues_ataque_normal;
        vida_enemigo_despues_ataque_normal = vida_enemigo-(ataque*2);
        return vida_enemigo_despues_ataque_normal;
    }
    public void setSe_esta_usando_enfurecimiento(boolean s){
        se_esta_usando_enfurecimiento = s;
    }
    public void setEnfurecimiento_disponible(boolean s){
        enfurecimiento_disponible = s;
    }
    public int getVidaTotal() {
        return vidaTotal;
    }
    public boolean getSe_esta_usando_enfurecimiento(){
        return se_esta_usando_enfurecimiento;
    }
    public int getDuracion_enfurecimiento(){
        return duracion_enfurecimiento;
    }
    public void setDuracion_enfurecimiento(int duracion){
        duracion_enfurecimiento = duracion;
    }

    public boolean getEnfurecimiento_disponible() {
        return enfurecimiento_disponible;
    }
    public void setVidaTotal(int v){
        vidaTotal = v;
    }
}
