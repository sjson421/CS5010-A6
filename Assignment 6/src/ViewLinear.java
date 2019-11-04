import java.awt.*;
import java.util.List;

public class ViewLinear extends AbstractView{
  /**
   * Method for plotting the returned data from a linear regression algorithm.
   *
   * @param line       Best-fit line from a given data set.
   * @param points     Points in the dataset of the algorithm.
   * @param outputPath Output path for the plotted image.
   */
  public void plotLinear(Line line, List<Point> points, String outputPath) {
    ImagePlotter plotter = setUpPlotter(-500, 500, -500, 500);

    double a = line.getA();
    double b = line.getB();
    double c = line.getC();

    final int x1 = -1000;
    int y1 = (int) Math.round(getYFromX(x1, a, b, c));
    final int x2 = 1000;
    int y2 = (int) Math.round(getYFromX(x2, a, b, c));

    for (Point point : points) {
      plotPoint(point, plotter, Color.BLACK);
    }
    plotter.addLine(x1, y1, x2, y2);
    drawOutput(plotter, outputPath);
  }
  /**
   * Gets the y-coordinate, given an x-coordinate on a line.
   *
   * @param x x-coordinate to find y-coordinate for.
   * @param a "a" Value, given equation of ax+by+c=0
   * @param b "b" Value, given equation of ax+by+c=0
   * @param c "c" Value, given equation of ax+by+c=0
   * @return The y-coordinate, given an x-coordinate on a line.
   */
  private double getYFromX(double x, double a, double b, double c) {
    return (-c - a * x) / b;
  }
}
