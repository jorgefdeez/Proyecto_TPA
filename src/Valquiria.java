import java.util.Random;

public class Valquiria extends Jugador {
    private boolean se_ha_eliminado;
    private int ataque;
    private int ataque_total;
    private int ataque_con_hacha;
    private int vida;
    private int atuendo_de_guerra;
    private int vidaTotal;
    private boolean se_esta_usando_transformacion_iracunda;
    private int duracion_transformacion_iracunda = 2;
    private boolean transformacion_iracunda_disponible;
    private Random random;

    public Valquiria(){
        ataque = 15;
        ataque_con_hacha = 15*2;
        vida = 100;
        atuendo_de_guerra = 50;   //la defensa se complementa a la vida.
        vidaTotal = vida + (atuendo_de_guerra/2); //+25 de armadura
        ataque_total = ataque+(atuendo_de_guerra/12);  //+4 de ataque
    }
    public int ataque_normal(int vida_enemigo){    //ataque basico.
        return vida_enemigo-ataque;
    }
    public int Ataque_con_hacha(int vida_enemigo){  //ataque especial, dos veces por partida.
        return vida_enemigo-ataque_con_hacha;
    }
    public int getVidaTotal() {
        return vidaTotal;
    }
    public boolean getSe_esta_usando_transformacion_iracunda(){
        return se_esta_usando_transformacion_iracunda;
    }
    public int getDuracion_transformacion_iracunda(){
        return duracion_transformacion_iracunda;
    }
    public boolean getTransformacion_iracunda_disponible() {
        return transformacion_iracunda_disponible;
    }
    public void setSe_esta_usando_transformacion_iracunda(boolean s){
         se_esta_usando_transformacion_iracunda = s;
    }
    public void setTransformacion_iracunda_disponible(boolean s){
        transformacion_iracunda_disponible = s;
    }
    public void setDuracion_transformacion_iracunda(int duracion){
        duracion_transformacion_iracunda = duracion;
    }
    public void setVidaTotal(int v){
        vidaTotal = v;
    }
    public void transformacion_iracunda(){  //habilidad especial, una vez por partida.
        int aux_vida = random.nextInt(20)+10;
        int aux_ataque = random.nextInt(8)+4;
        int num_aleatorio = random.nextInt(3) + 1;

        switch (num_aleatorio) {
            case 1:
                System.out.println("Ha aumentado la vida");
                vida = vida + aux_vida;  //aumento de vida
                break;
            case 2:
                System.out.println("Ha aumentado el ataque");
                ataque = ataque+aux_ataque;    //aumento de ataque
                break;
            case 3:
                vida = aux_vida/2;    //se aumenta la vida y el ataque de forma balanceada, ya que el aumento del ataque se mantiene toda la partida.
                ataque = ataque+aux_ataque;
                System.out.println("La vida a aumentado " + aux_vida/2 + " puntos y el ataque " + aux_ataque);
                break;

            default: break;
        }
    }

}
