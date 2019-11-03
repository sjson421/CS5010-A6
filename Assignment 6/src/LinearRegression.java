import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class LinearRegression extends AbstractMLAlgorithm {
  private double xBar;
  private double yBar;
  private double xxBar;
  private double yyBar;
  private double xyBar;
  private double theta;
  private int size;

  public LinearRegression() {
    super();
    size = 0;
  }

  /**
   * Gets the best-fit line.
   *
   * @return A line with the fields of a, b, and c in the form of c = -ax-by
   */
  public Line fit() {
    double a;
    double b;
    double c;
    size = pointList.size();
    if (size > 0) {
      calculateAverage();
      calculateXXBar();
      calculateFt();
      a = calculateA();
      b = calculateB();
      c = calculateC();

      return new Line(a, b, c);
    } else {
      return null;
    }
  }

  private void calculateAverage() {
    double xSum = 0.0;
    double ySum = 0.0;
    for (int i = 0; i < size; i++) {
      xSum += pointList.get(i).getX();
      ySum += pointList.get(i).getY();
    }
    xBar = xSum / size;
    yBar = ySum / size;
  }

  private void calculateXXBar() {
    for (int i = 0; i < size; i++) {
      xxBar += (pointList.get(i).getX() - xBar) * (pointList.get(i).getX() - xBar);
      yyBar += (pointList.get(i).getY() - yBar) * (pointList.get(i).getY() - yBar);
      xyBar += (pointList.get(i).getX() - xxBar) * (pointList.get(i).getY() - yBar);
    }
    double d = (2 * xyBar) / (xxBar - yyBar);

    theta = (Math.atan(d));
  }

  private void calculateFt() {
    double ft1 = (yyBar - xxBar) * (Math.cos(theta)) - 2.0 * xyBar * Math.sin(theta);
    double ft2 = ((yyBar - xxBar) * (Math.cos((theta+Math.PI)))) - (2.0 * xyBar * Math.sin((theta+Math.PI))  );
    if (ft1 < ft2) {
      theta = theta + Math.PI;
    }
  }

  private double calculateA() {
    return Math.cos((theta/2.0));
  }

  private double calculateB() {
    return Math.sin((theta/2.0));
  }

  private double calculateC() {
    return (-calculateA() * xBar) - (calculateB() * yBar);
  }
}
