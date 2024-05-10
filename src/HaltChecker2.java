package src;

// HaltChecker para la simulación la decisión teórica de si el programa se detiene o no
public class HaltChecker2 {
    public static boolean doesProgramHalt(int input) {
        // Simulamos una condición específica para decidir si el programa se detiene o no.
        // Por ejemplo, si el número de entrada es menor que 1000, asumiremos que el programa no se detiene.
        return input < 1000;
    }
}
