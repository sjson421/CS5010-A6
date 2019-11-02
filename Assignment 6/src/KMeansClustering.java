import java.util.Map;

public class KMeansClustering extends AbstractMLAlgorithm {
  public KMeansClustering() {
    super();
  }

  /**
   * Fits the current point set into k clusters.
   * @param k Number of clusters to separate data set into
   * @return A map that maps each point in the data set to its cluster center.
   */
  public Map<Point, Point> fit(int k) {
    for (int i = 0; i < pointList.size(); i++) {
      Point p = pointList.get(i);
    }
    return null;
  }
}
