import java.util.Random;

public class Valquiria extends Jugador{
    private boolean se_ha_eliminado;
    private int ataque;
    private int ataque_total;
    private int ataque_con_hacha;
    private int vida;
    private int atuendo_de_guerra;
    private int vidaTotal;
    private Random random;

    public Valquiria(){
        ataque = 15;
        ataque_con_hacha = 15*2;
        vida = 100;
        atuendo_de_guerra = 50;   //la defensa se complementa a la vida.
        vidaTotal = vida + atuendo_de_guerra/2; //+25 de armadura
        ataque_total = ataque+atuendo_de_guerra/12;  //+4 de ataque
    }
    @Override
    public void ataque_normal(int vida_enemigo){    //ataque basico.
        vida_enemigo = vida_enemigo-ataque;
    }
    public void ataque_con_hacha(int vida_enemigo){ //ataque especial, dos veces por partida.
        vida_enemigo = vida_enemigo-ataque_con_hacha;
    }
    public void transformacion_iracunda(){  //habilidad especial, una vez por partida.
        int aux_vida = random.nextInt(20)+10;
        int aux_ataque = random.nextInt(8)+4;
        int num_aleatorio = random.nextInt(3) + 1;

        switch (num_aleatorio) {
            case 1:
                vida = vida + aux_vida;  //aumento de vida
                break;
            case 2:
                ataque = ataque+aux_ataque;    //aumento de ataque
                break;
            case 3:
                aux_vida = aux_vida/2;    //se aumenta la vida y el ataque de forma balanceada, ya que el aumento del ataque se mantiene toda la partida.                vida = vida+aux;
                ataque = ataque+aux_ataque;
                break;
        }
    }
}
