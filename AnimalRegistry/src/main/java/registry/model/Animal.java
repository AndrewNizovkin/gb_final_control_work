package registry.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private String name;
    private String birthDate;
    private List<String> commands;

    /**
     * Constructor
     * @param name animal name
     * @param birthDate animal birthdate
     */
    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    /**
     * Gets animal name
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * Gets animal birthdate
     * @return String
     */
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Gets animal command list
     * @return List
     */
    public List<String> getCommands() {
        return commands;
    }

    /**
     * Gets animal type
     * @return String
     */
    public String getTypeAnimal() {
        return this.getClass().getSimpleName();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getTypeAnimal() + " ");
        stringBuilder.append(name + " ");
        stringBuilder.append(birthDate + " ");
        commands.forEach(x -> stringBuilder.append(x + " "));
        return stringBuilder.toString();
    }
}

