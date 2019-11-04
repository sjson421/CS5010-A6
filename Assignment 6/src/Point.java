/**
 * POJO class for holding onto the data of a single point.
 */
class Point {
  private double x;
  private double y;

  Point(double x, double y) {
    this.x = x;
    this.y = y;
  }

  /**
   * Gets the x value of point.
   *
   * @return Point x value
   */
  double getX() {
    return x;
  }

  /**
   * Gets the y value of point.
   *
   * @return Point y value
   */
  double getY() {
    return y;
  }
}
