/**
 * Interface above both machine learning algorithms. Although the two machine learning algorithms
 * both have a fit method, they both perform different functions, making only the adding of points a
 * shared functionality between the two.
 */
public interface MLAlgorithm {
  /**
   * Adds the point to the data set of points that the algorithm requires to calculate.
   *
   * @param p New point to be added
   */
  void addPoint(Point p);
}
