package src;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private JPanel panel1;
    private JButton cronómetroButton;
    private JButton cuentaAtrásButton1;
    private UpCounterSingleton upCounter; // Agregamos una instancia de UpCounterSingleton
    private DownCounterSingleton downCounter; // Agregamos una instancia de DownCounterSingleton

    private void createUIComponents() {
        // TODO: place custom component creation code here
        cronómetroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón cronómetroButton
                if (upCounter == null) {
                    upCounter = new UpCounterBuilder().setInitialNumber(1).build();
                    // Iniciar el conteo en un hilo separado
                    new Thread(() -> {
                        try {
                            upCounter.countUp();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }).start();
                }
            }
        });

        cuentaAtrásButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para el botón cuentaAtrásButton1
                if (downCounter == null) {
                    downCounter = new DownCounterBuilder().setStartNumber(10).build();
                    // Iniciar el conteo en un hilo separado
                    new Thread(() -> downCounter.countDown()).start();
                }
            }
        });

        JFrame ventana = new JFrame("Mi Aplicación");
        ventana.add(panel1); // Agrega el panel con los botones a la ventana
        ventana.setSize(400, 200); // Tamaño de la ventana
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Cierra la aplicación al cerrar la ventana
        ventana.setVisible(true); // Muestra la ventana
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            App app = new App();
            app.createUIComponents();
        });
    }
}
