public class Enemigo {
    private int vida;
    private int ataque;
    private int defensa;
    private boolean se_han_eliminado_todos_enemigos_comunes; //para poder acceder al primer mini  jefe.
    private boolean se_han_eliminado_todos_minijefes; //para poder acceder al jefe final.
    private boolean se_ha_eliminado_jefe;   //para poder saber si ha ganado el jugador.

    public void setVida(int v){
        this.vida = v;
    }
    public void setAtaque(int a){
        this.ataque = a;
    }
    public void setDefensa(int d){
        this.defensa = d;
    }
    public void SetSe_han_eliminado_todos_enemigos_comunes(boolean se_han_eliminado_todos_comunes) {
        this.se_han_eliminado_todos_enemigos_comunes = se_han_eliminado_todos_comunes;
    }
    public void setSe_han_eliminado_todos_minijefes(boolean se_han_eliminado_todos_minijefes) {
        this.se_han_eliminado_todos_minijefes = se_han_eliminado_todos_minijefes;
    }
    public void setSe_ha_eliminado_jefe(boolean se_ha_eliminado_jefe) {
        this.se_ha_eliminado_jefe = se_ha_eliminado_jefe;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////
    public int getAtaqueBasico() {
        return ataque;
    }
    public int getDefensa() {
        return defensa;
    }
    public int getVida() {
        return vida;
    }
    public boolean getSe_han_eliminado_todos_enemigos_comunes() {
        return se_han_eliminado_todos_enemigos_comunes;
    }
    public boolean getSe_han_eliminado_todos_minijefes() {
        return se_han_eliminado_todos_minijefes;
    }
    public boolean getSe_ha_eliminado_jefe() {
        return se_ha_eliminado_jefe;
    }
}
