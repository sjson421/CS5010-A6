import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ViewKMeans extends AbstractView{
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
}
