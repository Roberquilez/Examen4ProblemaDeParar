package src;

class DownCounterSingleton {
    private static DownCounterSingleton instance;
    private int startNumber;

    private DownCounterSingleton(int startNumber) {
        this.startNumber = startNumber;
    }

    public static DownCounterSingleton getInstance(int startNumber) {
        if (instance == null) {
            instance = new DownCounterSingleton(startNumber);
        }
        return instance;
    }

    public void countDown() {
        for (int i = startNumber; i >= 0; i--) {
            if (i == 0) {
                System.out.println("Despegamos!");
            } else {
                System.out.println("Cuenta atrás: " + i);
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class DownCounterBuilder {
    private int startNumber;

    public DownCounterBuilder setStartNumber(int startNumber) {
        this.startNumber = startNumber;
        return this;
    }

    public DownCounterSingleton build() {
        return DownCounterSingleton.getInstance(startNumber);
    }
}


class HaltChecker {
    public static boolean haceProgramaHalt(int input) {
        return input > 100;
    }
}

public class DownCounterProgram {
    public static void main(String[] args) {
        DownCounterSingleton counter = new DownCounterBuilder()
                .setStartNumber(10)
                .build();

        counter.countDown();

        int inputNumber = 0;
        if (HaltChecker2.doesProgramHalt(inputNumber)) {
            System.out.println("El programa se detiene con la entrada: " + inputNumber);
        } else {
            System.out.println("El programa no se detiene con la entrada: " + inputNumber);
        }
    }
}
