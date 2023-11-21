package enemigos;

public class Enemigo {
    private int vida;
    private int ataque;
    private int defensa;
    private int vida_total;

    public void setVida(int v){this.vida = v;}
    public void setAtaque(int a){this.ataque = a;}
    public void setDefensa(int d){this.defensa = d;}
    public void setVida_total(int v) {this.vida_total = v;}

    public int getAtaque() {return ataque;}
    public int getDefensa() {return defensa;}
    public int getVida() {return vida;}
    public int getVida_total(){return vida_total;}
}
