import java.util.Scanner;

public class Main {
    public static final double G = 9.81;
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("What do you want to find?");
        System.out.println("1. Final Velocity before it hits the ground");
        System.out.println("2. Time it takes to reach max point");
        System.out.println("3. Find Horizontal Distance");
        System.out.println("4. Get Air Time");

        int choice = input.nextInt();

        Vector v0, vf;
        double height, t;
        switch (choice) {
            case 1:
                v0 = getVector("v0");
                height = getDouble("height");
                vf = findFinalVelocity(v0, height);
                output(vf, "Final Velocity");
                break;
            case 2:
                v0 = getVector("v0");
                t = MotionEquations.t(0.d, v0.y, -G);
                output(t, "time");
                break;
            case 3:
                v0 = getVector("v0");
                height = getDouble("height");
                t = MotionEquations.t(0, height, v0.x, -G);
                double x = MotionEquations.xf(0.d, v0.x, t);
                output(x, "Distance Travelled");
                break;
            case 4:
                v0 = getVector("v0");
                height = getDouble("height");
                t = MotionEquations.t(0, height, v0.x, -G);
                output(t, "time");
                break;
        }
    }

    static void output(double t, String name) {
        System.out.println(name + " = " + t);
    }

    static void output(Vector v, String name) {
        System.out.println(name + " = " + v.magnitude() + " at an angle of " + v.angleDegrees() + " degs");
    }

    static Vector getVector(String name) {
        System.out.println("Please enter " + name + " magnitude: ");
        double mag = input.nextDouble();
        System.out.println("Please enter angle in degrees: ");
        double angle = input.nextDouble();
        return new Vector(mag, new Angle(angle));
    }

    static double getDouble(String name) {
        System.out.println("Please enter " + name + ": ");
        return input.nextDouble();
    }

    static Vector findFinalVelocity(Vector v0, double height) {
        double xComp = v0.x;
        double yComp = MotionEquations.vf(v0.y, -G, 0, height);

        return new Vector(xComp, -yComp);
    }
}

//import java.util.Scanner;
//
//public class Main {
//    public static Scanner input = new Scanner(System.in);
//    public final static double G = 9.81;
//    private static Vector Vo;
//    private static double height;
//
//    public static void main(String[] args) {
//        System.out.println("What do you want to find");
//        System.out.println("1. Final Velocity before it hits the ground");
//        System.out.println("2. Time it takes to reach max point");
//        System.out.println("3. Find Horizontal Distance");
//        System.out.println("4. Get Air Time");
//        int choice = 0;
//        try {
//            choice = Integer.parseInt(input.nextLine());
//        } catch (NumberFormatException e) {
//            System.out.println("Invalid Choice");
//        }
//        switch (choice) {
//            case 1:
//                getVo();
//                getHeight();
//                Vector Vf = getFinalVelocity(Vo, height);
//                System.out.println("Final Velocity: "+Vf.magnitude());
//                System.out.print("m/s at "+ Vf.angleDegrees());
//                break;
//            case 2:
//                getVo();
//                System.out.println("The particle reaches max point at " + timeAtMaxHeight(Vo) + "s");
//                break;
//            case 3:
//                getVo();
//                getHeight();
//                System.out.println("The horizontal distance is: "+findHorizontalDistance(Vo, height));
//                break;
//            case 4:
//                getVo();
//                getHeight();
//                System.out.println("The particle is on the air for" + getAirTime(Vo, height) + "seconds");
//            default:
//                System.out.println("Invalid Choice");
//                break;
//        }
//    }
//    //Assuming x0 is the start point
//
//    static double timeAtMaxHeight(Vector Vo) {
//        return Vo.y / G;
//    }
//
//    static Vector getFinalVelocity(Vector Vo, double height){
//        double yComp = Math.sqrt(Vo.y*Vo.y+2*G*height);
//        return new Vector(Vo.x,-yComp);
//    }
//
//    static double getAirTime(Vector Vo, double height) {
//        return findPositiveRoot(G / 2, -Vo.y, -height);
//    }
//
//    private static double findPositiveRoot(double a, double b, double c) {
//        return (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
//    }
//
//    public static void getVo() {
//        System.out.println("Enter Vo");
//        double magnitude = input.nextDouble();
//        System.out.println("Enter Angle");
//        Angle angle = new Angle(input.nextDouble());
//        Vo = new Vector(magnitude, angle);
//    }
//
//    public static void getHeight() {
//        System.out.println("Enter height of the cliff");
//        height = input.nextDouble();
//    }
//
//    public static double findHorizontalDistance(Vector Vo, double height){
//        double time = getAirTime(Vo, height);
//        return Vo.x * time;
//    }
//}
