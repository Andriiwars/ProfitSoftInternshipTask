package org.example.model;

public class Cube extends Figure {
    private Double edge;

    public Cube(Double edge) {
        this.setEdge(edge);
    }

    public Double getEdge() {
        return edge;
    }

    public void setEdge(Double edge) {
        if (edge <= 0) {
            throw new IllegalArgumentException("edge can't be:" + edge);
        }
        this.edge = edge;
    }

    @Override
    public Double calculateArea() {
        return Math.pow(edge, 3);
    }
}
