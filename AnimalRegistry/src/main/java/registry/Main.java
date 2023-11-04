package registry;

import registry.model.Animal;
import registry.presenter.AnimalRegistry;
import registry.presenter.AnimalsController;
import registry.presenter.ConsoleReader;
import registry.vew.AnimalsControllerDefault;
import registry.vew.ConsoleReaderDefault;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Run without parameters
//        new AnimalRegistry().run();

        // Run with parameters
        List<Animal> animals = new ArrayList<>();
        ConsoleReader consoleReader = new ConsoleReaderDefault();
        AnimalsController animalsController = new AnimalsControllerDefault(animals);

        new AnimalRegistry(animals, consoleReader, animalsController).run();
    }
}
