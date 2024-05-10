package src;

import static java.lang.Thread.sleep;
class UpCounterSingleton {
    private static UpCounterSingleton instance;
    private int number;

    private UpCounterSingleton(int initialNumber) {
        this.number = initialNumber;
    }

    public static UpCounterSingleton getInstance(int initialNumber) {
        if (instance == null) {
            instance = new UpCounterSingleton(initialNumber);
        }
        return instance;
    }

    public void countUp() throws InterruptedException {
        int minutes = 0;
        while (true) {
            System.out.println("Cronómetro en seg: " + number);
            sleep(1000);
            number++;

            if (number == 60) {
                minutes++;
                System.out.println(minutes + " minuto(s)");
                number = 0;
            }
        }
    }
}


class UpCounterBuilder {
    private int initialNumber;

    public UpCounterBuilder setInitialNumber(int initialNumber) {
        this.initialNumber = initialNumber;
        return this;
    }

    public UpCounterSingleton build() {
        return UpCounterSingleton.getInstance(initialNumber);
    }
}

public class UpCounterProgram {
    public static void main(String[] args) throws InterruptedException {
        UpCounterSingleton counter = new UpCounterBuilder()
                .setInitialNumber(1)
                .build();

        counter.countUp();

        int inputNumber = 800;
        if (HaltChecker2.doesProgramHalt(inputNumber)) {
            System.out.println("El programa se detiene con la entrada: " + inputNumber);
        } else {
            System.out.println("El programa no se detiene con la entrada: " + inputNumber);
        }
    }
}
