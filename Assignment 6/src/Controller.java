import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Implementation for the controller in IController.
 */
public class Controller implements IController {
  private LinearRegression linear;
  private KMeansClustering kmeans;
  private ViewLinear viewLinear;
  private ViewKMeans viewKMeans;
  private Readable in;
  private Appendable out;

  /**
   * Creates a controller with the following models and view.
   *
   * @param linear Linear regression model.
   * @param kmeans K-means clustering model.
   * @param viewLinear View for linear regression.
   * @param viewKMeans View for k-means clustering.
   * @param in     Where the input text will be given.
   * @param out    Where the outputted text will be shown.
   */
  protected Controller(LinearRegression linear, KMeansClustering kmeans,
                    ViewLinear viewLinear, ViewKMeans viewKMeans,
                    Readable in, Appendable out) {
    this.viewLinear = viewLinear;
    this.viewKMeans = viewKMeans;
    this.in = in;
    this.out = out;
    this.linear = linear;
    this.kmeans = kmeans;
  }

  /**
   * Called in the main method to run the main functionality of the controller.
   *
   * @throws IOException Thrown in the case of invalid given input or output locations
   */
  public void runProgram() throws IOException {
    String linearData;
    String kMeansData;
    Scanner s = new Scanner(in);
    out.append("Enter the location of the linear regression data:\n");
    linearData = s.nextLine();
    out.append("Enter the location of the k-means clustering data:\n");
    kMeansData = s.nextLine();
    out.append("Enter k-value to use in k-means clustering:\n");
    int k;
    try {
      k = Integer.parseInt(s.nextLine());
    } catch (NumberFormatException e) {
      out.append("You did not enter a number.\n");
      e.printStackTrace();
      return;
    }

    if (k < 1) {
      out.append("k must be at least 1.\n");
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

    viewLinear.plotLinear(linear.fit(), linePoints, "output/linear.png");
    viewKMeans.plotKMeans(kmeans.fit(k), "output/cluster.png");

    out.append("Your plotted images are in the output folder.");
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
