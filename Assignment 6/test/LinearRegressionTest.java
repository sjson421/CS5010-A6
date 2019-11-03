import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class LinearRegressionTest {
  private LinearRegression l1;
  private LinearRegression l2;
  private LinearRegression l3;
  private Point p1;
  private Point p2;
  private Point p3;
  private Line l;
  private Point p4;
  private Point p5;
  private Point p6;

  @Before
  public void setUp(){
    l1 = new LinearRegression();
    p1 = new Point(-2,-1);
    p2 = new Point(1,1);
    p3 = new Point(3,2);
    l1.addPoint(p1);
    l1.addPoint(p2);
    l1.addPoint(p3);
  }
  @Test
  public void testLinearRegression() {
    assertEquals(-0.027, l1.fit().getA(),0.01);
  }
  @Test
  public void testLinearRegression1() {
    assertEquals(0.999, l1.fit().getB(),0.01);
  }
  @Test
  public void testLinearRegression2(){
    assertEquals(-0.648,l1.fit().getC(),0.01) ;
  }

}
