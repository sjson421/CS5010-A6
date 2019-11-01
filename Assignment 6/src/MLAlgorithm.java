/**
 * Interface above both machine learning algorithms. Both algorithms share the same purpose, which
 * is to get the best-fitting model for it.
 */
public interface MLAlgorithm {
  /**
   * Adds the point to the data set of points that the algorithm requires to calculate.
   * @param p New point to be added
   */
  void addPoint(Point p);
}
