package registry.presenter;

import registry.model.Animal;
import registry.vew.AnimalsController1;
import registry.vew.ConsoleReader1;

import java.util.LinkedList;
import java.util.List;

public class AnimalRegistry {
    private List<Animal> animals;
    private ConsoleReader consoleReader;
    private AnimalsController animalsController;

    /**
     * Constructor
     */
    public AnimalRegistry() {
        animals = new LinkedList<>();
        consoleReader = new ConsoleReader1();
        animalsController = new AnimalsController1(animals);
    }

    /**
     * Starts program
     */
    public void run() {
        int choice = menu();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    System.out.println("choice: 1");
                }
                case 2 -> {
                    System.out.println("choice: 2");
                }
                case 3 -> {
                    System.out.println("choice: 3");
                }
                case 4 -> {
                    System.out.println("choice: 4");
                }
            }
            choice = menu();
        }
        System.out.println("The End.");
    }

    /**
     * Main menu
     * @return int user choice
     */
    private int menu() {
        return consoleReader.getNumberFromConsole("[0] Exit    [1] Add Animal  [2] Load Demo\n[3] Change" +
                "  [4] Sort\n");
    }
}
