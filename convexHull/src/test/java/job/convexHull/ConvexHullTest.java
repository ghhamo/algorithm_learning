package job.convexHull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.Iterator;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ConvexHullTest {

    @Test
    void sortTest() {
        Point2D[] unsortedPoints2D = new Point2D[11];
        unsortedPoints2D[0] = new Point2D(10, 9);
        unsortedPoints2D[1] = new Point2D(5, 4);
        unsortedPoints2D[2] = new Point2D(5, 6);
        unsortedPoints2D[3] = new Point2D(3, 2);
        unsortedPoints2D[4] = new Point2D(15, 2);
        unsortedPoints2D[5] = new Point2D(17, 3);
        unsortedPoints2D[6] = new Point2D(10, 3);
        unsortedPoints2D[7] = new Point2D(9, 6);
        unsortedPoints2D[8] = new Point2D(14, 5);
        unsortedPoints2D[9] = new Point2D(12, 8);
        unsortedPoints2D[10] = new Point2D(16, 7);
        ConvexHull convexHull = new ConvexHull();
        Point2D[] hull = new Point2D[7];
        hull[0] = new Point2D(3, 2);
        hull[1] = new Point2D(15, 2);
        hull[2] = new Point2D(17, 3);
        hull[3] = new Point2D(16, 7);
        hull[4] = new Point2D(10, 9);
        hull[5] = new Point2D(5, 6);
        hull[6] = new Point2D(3, 2);
        LinkedList<Point2D> sortied = convexHull.sort(unsortedPoints2D);
        Iterator<Point2D> iterator = sortied.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Point2D point2D = iterator.next();
            assertEquals(hull[i].getXAxis(), point2D.getXAxis());
            assertEquals(hull[i].getYAxis(), point2D.getYAxis());
            i++;
        }
    }
}