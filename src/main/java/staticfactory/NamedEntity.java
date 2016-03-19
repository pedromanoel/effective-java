package staticfactory;

/**
 * This class was created in order to exercise the Static Factory pattern.
 */
public class NamedEntity implements Entity {

    @Override
    public String getName() {
        return name;
    }

    public final String name;

    /**
     * Creates a named entity.
     *
     * @param name The name of the entity
     */
    public NamedEntity(String name) {
        this.name = name;
    }
}
