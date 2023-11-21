import javax.swing.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        ArrayList<Jugador> listaJugadores = new ArrayList<>();

        int cantidadJugadores = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos jugadores van a ser?"));

        for (int i = 0; i < cantidadJugadores; i++) {
            Jugador jugador = new Jugador();
            jugador.solicitarDatos();

            String heroeSeleccionado = jugador.getEleccionHeroe();

            if (heroeSeleccionado.equals("Valquiria")) {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al juego " + jugador.getNombre() + ", eres una " + heroeSeleccionado + "!");
            } else {
                JOptionPane.showMessageDialog(null, "¡Bienvenido al juego " + jugador.getNombre() + ", eres un " + heroeSeleccionado + "!");
            }

            MecanicaJuego juego = new MecanicaJuego();
            juego.jugar(heroeSeleccionado);

            String resultado = juego.hasta_donde_llego_jugador();
            jugador.setResultado(resultado);
            listaJugadores.add(jugador);
        }

        StringBuilder registroPartida = new StringBuilder("*******REGISTRO DE PARTIDA*******\n");

        for (Jugador jugador : listaJugadores) {
            registroPartida.append("Nombre: ").append(jugador.getNombre()).append("\n");
            registroPartida.append("ID: ").append(jugador.getID()).append("\n");
            registroPartida.append("Resultado: ").append(jugador.getResultado()).append("\n\n");
        }

        JOptionPane.showMessageDialog(null, registroPartida.toString());
    }
}
