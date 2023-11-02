package registry.vew;

import registry.model.*;
import registry.presenter.AnimalsController;

import java.util.List;

public class AnimalsController1 implements AnimalsController {
    private List<Animal> animals;

    /**
     * Constructor
     * @param animals animal list
     */
    public AnimalsController1(List<Animal> animals) {
        this.animals = animals;
    }

    @Override
    public void addAnimal(int typeAnimal, String name, String birthDate) {
        switch (typeAnimal) {
            case 1 -> animals.add(new Cat(name, birthDate));
            case 2 -> animals.add(new Dog(name, birthDate));
            case 3 -> animals.add(new Hamster(name, birthDate));
            case 4 -> animals.add(new Camel(name, birthDate));
            case 5 -> animals.add(new Horse(name, birthDate));
            case 6 -> animals.add(new Donkey(name, birthDate));
            default -> System.out.println("Unknown type");
        }
    }

    @Override
    public void addCommands(String[] array, int index) {
        for (String command: array) {
            animals.get(index).getCommands().add(command);
        }
    }

    @Override
    public void sortAnimals(int sortMode) {

    }

    @Override
    public void printAnimalList() {
        animals.forEach(System.out::println);
    }

    @Override
    public List<Animal> getDemoAnimalList() {
        return null;
    }
}
