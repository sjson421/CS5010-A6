import java.util.List;
import java.util.Map;

/**
 * POJO class for holding a map returned in K-means clustering, along with its error value.
 * The map should be in the format of <cluster center, list of points in cluster>
 */
class PointMapError {
  private Map<Point, List<Point>> map;
  private double error;

  PointMapError(Map<Point, List<Point>> map, double error) {
    this.map = map;
    this.error = error;
  }

  double getError() {
    return error;
  }

  Map<Point, List<Point>> getMap() {
    return map;
  }
}
