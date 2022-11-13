package org.example.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CylinderTest {
    @Test
    void calculateArea_validInputData_Ok() {
        Double expected = 150.79644737231007;
        Cylinder cylinder = new Cylinder(3.,4.);
        assertEquals(expected, cylinder.calculateArea());
    }

    @Test
    void set_negativeRadius_notOk() {
        Cylinder cylinder = new Cylinder(1.,1.);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> cylinder.setRadius(-1.));
        assertTrue(exception.getMessage().contains("radius can't be:"));
    }

    @Test
    void createFigure_negativeRadius_notOk() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cylinder(1.,-1.));
        assertTrue(exception.getMessage().contains("radius can't be:"));
    }

    @Test
    void set_negativeHeight_notOk() {
        Cylinder cylinder = new Cylinder(1.,1.);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> cylinder.setHeight(-1.));
        assertTrue(exception.getMessage().contains("height can't be:"));
    }

    @Test
    void createFigure_negativeHeight_notOk() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> new Cylinder(-1.,1.));
        assertTrue(exception.getMessage().contains("height can't be:"));
    }
}