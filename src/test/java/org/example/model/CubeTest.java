package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CubeTest {
    @Test
    void calculateArea_validInputData_Ok() {
        Double expected = 64.;
        Cube cube = new Cube(4.);
        assertEquals(expected, cube.calculateArea());
    }

    @Test
    void set_negativeLength_notOk() {
        Cube cube = new Cube(1.);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> cube.setEdge(-1.));
        assertTrue(exception.getMessage().contains("edge can't be:"));
    }

    @Test
    void createFigure_negativeLength_notOk() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Cube(-1.));
        assertTrue(exception.getMessage().contains("edge can't be:"));
    }
}
