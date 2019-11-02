import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class View {
  public static void main(String[] args) throws IOException {
    new Controller().go();
  }

  /**
   * Method for plotting the returned data from a linear regression algorithm.
   *
   * @param map Map returned from fit(). Format in (newly entered point, fitted point)
   */
  public void plotLinear(Map<Point, Point> map, String outputPath) {
    ImagePlotter plotter = new ImagePlotter();
    setUpPlotter(plotter);

    if (map.size() > 0) {
      for (Point key : map.keySet()) {

        plotter.addLine(x, y, x + 20, y);
        drawOutput(plotter, outputPath);
      }
    }
  }

  /**
   * Method for plotting the returned data from a k-means clustering algorithm.
   *
   * @param map Map returned from fit(). Format in (newly entered point, fitted point)
   */
  public void plotKMeans(Map<Point, Point> map, String outputPath) {
    ImagePlotter plotter = new ImagePlotter();
    setUpPlotter(plotter);

    if (map.size() > 0) {
      for (Point key : map.keySet()) {

        plotter.addLine(x, y, x + 20, y);
        drawOutput(plotter, outputPath);
      }
    }
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
