import java.util.Map;

public class KMeansClustering extends AbstractMLAlgorithm {
  private int k;

  public KMeansClustering(int k) {
    super();
    this.k = k;
  }

  /**
   * Fits the current point set into k clusters, specified in the constructor.
   * @return A map that maps each point in the data set to its cluster center.
   */
  public Map<Point, Point> fit() {
    for (int i = 0; i < pointList.size(); i++) {
      Point p = pointList.get(i);
    }
    return null;
  }
}
