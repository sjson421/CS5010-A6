import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class View {
  public static void main(String[] args) throws IOException {
    new Controller().go();
  }

  /**
   * Method for plotting a point in the dataset.
   * @param point Point to point
   */
  public void plotPoint(Point point) {

  }

  /**
   * Method for plotting the returned data from a linear regression algorithm.
   *
   * @param line       Best-fit line from a given data set.
   * @param outputPath Output path for the plotted image.
   */
  public void plotLinear(Line line, String outputPath) {
    ImagePlotter plotter = new ImagePlotter();
    setUpPlotter(plotter);

    double a = line.getA();
    double b = line.getB();
    double c = line.getC();

    final double X1 = 0;
    double y1 = getYFromX(X1, a, b, c);
    final double X2 = 1;
    double y2 = getYFromX(X2, a, b, c);

    //plotter.addLine(X1, y1, X2, y2);
    drawOutput(plotter, outputPath);
  }

  /**
   * Method for plotting the returned data from a k-means clustering algorithm.
   *
   * @param map Map returned from fit(). Format in (newly entered point, fitted point)
   */
  public void plotKMeans(Map<Point, Point> map, String outputPath) {
    ImagePlotter plotter = new ImagePlotter();
    setUpPlotter(plotter);

  }

  /**
   * Gets the y-coordinate, given an x-coordinate on a line.
   *
   * @param x x-coordinate to find y-coordinate for.
   * @param a "a" Value, given equation of c=-ax-by
   * @param b "b" Value, given equation of c=-ax-by
   * @param c "c" Value, given equation of c=-ax-by
   * @return The y-coordinate, given an x-coordinate on a line.
   */
  private double getYFromX(double x, double a, double b, double c) {
    return (c + a * x) / -b;
  }

  private void setUpPlotter(ImagePlotter plotter) {
    plotter.setWidth(400);
    plotter.setHeight(400);

    plotter.setDimensions(-300, 300, -350, 350);
  }

  private void drawOutput(ImagePlotter plotter, String outputPath) {
    try {
      plotter.write(outputPath);
    } catch (IOException e) {
      e.getStackTrace();
    }
  }
}
