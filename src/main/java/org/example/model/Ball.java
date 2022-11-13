package org.example.model;

public class Ball extends Figure {
    private Double radius;

    public Ball(Double radius) {
        this.setRadius(radius);
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
        return (4. / 3.) * Math.PI * Math.pow(radius, 3);
    }
}
