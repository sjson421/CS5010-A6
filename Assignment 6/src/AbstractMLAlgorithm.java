import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class for handling adding points, which is shared functionality for both algorithms.
 */
public abstract class AbstractMLAlgorithm implements MLAlgorithm {
  protected List<Point> pointList;

  protected AbstractMLAlgorithm() {
    pointList = new ArrayList<>();
  }

  @Override
  public void addPoint(Point p) {
    pointList.add(p);
  }
}
