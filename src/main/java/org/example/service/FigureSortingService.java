package org.example.service;

import java.util.List;
import org.example.model.Figure;

public interface FigureSortingService {
    List<Figure> sortFiguresByArea(List<Figure> figures);
}
