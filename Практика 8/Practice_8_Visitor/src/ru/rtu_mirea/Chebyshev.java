package ru.rtu_mirea;

public class Chebyshev  implements Visitor {
    @Override
    public void visit(Point2d p) {
        double ax = Math.abs(p.getX());
        double ay = Math.abs(p.getY());
        p.setMetric(ax > ay ? ax : ay);
    }

    @Override
    public void visit(Point3d p) {
        double ax = Math.abs(p.getX());
        double ay = Math.abs(p.getY());
        double az = Math.abs(p.getZ());
        double max = ax > ay ? ax : ay;
        if (max < az) max = az;
        p.setMetric(max);
    }
}
