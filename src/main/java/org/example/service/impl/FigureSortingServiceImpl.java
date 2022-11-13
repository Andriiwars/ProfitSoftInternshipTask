package org.example.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.example.model.Figure;
import org.example.service.FigureSortingService;

public class FigureSortingServiceImpl implements FigureSortingService {
    @Override
    public List<Figure> sortFiguresByArea(List<Figure> figures) {
        return figures.stream()
                .sorted(Comparator.comparing(Figure::calculateArea))
                .collect(Collectors.toList());
    }
}
