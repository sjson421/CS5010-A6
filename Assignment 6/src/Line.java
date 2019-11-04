/**
 * POJO class for holding onto the data of a line, in the format of ax+by+c=0.
 */
class Line {
  private double a;
  private double b;
  private double c;

  Line(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Gets the "a" Value, given equation of ax+by+c=0 on a line.
   *
   * @return "a" Value, given equation of ax+by+c=0
   */
  double getA() {
    return a;
  }

  /**
   * Gets the "b" Value, given equation of ax+by+c=0 on a line.
   *
   * @return "b" Value, given equation of ax+by+c=0
   */
  double getB() {
    return b;
  }

  /**
   * Gets the "c" Value, given equation of ax+by+c=0 on a line.
   *
   * @return "c" Value, given equation of ax+by+c=0
   */
  double getC() {
    return c;
  }
}
