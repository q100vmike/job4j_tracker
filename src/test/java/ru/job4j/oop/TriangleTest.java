package ru.job4j.oop;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class TriangleTest {
    @Test
    void calcAreaTriangle24dot5() {
        double expected = 24.5;
        Point a = new Point(0, 10);
        Point b = new Point(1, 1);
        Point c = new Point(6, 5);
        Triangle tr = new Triangle(a, b, c);
        double out = tr.area(a, b, c);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void calcAreaTriangleNotValid() {
        double expected = -1;
        Point a = new Point(0, 10);
        Point b = new Point(0, 0);
        Point c = new Point(0, 5);
        Triangle tr = new Triangle(a, b, c);
        double out = tr.area(a, b, c);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }
}