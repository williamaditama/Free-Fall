/*
x = xo + vt
v = vo + at
x = xo +vot + 1/2 at^2
v^2 = vo^2 + 2a(x-xo)
 */

public class MotionEquations {
    static Vector xf(Vector x0, Vector v0, double t) {
        return x0.add(v0.scalarMultiple(t));
    }

    static double xf(double x0, double v0, double t) {
        return x0 + v0 * t;
    }

    static Vector xf(Vector x0, Vector v0, Vector a, double t) {
        Vector v0t = v0.scalarMultiple(t);
        Vector at_sqared_over2 = a.scalarMultiple(0.5).scalarMultiple(t * t);

        return v0t.add(at_sqared_over2);
    }

    static Vector vf(Vector v0, Vector a, double t) {
        return v0.add(a.scalarMultiple(t));
    }

//    static double t(Vector x, Vector x0, Vector v0, Vector a) {
//        double dist = x.add(x0.negate()).magnitude();
//    }

    static double solvePositiveRoot(double a, double b, double c) {
        double num1 = -b + Math.sqrt(b * b - 4 * a * c);
        double den = 2 * a;
        double num2 = -b - Math.sqrt(b * b - 4 * a * c);

        return num1 / den > num2 / den ? num1 / den : num2 / den;
    }

    static double t(double v, double v0, double a) {
        return (v - v0) / a;
    }

    static double t(double x, double x0, double v0, double acc) {
        double a = acc / 2;
        double b = v0;
        double c = x0 - x;
        return solvePositiveRoot(a, b, c);
    }

    //TODO: DIRECTION IS NOT CERTAIN (X AND Y COMPONENTS ABSOLUTE)
    static Vector vf(Vector v0, Vector a, Vector x, Vector x0) {
        double xComp = vf(v0.x, a.x, x.x, x0.x);
        double yComp = vf(v0.y, a.y, x.y, x0.y);

        return new Vector(xComp, yComp);
    }

    static double vf(double v0, double a, double x, double x0) {
        return Math.sqrt(v0 * v0 + 2 * a * (x - x0));
    }
}
