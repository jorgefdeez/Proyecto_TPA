import java.util.Scanner;

public class Mago{
    private boolean se_ha_eliminado;
    private int ataque;
    private int FireBall;
    private int vida;
    private int magia;
    private int ataquetotal;

    public Mago(){
        Scanner scanner = new Scanner(System.in);
        ataque = 17;
        magia = 7;
        ataquetotal = ataque + magia;
        FireBall = ataquetotal*2;
        vida = 100;
    }
    public void enfurecimiento(){
        ataque = ataque*2;
        //durante los siguientes 2 turnos, consume un turno.
    }
}
