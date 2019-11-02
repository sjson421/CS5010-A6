import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class LinearRegression implements MLAlgorithm {
  private List<Double> x;
  private List<Double> y;

  private double xBar;
  private double yBar;
  private double xxBar;
  private double yyBar;
  private double xyBar;
  private double theta;

  public LinearRegression() {
    x = new ArrayList<>();
    y = new ArrayList<>();
  }

  @Override
  public void addPoint(Point p) {
    x.add(p.getX());
    y.add(p.getY());
  }

  public Point fit() {
    double a;
    double b;
    double c;
    if (x.size() > 0) {
      calculateAverage();
      calculateXXBar();
      calculateFt();
      a = calculateA();
      b = calculateB();
      c = calculateC();

      double linePointX = x.get(0) + 1.0;
      double linePointY = (c + a * linePointX) / -b;
      return new Point(linePointX, linePointY);
    } else {
      return null;
    }
  }

  private void calculateAverage() {
    double xSum = 0;
    double ySum = 0;
    for (int i = 0; i < x.size(); i++) {
      xSum += x.get(i);
      ySum += y.get(i);
    }
    xBar = xSum / x.size();
    yBar = ySum / y.size();
  }

  private void calculateXXBar() {
    for (int i = 0; i < x.size(); i++) {
      xxBar += (x.get(i) - xBar) * (x.get(i) - xBar);
      yyBar += (y.get(i) - yBar) * (y.get(i) - yBar);
      xyBar += (x.get(i) - xxBar) * (y.get(i) - yBar);
    }
    double d = (2 * xyBar) / (xxBar - yyBar);
    theta = Math.toDegrees(Math.atan(d));
  }

  private void calculateFt() {
    double ft1 = (yyBar - xxBar) * Math.cos(theta) - 2 * xyBar * Math.sin(theta);
    double ft2 = (yyBar - xxBar) * Math.cos(theta + 180) - 2 * xyBar * Math.sin(theta + 180);
    if (ft1 < ft2) {
      theta = theta + 180;
    }
  }

  private double calculateA() {
    return Math.cos(theta / 2);
  }

  private double calculateB() {
    return Math.sin(theta / 2);
  }

  private double calculateC() {
    return (-calculateA() * xBar) - (calculateB() * yBar);
  }
}
