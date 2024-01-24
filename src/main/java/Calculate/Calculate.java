package Calculate;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        //Step 1: input Data
        inputData();

    }
    public static void inputData() {
        //input Data for Triangle, Circle and Rectangle
        Scanner scan = new Scanner(System.in);
        System.out.println("=====Calculator Shape Program=====");
        System.out.println("Please input width of Rectangle:");
        double width = scan.nextDouble();
        System.out.println("Please input length of Rectangle:");
        double length = scan.nextDouble();
        Shape rectangle = new Rectangle(width,length);
        System.out.println("Please input radius of Circle:");
        double radius = scan.nextDouble();
        Shape circle = new Circle(radius);
        System.out.println("Please input side A of Triangle:");
        double SideA = scan.nextDouble();
        System.out.println("Please input side B of Triangle:");
        double SideB = scan.nextDouble();
        System.out.println("Please input side C of Triangle:");
        double SideC = scan.nextDouble();
        Shape triangle = new Triangle(SideA, SideB, SideC);
        //Display information
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();
        //Exit program
        scan.close();
    }
    //Set interface for 3 method
    interface Shape {
        double getPerimeter();
        double getArea();
        void printResult();
    }
    //calculate perimeter and area of triangle
    static class Triangle implements Shape {
        private double a, b, c;
        public Triangle(double a, double b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
        @Override
        public double getPerimeter() {
            return a + b + c;
        }
        @Override
        public double getArea() {
            double p = getPerimeter()/2;
            return Math.sqrt(p * (p - a) * (p - b) * (p - c));
        }
        @Override
        public void printResult() {
            System.out.println("-----Triangle-----");
            System.out.println("Side A: " + a);
            System.out.println("Side B: " + b);
            System.out.println("Side C: " + c);
        }
    }
    // calculate perimeter and area of Circle
    static class Circle implements Shape {
        private double radius;
        public Circle(double radius) {
            this.radius = radius;
        }
        @Override
        public double getPerimeter() {
            return 2 * Math.PI * radius;
        }

        @Override
        public double getArea() {
            return Math.PI * Math.pow(radius, 2);
        }
        @Override
        public void printResult() {
            System.out.println("-----Circle-----");
            System.out.println("Radius: " + radius);
            System.out.println("Area: " + getArea());
            System.out.println("Perimeter: " + getPerimeter());
        }
    }
    // calculate perimeter and area of rectangle
    static class Rectangle implements Shape {
        private double width, height;
        public Rectangle(double width, double height) {
            this.width = width;
            this.height = height;
        }
        @Override
        public double getPerimeter() {
            return 2 * (width + height);
        }
        @Override
        public double getArea() {
            return width * height;
        }
        @Override
        public void printResult() {
            System.out.println("-----Rectangle-----");
            System.out.println("Width: " + width);
            System.out.println("Height: " + height);
            System.out.println("Area: " + getArea());
            System.out.println("Perimeter: " + getPerimeter());
        }
    }
}