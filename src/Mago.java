import java.util.Scanner;
import java.util.Random;

public class Mago extends Jugador{
    private boolean se_ha_eliminado;
    private int ataque;
    private int FireBall;
    private int vida;
    private int magia;
    private int ataquetotal;
    private Random random;

    public Mago(){
        Scanner scanner = new Scanner(System.in);
        ataque = 17;
        magia = 7;
        ataquetotal = ataque + magia;
        FireBall = ataquetotal*2;
        vida = 100;
    }
    @Override
    public void ataque_normal(int vida_enemigo){    //ataque basico.
        vida_enemigo = vida_enemigo-ataque;
    }
    public void FireBall(int vida_enemigo){ //ataque especial.
        vida_enemigo = vida_enemigo-FireBall;
    }
    public void voritce_de_energia(int vida_enemigo){   //hablidad especial
        int aux = random.nextInt(25)+15;
        int danio = (vida_enemigo*aux)/100;
        vida_enemigo = vida_enemigo - danio;    //le roba un porcentaje de la vida entre el 25 y 40% y se cura.
        vida = vida + danio/2;  //se cura la mitad del daño ocasionado con el vortice.

    }
}
