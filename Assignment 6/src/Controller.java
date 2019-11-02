import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Controller implements IController {
  private View view;
  private LinearRegression linear;
  private KMeansClustering kmeans;

  public Controller() {
    view = new View();
    linear = new LinearRegression();
    kmeans = new KMeansClustering();
  }

  public void go() throws IOException {
    File linedata1 = new File("../data/linedata-1.txt");
    File clusterdata2 = new File("../data/clusterdata-2.txt");

    BufferedReader brLine1 = new BufferedReader(new FileReader(linedata1));
    BufferedReader brCluster2 = new BufferedReader(new FileReader(clusterdata2));

    List<Point> linePoints = addPoints(brLine1, linear);
    List<Point> kmeansPoints = addPoints(brCluster2, kmeans);

    view.plotLinear(linear.fit(), linePoints, "output/linear.png");
    /*
    TODO: WHAT DO I DO HERE TO DECIDE K?
     */
    view.plotKMeans(kmeans.fit(2), kmeansPoints, "output/cluster.png");
  }

  /**
   * Helper method to add points to algorithm and return the list of points added.
   *
   * @param br        BufferedReader with list of points to add to algorithm dataset.
   * @param algorithm The algorithm object used.
   * @return List of points added
   * @throws IOException Thrown if you can't read from br
   */
  private List<Point> addPoints(BufferedReader br, MLAlgorithm algorithm) throws IOException {
    List<Point> points = new ArrayList<>();
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      Point p = new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
      algorithm.addPoint(p);
      points.add(p);
    }
    return points;
  }
}
