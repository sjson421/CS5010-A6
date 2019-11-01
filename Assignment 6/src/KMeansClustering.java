import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class KMeansClustering implements MLAlgorithm{
  private List<Point> list = new ArrayList<>();
  public Map<Point, Point> fit() {
    return null;
  }

  @Override
  public void addPoint(Point p) {
    list.add(p);
  }
}
