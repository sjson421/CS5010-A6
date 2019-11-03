import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller implements IController {
  private View view;
  private LinearRegression linear;
  private KMeansClustering kmeans;
  private Readable in;
  private Appendable out;

  public Controller(Readable in, Appendable out) {
    this.in = in;
    this.out = out;
    view = new View();
    linear = new LinearRegression();
    kmeans = new KMeansClustering();
  }

  public void go() throws IOException {
    String linearData = "data/linedata-1.txt";
    String kMeansData = "data/clusterdata-2.txt";
    Scanner s = new Scanner(in);
//    out.append("Enter the location of the linear regression data (probably in data/<something>):\n");
//    String linearData = s.nextLine();
//    out.append("Enter the location of the k-means clustering data (probably in data/<something>):\n");
//    String kMeansData = s.nextLine();
    out.append("Enter k-value to use in k-means clustering:\n");
    int k = 0;
    try {
      k = Integer.parseInt(s.nextLine());
    } catch (NumberFormatException e) {
      out.append("You did not enter a number.\n");
      e.printStackTrace();
      return;
    }

    File linedata = new File(linearData);
    File clusterdata = new File(kMeansData);
    BufferedReader brLine1;
    BufferedReader brCluster2;
    try {
      brLine1 = new BufferedReader(new FileReader(linedata));
      brCluster2 = new BufferedReader(new FileReader(clusterdata));
    } catch (FileNotFoundException e) {
      out.append("No data in your specified location\n");
      e.printStackTrace();
      return;
    }
    List<Point> linePoints = addPoints(brLine1, linear);
    addPoints(brCluster2, kmeans);

    view.plotLinear(linear.fit(), linePoints, "output/linear.png");
    view.plotKMeans(kmeans.fit(k), "output/cluster.png");
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
