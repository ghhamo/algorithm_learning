package job.convexHull;

import job.shellSort.ShellSort;

import java.util.LinkedList;


public class ConvexHull {


    public LinkedList<Point2D> sort(Point2D[] point2DS) {
        Point2D pivot = findPivot(point2DS);
        calculateTheAngles(point2DS, pivot);
        ShellSort<Point2D> shellSort = new ShellSort<>();
        point2DS = shellSort.sort(point2DS);

        LinkedList<Point2D> hull = new LinkedList<>();
        hull.add(pivot);
        hull.add(point2DS[0]);
        hull.add(point2DS[1]);
        int hullSize = 3;
        for (int i = 2; i < point2DS.length - 1; i++) {
            Point2D p0 = hull.get(hullSize - 2);
            Point2D p1 = hull.get(hullSize - 1);
            Point2D p2 = point2DS[i];
            double result = (p1.getXAxis() - p0.getXAxis()) * (p2.getYAxis() - p0.getYAxis()) -
                    (p1.getYAxis() - p0.getYAxis()) * (p2.getXAxis() - p0.getXAxis());
            if (result < 0) {
                hull.removeLast();
                hullSize = rec(hull, p2, hullSize - 1);
                hull.add(p2);
                hullSize++;
            } else if (result == 0) {
                hull.removeLast();
                hull.add(p2);
            } else {
                hull.add(p2);
                hullSize++;
            }
        }
        hull.add(pivot);
        return hull;

    }

    private int rec(LinkedList<Point2D> hull, Point2D p2, int hullSize) {
        if (hullSize < 2) {
            return hullSize;
        }
        Point2D p0 = hull.get(hullSize - 2);
        Point2D p1 = hull.get(hullSize - 1);
        double result = (p1.getXAxis() - p0.getXAxis()) * (p2.getYAxis() - p0.getYAxis())
                - (p1.getYAxis() - p0.getYAxis()) * (p2.getXAxis() - p0.getXAxis());
        if (result > -1) {
            return hullSize;
        }
        hull.removeLast();
        return rec(hull, p2, hullSize - 1);
    }

    private Point2D findPivot(Point2D[] point2DS) {
        Point2D pivot = point2DS[0];
        for (int i = 1; i < point2DS.length; i++) {
            if (point2DS[i].getYAxis() < pivot.getYAxis()) {
                pivot = point2DS[i];
            } else if (point2DS[i].getYAxis().equals(pivot.getYAxis())) {
                if (point2DS[i].getXAxis() < pivot.getXAxis()) {
                    pivot = point2DS[i];
                }
            }
        }
        pivot.setAngle(0.0);
        return pivot;
    }

    private void calculateTheAngles(Point2D[] point2DS, Point2D pivot) {
        for (Point2D currentPoint2D : point2DS) {
            currentPoint2D.setAngle(Math.atan((double) (currentPoint2D.getXAxis() - pivot.getXAxis()) / (currentPoint2D.getYAxis() - pivot.getYAxis() + 1)));
            if (currentPoint2D.getAngle() < 0) {
                currentPoint2D.setAngle(Math.PI + currentPoint2D.getAngle());
            }
        }
    }
}