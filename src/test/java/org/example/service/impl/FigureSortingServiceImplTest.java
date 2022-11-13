package org.example.service.impl;

import org.example.model.Ball;
import org.example.model.Cube;
import org.example.model.Cylinder;
import org.example.model.Figure;
import org.example.service.FigureSortingService;
import org.junit.jupiter.api.Test;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FigureSortingServiceImplTest {

    private final FigureSortingService figureSortingService = new FigureSortingServiceImpl();
    @Test
    void sortFigureByArea_sameFigures_ok() {
        Figure cube1 = new Cube(2.0);
        Figure cube2 = new Cube(4.0);
        Figure cube3 = new Cube(6.0);
        List<Figure> figures = List.of(cube3, cube1, cube2);
        List<Figure> expected = List.of(cube1, cube2, cube3);
        assertEquals(expected, figureSortingService.sortFiguresByArea(figures));
    }

    @Test
    void sortFigureByArea_oneFigure_ok() {
        Figure cube = new Cube(2.0);
        List<Figure> figures = List.of(cube);
        List<Figure> expected = List.of(cube);
        assertEquals(expected, figureSortingService.sortFiguresByArea(figures));
    }

    @Test
    void sortFigureByArea_validInputData_ok() {
        Figure cube = new Cube(2.0);
        Figure ball = new Ball(4.0);
        Figure cylinder = new Cylinder(4.0, 4.0);
        List<Figure> figures = List.of(ball, cylinder, cube);
        List<Figure> expected = List.of(cube, cylinder, ball);
        assertEquals(expected, figureSortingService.sortFiguresByArea(figures));
    }

    @Test
    void sortFigureByArea_emptyList_ok() {
        List<Figure> figures = Collections.emptyList();
        List<Figure> expected = Collections.emptyList();
        assertEquals(expected, figureSortingService.sortFiguresByArea(figures));
    }
}
