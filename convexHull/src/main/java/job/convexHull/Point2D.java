package job.convexHull;

public class Point2D implements Comparable<Point2D> {
    private final int xAxis;
    private final int yAxis;
    private double angle;

    public Point2D(Integer xAxis, Integer yAxis) {
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Integer getXAxis() {
        return xAxis;
    }

    public Integer getYAxis() {
        return yAxis;
    }

    public void setAngle(Double angle) {
        this.angle = angle;
    }

    public double getAngle() {
        return angle;
    }

    @Override
    public int compareTo(Point2D o) {
        if (angle < o.angle) {
            return 1;
        } else if (angle == o.angle) {
            if (o.getYAxis() < yAxis) {
                return -1;
            } else return 1;
        }
        return -1;
    }
}