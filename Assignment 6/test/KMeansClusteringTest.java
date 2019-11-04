import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests K-means clustering algorithm model.
 */
public class KMeansClusteringTest {
  private KMeansClustering k1;
  private KMeansClustering k2;

  private Point p1;
  private Point p2;
  @Before
  public void setUp() {
    k1 = new KMeansClustering();
    k2 = new KMeansClustering();

    Point p1 = new Point(2,1);
    Point p2 = new Point(-2,3);
    Point p3 = new Point(-1,-2);
    Point p4 = new Point(5,3);

    k1.addPoint(p1);
    k1.addPoint(p2);
    k1.fit(2);

    k2.addPoint(p1);
    k2.addPoint(p2);
    k2.addPoint(p3);
    k2.addPoint(p4);
    k2.fit(2);

  }

  @Test
  public void test() {
    assertEquals(2,k1.fit(2).keySet().size());
  }
  @Test
  public void test1() {
    assertEquals(2,k2.fit(2).keySet().size());
  }
}
