class Angle {
    double angle;

    public Angle(double degrees) {
        this.angle = degrees;
    }

    public double toRad() {
        return angle * (Math.PI / 180);
    }
}

class Vector {
    double x, y;

    Vector() {
        this.x = 0;
        this.y = 0;
    }

    Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    Vector(double magnitude, Angle angle) {
        this.y = magnitude * Math.sin(angle.toRad());
        this.x = magnitude * Math.cos(angle.toRad());
    }

    Vector scalarMultiple(double multiple) {
        return new Vector(this.x * multiple, this.y * multiple);
    }

    Vector add(Vector b) {
        return new Vector(this.x + b.x, this.y + b.y);
    }

    Vector negate() {
        return new Vector(-this.x, -this.y);
    }

    double magnitude() {
        return Math.sqrt(x * x + y * y);
    }

    double angleDegrees() {
        double alpha = (Math.atan(Math.abs(y) / Math.abs(x))) * (180 / Math.PI);

        if (x > 0 && y > 0) return alpha;
        if (x < 0 && y > 0) return 180 - alpha;
        if (x < 0 && y < 0) return 180 + alpha;
        if (x > 0 && y < 0) return -alpha;
        return 0;
    }
}
