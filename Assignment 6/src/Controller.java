import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Controller implements IController {
  @Override
  public void go(MLAlgorithm a) throws IOException {
    File linedata1 = new File("../data/linedata-1.txt");
//    File linedata2 = new File("../data/linedata-2.txt");
//    File linedata3 = new File("../data/linedata-3.txt");
    File clusterdata2 = new File("../data/clusterdata-2.txt");
//    File clusterdata3 = new File("../data/clusterdata-3.txt");
//    File clusterdata4 = new File("../data/clusterdata-4.txt");
//    File clusterdata6 = new File("../data/clusterdata-6.txt");

    BufferedReader brLine1 = new BufferedReader(new FileReader(linedata1));
//    BufferedReader brLine2 = new BufferedReader(new FileReader(linedata2));
//    BufferedReader brLine3 = new BufferedReader(new FileReader(linedata3));
    BufferedReader brCluster2 = new BufferedReader(new FileReader(clusterdata2));
//    BufferedReader brCluster3 = new BufferedReader(new FileReader(clusterdata3));
//    BufferedReader brCluster4 = new BufferedReader(new FileReader(clusterdata4));
//    BufferedReader brCluster6 = new BufferedReader(new FileReader(clusterdata6));

    plotLinear(fitPoint(brLine1, a), "../output/linear.png");
    plotKMeans(fitPoint(brCluster2, a), "../output/cluster.png");
  }

  /**
   * Helper method for creating and fitting a point.
   *
   * @param br Reader for reading in the files of data
   * @param a  Algorithm to use. Currently, either linear regression or k-means clustering.
   */
  private Map<Point, Point> fitPoint(BufferedReader br, MLAlgorithm a) throws IOException {
    String line;
    Map<Point, Point> m = new HashMap<>();
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      Point p = new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
      m.put(p, a.fit(p));
    }
    return m;
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

  /**
   * Helper method for plotting the returned data from a linear regression algorithm.
   *
   * @param map Map returned from fit(). Format in (newly entered point, fitted point)
   */
  private void plotLinear(Map<Point, Point> map, String outputPath) {
    ImagePlotter plotter = new ImagePlotter();
    setUpPlotter(plotter);

    if (map.size() > 0) {
      for (Point key : map.keySet()) {

        plotter.addLine(x, y, x + 20, y);
        drawOutput(plotter, outputPath);
      }
    }
  }
}
