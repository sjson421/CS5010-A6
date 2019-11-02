import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KMeansClustering implements MLAlgorithm{
  private List<Point> list = new ArrayList<>();
  private int k;

  public KMeansClustering(int k) {
    this.k = k;
  }
  public Map<Point, Point> fit() {
    for (int i = 0; i < list.size(); i++) {
      Point p = list.get(i);
    }
  }

  @Override
  public void addPoint(Point p) {
    list.add(p);
  }
}
