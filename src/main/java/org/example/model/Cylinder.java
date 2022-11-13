package org.example.model;

public class Cylinder extends Figure {
    private Double height;
    private Double radius;

    public Cylinder(Double height, Double radius) {
        this.setHeight(height);
        this.setRadius(radius);
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        if (height < 0) {
            throw new IllegalArgumentException("height can't be:" + height);
        }
        this.height = height;
    }

    public Double getRadius() {
        return radius;
    }

    public void setRadius(Double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("radius can't be:" + radius);
        }
        this.radius = radius;
    }

    @Override
    public Double calculateArea() {
        return Math.PI * Math.pow(radius, 2) * height;
    }
}
