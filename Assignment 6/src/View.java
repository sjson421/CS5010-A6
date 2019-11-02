import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class View {
  public static void main(String[] args) throws IOException {
    new Controller().go();
  }

  /**
   * Helper method for plotting a point in the dataset.
   *
   * @param point   Point in the dataset in the algorithm to plot.
   * @param plotter ImagePlotter to plot these points into, on the algorithm plot specified.
   * @param color   Color to plot point as
   */
  private void plotPoint(Point point, ImagePlotter plotter, Color color) {
    plotter.addPoint((int) Math.round(point.getX()), (int) Math.round(point.getY()), color);
  }

  /**
   * Method for plotting the returned data from a linear regression algorithm.
   *
   * @param line       Best-fit line from a given data set.
   * @param points     Points in the dataset of the algorithm.
   * @param outputPath Output path for the plotted image.
   */
  public void plotLinear(Line line, List<Point> points, String outputPath) {
    ImagePlotter plotter = setUpPlotter();

    double a = line.getA();
    double b = line.getB();
    double c = line.getC();

    final int X1 = 0;
    int y1 = (int) Math.round(getYFromX(X1, a, b, c));
    final int X2 = 1;
    int y2 = (int) Math.round(getYFromX(X2, a, b, c));

    for (Point point : points) {
      plotPoint(point, plotter, Color.BLACK);
    }
    plotter.addLine(X1, y1, X2, y2);
    drawOutput(plotter, outputPath);
  }

  /**
   * Method for plotting the returned data from a k-means clustering algorithm.
   *
   * @param map        Map returned from fitting to k-means. Format in (point, cluster center
   *                   point).
   * @param points     Points in the dataset of the algorithm.
   * @param outputPath Output path for the plotted image.
   */
  public void plotKMeans(Map<Point, Point> map, List<Point> points, String outputPath) {
    ImagePlotter plotter = setUpPlotter();

    if (map.size() > 0) {
      Map<Point, Color> centerColor = new HashMap<>();
      for (Map.Entry<Point, Point> entry : map.entrySet()) {
        Point point = entry.getKey();
        Point clusterCenter = entry.getValue();

        if (!centerColor.containsKey(clusterCenter)) {
          Random rand = new Random();
          Color randomColor;

          do {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            randomColor = new Color(r, g, b);
          } while (centerColor.containsValue(randomColor));
          centerColor.put(point, randomColor);
        }
        plotPoint(point, plotter, centerColor.get(clusterCenter));
        drawOutput(plotter, outputPath);
      }
    }
  }

  /**
   * Gets the y-coordinate, given an x-coordinate on a line.
   *
   * @param x x-coordinate to find y-coordinate for.
   * @param a "a" Value, given equation of c = -ax - by
   * @param b "b" Value, given equation of c = -ax - by
   * @param c "c" Value, given equation of c = -ax - by
   * @return The y-coordinate, given an x-coordinate on a line.
   */
  private double getYFromX(double x, double a, double b, double c) {
    return (c + a * x) / -b;
  }

  /**
   * Sets up an image plotter, along with its initial default values such as width and height.
   *
   * @return The completely set-up image plotter.
   */
  private ImagePlotter setUpPlotter() {
    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(400);
    plotter.setHeight(400);

    plotter.setDimensions(-300, 300, -350, 350);
    return plotter;
  }

  private void drawOutput(ImagePlotter plotter, String outputPath) {
    try {
      plotter.write(outputPath);
    } catch (IOException e) {
      e.getStackTrace();
    }
  }
}
