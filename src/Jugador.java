import javax.swing.*;
import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class Jugador {
    private String nombre;
    private int ID;
    private int nivelXP;
    private String resultado;
    private String eleccionHeroe;
    private int vida;
    private int ataque;
    private boolean estaEliminado;

    private static Set<Integer> idsUtilizados = new HashSet<>();

    public String getNombre() {
        return nombre;
    }

    public int getID() {
        return ID;
    }

    public int getNivelXP() {
        return nivelXP;
    }

    public boolean getEsta_eliminado() {
        return estaEliminado;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String s){
        resultado = s;
    }

    public String getEleccionHeroe() {
        return eleccionHeroe;
    }

    public void setEsta_eliminado(boolean s){
        estaEliminado = s;
    }

    public void solicitarDatos() {
        // Crear un panel para la entrada de datos
        JPanel panel = new JPanel(new GridLayout(0, 2));
        JTextField nombreField = new JTextField(10);
        JTextField idField = new JTextField(10);
        JComboBox<String> heroeComboBox = new JComboBox<>(new String[]{"Barbaro", "Mago", "Valquiria"});

        panel.add(new JLabel("Nombre:"));
        panel.add(nombreField);
        panel.add(new JLabel("ID (4 números enteros):"));
        panel.add(idField);
        panel.add(new JLabel("Selecciona un héroe:"));
        panel.add(heroeComboBox);

        // Mostrar el panel y recoger los datos
        int result = JOptionPane.showConfirmDialog(null, panel, "Introduce los datos del jugador", JOptionPane.OK_CANCEL_OPTION);
        if (result == JOptionPane.OK_OPTION) {
            nombre = nombreField.getText();

            // Validar que el ID tenga exactamente 4 dígitos
            try {
                int idInput = Integer.parseInt(idField.getText());
                if (String.valueOf(idInput).length() != 4 || idsUtilizados.contains(idInput)) {
                    throw new NumberFormatException();
                }
                ID = idInput;
                idsUtilizados.add(ID);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Introduce un ID válido de 4 y que no exista", "Error", JOptionPane.ERROR_MESSAGE);
                // Llamada recursiva para permitir al usuario ingresar el ID correcto
                solicitarDatos();
            }

            eleccionHeroe = (String) heroeComboBox.getSelectedItem();
        } else {
            JOptionPane.showMessageDialog(null, "La operación fue cancelada.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            // Puedes lanzar una excepción o realizar otras acciones según tus necesidades
        }
    }
}
