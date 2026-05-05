package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class MainTest {

    @Test
    public void testMainExecution() {
        // Executing the main method to verify that the entire Selenium flow completes without throwing unhandled exceptions.
        assertDoesNotThrow(() -> {
            Main.main(new String[]{});
        }, "The execution of the main method failed unexpectedly");
    }
}