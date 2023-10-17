import java.util.Random;
import java.util.Scanner;
public class Dragon extends Enemigo{
    private boolean se_ha_eliminado;
    public void setSe_ha_eliminado(boolean _se_ha_eliminado){
        this.se_ha_eliminado = _se_ha_eliminado;
    }
    public boolean getSe_ha_eliminado_jefe() {
        return super.getSe_ha_eliminado_jefe();
    }
    public void SetataqueBasico() {
        Random random = new Random();
        int a = random.nextInt(15)+10;
    }
    public void setVida() {
        int v = 120;
        super.setVida(v);
    }

}
