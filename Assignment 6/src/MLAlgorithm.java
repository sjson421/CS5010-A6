/**
 * Interface above both machine learning algorithms. Both algorithms share the same purpose, which
 * is to get the best-fitting model for it.
 */
public interface MLAlgorithm {
  /**
   * Finds the best model for the new point given, and returns a new point that best models the
   * given new point.
   *
   * @return A point that symbolizes the best model for the given data. The purpose of the point
   * given is different based on the algorithm class.
   */
  Point fit();

  /**
   * Adds the point to the data set of points that the algorithm requires to calculate.
   * @param p New point to be added
   */
  void addPoint(Point p);
}
