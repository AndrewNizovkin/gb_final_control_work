package registry.model;

public abstract class PackAnimal extends Animal{
    /**
     * Constructor
     *
     * @param name      animal name
     * @param birthDate animal birthdate
     */
    public PackAnimal(String name, String birthDate) {
        super(name, birthDate);
    }
}
