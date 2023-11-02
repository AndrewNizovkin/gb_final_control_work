package registry.presenter;

import registry.model.Animal;

import java.util.List;

public interface AnimalsController {

    /**
     * Adds new Animal to registry
     * @param name animal name
     * @param birthDate animal birthdate
     */
    void addAnimal(int typeAnimal, String name, String birthDate);

    /**
     * Adds new commands to animal with index in animal list
     * @param array new commands array
     * @param index animal index
     */
    void addCommands(String[] array, int index);

    /**
     * Sort animal list
     * @param sortMode sort mode
     */
    void sortAnimals(int sortMode);

    /**
     * print animal list
     */
    void printAnimalList();

    /**
     * Gets demonstration animal list
     * @return List
     */
    List<Animal> getDemoAnimalList();

}
