public class Line {
  private double a;
  private double b;
  private double c;

  protected Line(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  /**
   * Gets the "a" Value, given equation of c = -ax - by on a line.
   *
   * @return "a" Value, given equation of c = -ax - by
   */
  public double getA() {
    return a;
  }

  /**
   * Gets the "b" Value, given equation of c = -ax - by on a line.
   *
   * @return "b" Value, given equation of c = -ax - by
   */
  public double getB() {
    return b;
  }

  /**
   * Gets the "c" Value, given equation of c = -ax - by on a line.
   *
   * @return "c" Value, given equation of c = -ax - by
   */
  public double getC() {
    return c;
  }
}
