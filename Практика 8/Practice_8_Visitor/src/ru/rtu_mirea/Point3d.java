package ru.rtu_mirea;

public class Point3d extends Point{
    private double x, y, z;
    @Override
    public void accept(Visitor v) {
        v.visit(this);
    }
    public Point3d(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }
}
