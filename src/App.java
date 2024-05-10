package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JFrame ventanaPrincipal; // Ventana principal
    private JPanel panel1;
    private JButton cronómetroButton;
    private JButton cuentaAtrásButton1;

    public App() {
        createUIComponents();
    }

    private void createUIComponents() {
        // Configurar la ventana principal
        ventanaPrincipal = new JFrame("Mi Aplicación");
        ventanaPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventanaPrincipal.setSize(400, 200);

        // Configurar el panel con los botones
        panel1 = new JPanel();
        cronómetroButton = new JButton("Cronómetro");
        cuentaAtrásButton1 = new JButton("Cuenta atrás");

        // Agregar los botones al panel
        panel1.add(cronómetroButton);
        panel1.add(cuentaAtrásButton1);

        // Configurar los eventos de los botones
        cronómetroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar la función del cronómetro
                ejecutarFuncionCronometro();
            }
        });

        cuentaAtrásButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ejecutar la función de la cuenta atrás
                ejecutarFuncionCuentaAtras();
            }
        });

        // Agregar el panel a la ventana principal
        ventanaPrincipal.add(panel1);
    }

    private void ejecutarFuncionCronometro() {
        // Lógica específica para la función del cronómetro
        System.out.println("Ejecutando función del cronómetro...");
        // Por ejemplo, podrías iniciar el conteo o realizar otras acciones relacionadas con el cronómetro.
    }

    private void ejecutarFuncionCuentaAtras() {
        // Lógica específica para la función de la cuenta atrás
        System.out.println("Ejecutando función de la cuenta atrás...");
        // Por ejemplo, podrías iniciar la cuenta atrás o realizar otras acciones relacionadas con ella.
    }

    public void mostrarVentanaPrincipal() {
        ventanaPrincipal.setVisible(true); // Mostrar la ventana principal
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.mostrarVentanaPrincipal();
        });
    }
}
