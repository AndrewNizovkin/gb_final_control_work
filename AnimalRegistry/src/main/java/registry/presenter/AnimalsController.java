package registry.presenter;

import registry.model.Animal;

import java.util.List;

public interface AnimalsController {

    /**
     * Adds new Animal to registry
     * @param line "name typeAnimal birthDate command1 command2"
     */
    void addAnimal(String line);

    /**
     * Adds new commands to animal with index in animal list
     * @param array new commands array
     * @param index animal index
     */
    void addCommands(String[] array, int index);

    /**
     * Sort animal list
     */
    void sortAnimals();

    /**
     * print animal list
     */
    void printAnimalList();

    /**
     * Loads animal list with demo
     */
    void LoadDemoAnimalList();

}
