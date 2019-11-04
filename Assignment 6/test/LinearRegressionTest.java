import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * Tests Linear Regression algorithm model.
 */
public class LinearRegressionTest {
  private LinearRegression l1;
  private LinearRegression l2;
  private LinearRegression l3;
  private LinearRegression l4;
  private LinearRegression l5;
  private LinearRegression l6;

  @Before
  public void setUp() {
    l1 = new LinearRegression();
    l2 = new LinearRegression();
    l3 = new LinearRegression();
    l4 = new LinearRegression();
    l5 = new LinearRegression();
    l6 = new LinearRegression();

    Point p1 = new Point(-2, -1);
    Point p2 = new Point(1, 1);
    Point p3 = new Point(3, 2);

    Point p4 = new Point(3, 7);
    Point p5 = new Point(7, 7);
    Point p6 = new Point(14, -5);
    Point p7 = new Point(-3, -5);

    Point p8 = new Point(3, 11);
    Point p9 = new Point(3, -5);
    Point p10 = new Point(-8, 6);
    Point p11 = new Point(-8, 9);


    Point p12 = new Point(-13.5, -11.33);
    Point p13 = new Point(-12.7, -10.22);
    Point p14 = new Point(-12, -10);
    Point p15 = new Point(-6.5, -2.78);
    Point p16 = new Point(-1, -0.2);
    Point p17 = new Point(1.44, 1.76);
    Point p18 = new Point(3, 3.45);
    Point p19 = new Point(4.5, 5);
    Point p20 = new Point(8, 6);
    Point p21 = new Point(12.12, 7.89);

    Point p22 = new Point(4.5, 5);
    Point p23 = new Point(8, 3);
    Point p24 = new Point(12.12, -1);

    Point p25 = new Point(0, 0);

    l1.addPoint(p1);
    l1.addPoint(p2);
    l1.addPoint(p3);

    l2.addPoint(p4);
    l2.addPoint(p5);
    l2.addPoint(p6);
    l2.addPoint(p7);

    l3.addPoint(p8);
    l3.addPoint(p9);
    l3.addPoint(p10);
    l3.addPoint(p11);

    l4.addPoint(p12);
    l4.addPoint(p13);
    l4.addPoint(p14);
    l4.addPoint(p15);
    l4.addPoint(p16);
    l4.addPoint(p17);
    l4.addPoint(p18);
    l4.addPoint(p19);
    l4.addPoint(p20);
    l4.addPoint(p21);

    l5.addPoint(p22);
    l5.addPoint(p23);
    l5.addPoint(p24);

    l6.addPoint(p12);
    l6.addPoint(p13);
    l6.addPoint(p14);
    l6.addPoint(p15);
    l6.addPoint(p16);
    l6.addPoint(p17);
    l6.addPoint(p18);
    l6.addPoint(p19);
    l6.addPoint(p20);
    l6.addPoint(p21);
    l6.addPoint(p25);
  }

  /**
   * Normal test of a linear regression algorithm of a set of points.
   */
  @Test
  public void testLinearRegression() {
    assertEquals(-0.5184, l1.fit().getA(), 0.01);
  }

  /**
   * Normal test of a linear regression algorithm of a set of points.
   */
  @Test
  public void testLinearRegression1() {
    assertEquals(0.8551, l1.fit().getB(), 0.01);
  }

  /**
   * Normal test of a linear regression algorithm of a set of points.
   */
  @Test
  public void testLinearRegression2() {
    assertEquals(-0.2245, l1.fit().getC(), 0.01);
  }

  /**
   * Tests properly fitted linear regression line of a horizontal line.
   */
  @Test
  public void testLinearRegressionHorizontalLine() {
    assertEquals(0.453, l2.fit().getA(), 0.01);
    assertEquals(0.891, l2.fit().getB(), 0.01);
    assertEquals(-3.270, l2.fit().getC(), 0.01);
  }

  /**
   * Tests properly fitted linear regression line of a vertical line.
   */
  @Test
  public void testLinearRegressionVerticalLine() {
    assertEquals(0.807, l3.fit().getA(), 0.01);
    assertEquals(0.589, l3.fit().getB(), 0.01);
    assertEquals(-1.074, l3.fit().getC(), 0.01);
  }

  /**
   * Tests properly fitted linear regression line of line of positive slope.
   */

  @Test
  public void testLinearRegressionPositiveSlope() {
    assertEquals(-0.619, l4.fit().getA(), 0.01);
    assertEquals(0.784, l4.fit().getB(), 0.01);
    assertEquals(-0.213, l4.fit().getC(), 0.01);
  }

  /**
   * Tests properly fitted linear regression line of line of negative slope.
   */
  @Test
  public void testLinearRegressionNegativeSlope() {
    assertEquals(0.624, l5.fit().getA(), 0.01);
    assertEquals(0.781, l5.fit().getB(), 0.01);
    assertEquals(-6.946, l5.fit().getC(), 0.01);
  }

  /**
   * Tests properly fitted linear regression line of line passing through origin.
   */
  @Test
  public void testLinearRegressionOrigin() {
    assertEquals(-0.619, l6.fit().getA(), 0.01);
    assertEquals(0.784, l6.fit().getB(), 0.01);
    assertEquals(-0.193, l6.fit().getC(), 0.01);
  }
}
