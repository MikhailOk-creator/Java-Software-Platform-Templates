package ru.rtu_mirea;

public class Point2d extends Point{
    private double x, y;
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public Point2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
