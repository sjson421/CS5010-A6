import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KMeansClustering extends AbstractMLAlgorithm {
  private int k;

  public KMeansClustering(int k) {
    super();
    this.k = k;
  }

  public Map<Point, Point> fit() {
    for (int i = 0; i < list.size(); i++) {
      Point p = list.get(i);
    }
  }
}
