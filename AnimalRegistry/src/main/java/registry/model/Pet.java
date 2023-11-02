package registry.model;

public abstract class Pet extends Animal{
    /**
     * Constructor
     *
     * @param name      animal name
     * @param birthDate animal birthdate
     */
    public Pet(String name, String birthDate) {
        super(name, birthDate);
    }
}
