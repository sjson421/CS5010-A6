public class Line {
  private double a;
  private double b;
  private double c;

  protected Line(double a, double b, double c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double getA() {
    return a;
  }

  public double getB() {
    return b;
  }

  public double getC() {
    return c;
  }
}
