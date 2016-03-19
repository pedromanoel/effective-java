import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Collections;

import org.junit.Test;

import staticfactory.Entities;
import staticfactory.Enum;
import staticfactory.NamedEntity;
import staticfactory.UnnamedEntity;

/**
 * Created by team-tw on 3/18/16.
 */
public class StaticFactoryTest {

    @Test
    public void staticFactoriesHaveExpressiveNames() {
        assertThat(Entities.newUnnamed().getName(), is(nullValue()));
        assertThat(Entities.newNamed("A name").getName(), is("A name"));
    }

    @Test
    /**
     * Shows that static factories can control instantiation, but constructors cannot.
     */
    public void staticFactoriesCanAlwaysReturnTheSameObject() {
        assertThat(Entities.newUnnamed(), is(sameInstance(Entities.newUnnamed())));
        assertThat(new UnnamedEntity(), is(not(sameInstance(new UnnamedEntity()))));
    }

    @Test
    /**
     * Libraries from the Java Class Library utilizes the pattern of static factories that return
     * the same instance
     */
    public void classesFromJCLAlsoReturnTheSameObject() {
        assertThat(Enum.ONE, is(sameInstance(Enum.ONE)));
        assertThat(Boolean.valueOf(false), is(sameInstance(Boolean.valueOf("false"))));
        assertThat(Collections.emptyList(), is(sameInstance(Collections.emptyList())));
    }

    @Test
    public void staticFactoriesCanReturnDifferentTypes() {
        assertThat(Entities.newUnnamed(), is(instanceOf(UnnamedEntity.class)));
        assertThat(Entities.newNamed("Some name"), is(instanceOf(NamedEntity.class)));
    }

    @Test
    /**
     * Libraries from the Java Class Library utilizes the pattern of returning private types that implement a certain
     * Interface
     */
    public void classesFromJCLAlsoReturnDifferentTypes() {
        // IDK how to test this, but java.util.Collections do this sort of thing.
        assertTrue(true);

        Collections.emptyMap(); // returns an instance of a private class EmptyMap
        Collections.singletonMap(1, "one"); // returns an instance of the private class SingletonMap
    }

}