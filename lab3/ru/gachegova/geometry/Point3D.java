package ru.gachegova.geometry;
import java.util.Objects;

public class Point3D extends Point {
    private final double z;

    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    public double getZ() {
        return z;
    }

    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        if (!super.equals(o))
            return false; // сначала сравниваем X и Y через родителя
        Point3D point3D = (Point3D) o;
        return Double.compare(point3D.z, z) == 0; // затем сравниваем Z
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), z);
    }

    @Override
    public Point3D clone() {
        return (Point3D) super.clone();
    }
}
