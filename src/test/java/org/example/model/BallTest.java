package org.example.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BallTest {
    @Test
    void calculateArea_validInputData_Ok() {
        Double expected = 268.082573106329;
        Ball ball = new Ball(4.);
        assertEquals(expected, ball.calculateArea());
    }

    @Test
    void set_negativeLength_notOk() {
        Ball ball = new Ball(1.);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> ball.setRadius(-1.));
        assertTrue(exception.getMessage().contains("radius can't be:"));
    }

    @Test
    void createFigure_negativeLength_notOk() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Ball(-1.));
        assertTrue(exception.getMessage().contains("radius can't be:"));
    }
}