import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Controller implements IController {
  private View view;
  private LinearRegression line;
  private KMeansClustering kmeans;

  public Controller() {
    view = new View();
    line = new LinearRegression();
    /*TODO: WHAT DO I DO HERE TO DECIDE K?*/
    kmeans = new KMeansClustering(2);
  }

  public void go() throws IOException {
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

    addPoints(brLine1, line);
    addPoints(brCluster2, kmeans);

    plotLinear(fitLinear(brLine1, line), "../output/linear.png");
    plotKMeans(fitKMeans(brCluster2), "../output/cluster.png");
  }

  private void addPoints(BufferedReader br, MLAlgorithm algorithm) throws IOException {
    String line;
    while ((line = br.readLine()) != null) {
      String[] arr = line.split(" ");
      Point p = new Point(Double.parseDouble(arr[0]), Double.parseDouble(arr[1]));
      algorithm.addPoint(p);
    }
  }

  /**
   * Helper method for creating and fitting a point to a linear regression algorithm.
   *
   * @param br Reader for reading in the files of data
   */
  private Map<Point, Point> fitLinear(BufferedReader br, LinearRegression linearRegression) {
    Point p = linearRegression.fit();
    return m;
  }
}
