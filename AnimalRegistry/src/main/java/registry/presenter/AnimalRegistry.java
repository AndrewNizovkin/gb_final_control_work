package registry.presenter;

import registry.model.Animal;
import registry.vew.AnimalsControllerDefault;
import registry.vew.ConsoleReaderDefault;
import java.util.LinkedList;
import java.util.List;

public class AnimalRegistry {
    private final List<Animal> animals;
    private final ConsoleReader consoleReader;
    private final AnimalsController animalsController;

    /**
     * Constructor
     */
    public AnimalRegistry() {
        animals = new LinkedList<>();
        consoleReader = new ConsoleReaderDefault();
        animalsController = new AnimalsControllerDefault(animals);
    }

    /**
     * Starts program
     */
    public void run() {
        int index;
        int choice = menuMain();
        while (choice != 0) {
            switch (choice) {
                case 1 -> {
                    animalsController.addAnimal(consoleReader.getStringFromConsole("Enter data separated by a space:\n" +
                            "name\ntypeAnimal: (Dog, Cat, Hamster, Camel, Horse, Donkey)\nbirthDate: YYYY-MM-DD\n" +
                            "commands: commands separated by a space\n"));
                }
                case 2 -> {
                    animalsController.LoadDemoAnimalList();
                    animalsController.printAnimalList();
                }
                case 3 -> {
                    index = consoleReader.getNumberFromConsole("Enter <index> animal");
                    if (index < animals.size()) {
                        animalsController.addCommands(consoleReader.getStringFromConsole("Enter commands " +
                                "separated by a space").split(" "), index);
                    }
                }
                case 4 -> {
                    animalsController.sortAnimals();
                }
            }
            choice = menuMain();
        }
        System.out.println("The End.");
    }

    /**
     * Main menu
     * @return int user choice
     */
    private int menuMain() {
        animalsController.printAnimalList();
        System.out.println("-".repeat(45));
        System.out.println("total number of animals: <" + Animal.getCounter() + ">");
        System.out.println("-".repeat(45));
        return consoleReader.getNumberFromConsole("[0] Exit    [1] Add Animal      [2] Load Demo\n[3] Change" +
                "  [4] Sort BirthDate\n");
    }


}
