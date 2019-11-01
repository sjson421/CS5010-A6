/**
 * Interface above both machine learning algorithms. Both algorithms share the same purpose, which
 * is to get the best-fitting model for it.
 */
public interface MLAlgorithm {
  /**
   * Finds the best model for the new point given, and returns a new point that best models the
   * given new point.
   *
   * @param newPt The new point to be entered into
   * @return A point that symbolizes the best model for the given data. The purpose of the point
   * given is different based on the algorithm class.
   */
  Point fit(Point newPt);
}
