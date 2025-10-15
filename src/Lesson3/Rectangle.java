package Lesson3;

public class Rectangle {
    private int length;
    private int width;

    public int calculateSquare(int length, int width) {
        return (length * width);
    }

    private int calculatePerimeter(int length, int width) {
        return (length + width) * 2;
    }
}