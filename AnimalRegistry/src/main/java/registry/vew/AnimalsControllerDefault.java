package registry.vew;

import registry.model.*;
import registry.presenter.AnimalsController;
import registry.presenter.IOController;
import registry.presenter.Parser;

import java.util.List;

public class AnimalsControllerDefault implements AnimalsController {
    private final List<Animal> animals;
    private final IOController ioController;
    private final Parser parser;


    /**
     * Constructor
     * @param animals animal list
     */
    public AnimalsControllerDefault(List<Animal> animals) {
        this.animals = animals;
        ioController = new IOControllerDefault();
        parser = new ParserDefault();
    }

    /**
     * Adds new Animal to registry
     *
     * @param line "name typeAnimal birthDate command1 command2"
     */
    @Override
    public void addAnimal(String line) {
        String[] array = line.split(" ");
        if (array.length < 3) {
            System.out.println("Error! Incomplete data");
        } else {
            if (!parser.isValidData(array[2])) {
                System.out.println("Error! Incorrect date");
            } else {
                addAnimal(array);
            }

        }
    }

    @Override
    public void addCommands(String[] array, int index) {
        for (String command: array) {
            animals.get(index).getCommands().add(command);
        }
    }

    @Override
    public void sortAnimals() {
            animals.sort(new DataComparatorDefault());
    }

    @Override
    public void printAnimalList() {
        for (int i = 0; i < animals.size(); i++) {
            System.out.printf("<%d> %s\n", i, animals.get(i));
        }
    }

    /**
     * Adds Animal to animals
     * @param array [name, typeAnimal, birthDate, command1, command2]
     */
    private void addAnimal(String[] array) {
        Animal animal = null;
        switch (array[1]) {
            case "Cat" -> animal = new Cat(array[0],array[2]);
            case "Dog" -> animal = new Dog(array[0],array[2]);
            case "Hamster" -> animal = new Hamster(array[0],array[2]);
            case "Camel" -> animal = new Camel(array[0],array[2]);
            case "Horse" -> animal = new Horse(array[0],array[2]);
            case "Donkey" -> animal = new Donkey(array[0],array[2]);
        }
        if (animal != null && array.length > 3) {
            for (int i = 3; i < array.length; i++) {
                animal.getCommands().add(array[i]);
            }
            animals.add(animal);
        } else {
            System.out.println("the type of animal is not defined");
        }

    }

    /**
     * Loads demo-list to animal list
     */
    @Override
    public void LoadDemoAnimalList() {
        animals.clear();
        List<String> list = ioController.readFile("./animals.txt");
        String separator = ",";
        String[] array;
        while (!list.isEmpty()) {
            array = list.remove(0).split(separator);
            addAnimal(array);
        }
    }

}
