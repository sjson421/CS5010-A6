import java.util.List;
import java.util.Map;

/**
 * POJO class for holding a map returned in K-means clustering, along with its error value.
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
