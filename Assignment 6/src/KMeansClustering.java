import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Class handling the k-means clustering machine learning algorithm. To use properly, add points
 * first using addPoints() then use fit() with a specified k.
 */
public class KMeansClustering extends AbstractMLAlgorithm {
  /**
   * Initialized by default with an empty list of points.
   */
  public KMeansClustering() {
    super();
  }

  /**
   * Fits the current point set into k clusters. The initial cluster centers are set randomly.
   *
   * @param k Number of clusters to separate data set into
   * @return A map that maps each cluster center to a list of data points
   */
  public Map<Point, List<Point>> fit(int k) {
    double minError = Double.POSITIVE_INFINITY;
    Map<Point, List<Point>> bestMap = null;

    int maxRansac = 10;
    for (int i = 0; i < maxRansac; i++) {
      PointMapError pme = runKMeans(k);
      if (pme.getError() < minError) {
        minError = pme.getError();
        bestMap = pme.getMap();
      }
    }
    return bestMap;
  }

  private PointMapError runKMeans(int k) {
    Map<Point, List<Point>> map = new HashMap<>();
    Random rand = new Random();

    double xRangeMin = Double.POSITIVE_INFINITY;
    double xRangeMax = Double.NEGATIVE_INFINITY;
    double yRangeMin = Double.POSITIVE_INFINITY;
    double yRangeMax = Double.NEGATIVE_INFINITY;

    for (Point p : pointList) {
      double pX = p.getX();
      double pY = p.getY();

      if (pX < xRangeMin) {
        xRangeMin = pX;
      }
      if (pX > xRangeMax) {
        xRangeMax = pX;
      }
      if (pY < yRangeMin) {
        yRangeMin = pY;
      }
      if (pY > yRangeMax) {
        yRangeMax = pY;
      }
    }

    for (int i = 0; i < k; i++) {
      Point center = new Point(
              xRangeMin + (xRangeMax - xRangeMin) * rand.nextDouble(),
              yRangeMin + (yRangeMax - yRangeMin) * rand.nextDouble());
      map.put(center, new ArrayList<>());
    }
    return getConvergedMap(map);
  }

  private PointMapError getConvergedMap(Map<Point, List<Point>> map) {
    int convergenceCount = 0;
    double percentageError = 100;
    double newError = Double.POSITIVE_INFINITY;

    do {
      double oldError = newError;

      for (Map.Entry<Point, List<Point>> entry : map.entrySet()) {
        entry.setValue(new ArrayList<>());
      }
      // Assign points to centers in map
      for (Point p : pointList) {
        double minDist = Double.POSITIVE_INFINITY;
        Point closestCenter = null;
        for (Point center : map.keySet()) {
          double distToCenter = getDistance(p, center);
          if (distToCenter < minDist) {
            minDist = distToCenter;
            closestCenter = center;
          }
        }
        map.get(closestCenter).add(p);
      }

      // Calculates new center point at center of all points
      Map<Point, List<Point>> newMap = new HashMap<>();
      for (List<Point> clusterPoints : map.values()) {
        double sumX = 0.0;
        double sumY = 0.0;
        for (Point p : clusterPoints) {
          sumX += p.getX();
          sumY += p.getY();
        }
        double averageX = sumX / clusterPoints.size();
        double averageY = sumY / clusterPoints.size();
        Point newCenter = new Point(averageX, averageY);
        newMap.put(newCenter, clusterPoints);

        newError = getNewError(newCenter, clusterPoints);
        percentageError = Math.abs(newError - oldError) / oldError;
      }
      map = newMap;
      convergenceCount++;
      if (Double.isNaN(percentageError)) {
        percentageError = 100;
      }
    }
    while (percentageError > 0.01 && convergenceCount <= 100);
    return new PointMapError(map, newError);
  }

  private double getNewError(Point newCenter, List<Point> clusterPoints) {
    return clusterPoints
            .stream()
            .mapToDouble(point -> getDistance(point, newCenter))
            .average()
            .orElse(0.0);
  }

  /**
   * Calculates the distance between two points.
   *
   * @param p1 First point
   * @param p2 Second point
   * @return Distance between p1 and p2
   */
  private double getDistance(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
  }
}
