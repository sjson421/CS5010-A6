import java.util.Map;

public class KMeansClustering extends AbstractMLAlgorithm {
  private int k;

  public KMeansClustering(int k) {
    super();
    this.k = k;
  }

  public Map<Point, Point> fit() {
    for (int i = 0; i < pointList.size(); i++) {
      Point p = pointList.get(i);
    }
    return null;
  }
}
