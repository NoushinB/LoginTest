package noushin.hooks;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;

public class Hooks {

    @BeforeAll
    public static void setup() {

    }

    /**
     * Before hooks run before the first step of each scenario.
     */
    @Before
    public static void beforeTest() {

    }

    /**
     * After hooks run after the last step of each scenario,
     * even when the step result is failed, undefined, pending, or skipped.
     */
    @After
    public static void afterTest() {

    }

    @AfterAll
    public static void tearDown() {

    }
}
