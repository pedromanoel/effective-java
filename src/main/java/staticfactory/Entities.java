package staticfactory;

/**
 * Static Factory class that uses the conventional plural naming for
 * interface based libraries
 */
public class Entities {

    private static final Entity unnamedInstance = new UnnamedEntity();

    // Suppresses default constructor, ensuring non-instantiability.
    private Entities() { }

    /**
     * Also creates a named entity, but the method name is more expressive.
     *
     * @param name The name of the entity
     *
     * @return A new named entity
     */
    public static Entity newNamed(String name) {
        return new NamedEntity(name);
    }

    /**
     * Also creates an unnamed entity, but the method name is more expressive.
     *
     * Furthermore, this static factory always returns the same instance. The book calls this pattern
     * "instance-controlled classes". Avdi Grimm calls it "Singleton Objects", because there is no difference between
     * two instances of this class. Since the created object are stateless, it is safe to always use the same instance
     * throughout the program.
     *
     * Boolean.valueOf(boolean) also does the same, as well as Enum types.
     *
     * @return A new unnamed entity.
     */
    public static Entity newUnnamed() {
        return unnamedInstance;
    }
}
