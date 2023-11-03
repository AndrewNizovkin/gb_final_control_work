package registry.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Animal {
    private final String name;
    private final String birthDate;
    private final List<String> commands;
    private static int counter;

    /**
     * Constructor
     * @param name animal name
     * @param birthDate animal birthdate
     */
    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
        counter ++;
    }

    /**
     * Gets count added Animals
     * @return int
     */
    public static int getCounter() {
        return counter;
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
        stringBuilder.append("class: ").append(getTypeAnimal()).append(" ");
        stringBuilder.append("name: ").append(name).append(" ");
        stringBuilder.append("birthDate: ").append(birthDate).append(" ");
        stringBuilder.append("commands: ");
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(commands.get(i));
            if (i < commands.size() - 1) stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}

