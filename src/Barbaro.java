import java.util.Scanner;

public class Barbaro extends Jugador{
    private boolean se_ha_eliminado;
    private int ataque;
    private int ataque_de_espada;
    private int vida;
    private int armadura;
    private int vidaTotal;

    public Barbaro(){
        Scanner scanner = new Scanner(System.in);
        ataque = 17;
        ataque_de_espada = 17*2;
        vida = 100;
        armadura = 50;   //la defensa se complementa a la vida.
        vidaTotal = vida + armadura;
    }
    @Override
    public void ataque_normal(int vida_enemigo){    //ataque basico.
        vida_enemigo = vida_enemigo-ataque;
    }
    public void setAtaque_de_espada(int vida_enemigo){  //ataque especial, dos veces por partida.
        vida_enemigo = vida_enemigo-ataque_de_espada;
    }
    public void enfurecimiento(){   //habilidad especial, una vez por partida.
        ataque = ataque*2;
        //durante los siguientes 2 turnos, consume un turno.
    }
}
