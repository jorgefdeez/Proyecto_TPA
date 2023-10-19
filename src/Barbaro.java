import java.util.Scanner;

public class Barbaro{
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
    public void enfurecimiento(){
        ataque = ataque*2;
        //durante los siguientes 2 turnos, consume un turno.
    }
}
