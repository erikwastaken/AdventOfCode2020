package com.erik.day24;

import java.util.Objects;

public class Vector3 {
    public final int x;
    public final int y;
    public final int z;

    public Vector3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Vector3 multiplyScalar(int s) {
        return new Vector3(this.x * s, this.y * s, this.z * s);
    }
    public int multiplyVector(Vector3 f) {
        return this.x * f.x + this.y * f.y + this.z * f.z;
    }

    public Vector3 add(Vector3 f) {
        return new Vector3(this.x + f.x, this.y + f.y, this.z + f.z);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector3 vector3 = (Vector3) o;
        return x == vector3.x && y == vector3.y && z == vector3.z;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, z);
    }
}
