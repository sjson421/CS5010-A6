import java.awt.Color;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Provides the plotting methods for the machine learning algorithms.
 */
public class View {

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
   * Method for plotting the returned data from a k-means clustering algorithm.
   *
   * @param map        Map returned from fitting to k-means. Format in (cluster center, related data
   *                   set point).
   * @param outputPath Output path for the plotted image.
   */
  public void plotKMeans(Map<Point, List<Point>> map, String outputPath) {
    ImagePlotter plotter = setUpPlotter(0, 500, -500, 500);

    if (map.size() > 0) {
      Map<Point, Color> centerColor = new HashMap<>();
      for (Map.Entry<Point, List<Point>> entry : map.entrySet()) {
        Point clusterCenter = entry.getKey();
        List<Point> points = entry.getValue();

        if (!centerColor.containsKey(clusterCenter)) {
          Random rand = new Random();
          Color randomColor;

          do {
            float r = rand.nextFloat();
            float g = rand.nextFloat();
            float b = rand.nextFloat();
            randomColor = new Color(r, g, b);
          }
          while (centerColor.containsValue(randomColor));
          centerColor.put(clusterCenter, randomColor);
        }
        for (Point point : points) {
          plotPoint(point, plotter, centerColor.get(clusterCenter));
        }
        drawOutput(plotter, outputPath);
      }
    }
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

  /**
   * Sets up an image plotter, along with its initial default values such as width and height.
   *
   * @return The completely set-up image plotter.
   */
  private ImagePlotter setUpPlotter(int xMin, int xMax, int yMin, int yMax) {
    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(400);
    plotter.setHeight(400);

    plotter.setDimensions(xMin, xMax, yMin, yMax);
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
