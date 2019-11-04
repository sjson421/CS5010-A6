import java.awt.Color;
import java.io.IOException;

/**
 * Provides the plotting methods for the machine learning algorithms.
 */
public abstract class AbstractView implements IView {
  /**
   * Helper method for plotting a point in the dataset.
   *
   * @param point   Point in the dataset in the algorithm to plot.
   * @param plotter ImagePlotter to plot these points into, on the algorithm plot specified.
   * @param color   Color to plot point as
   */
  protected void plotPoint(Point point, ImagePlotter plotter, Color color) {
    plotter.addPoint((int) Math.round(point.getX()), (int) Math.round(point.getY()), color);
  }

  /**
   * Sets up an image plotter, along with its initial default values such as width and height.
   *
   * @return The completely set-up image plotter.
   */
  @Override
  public ImagePlotter setUpPlotter(int xMin, int xMax, int yMin, int yMax) {
    ImagePlotter plotter = new ImagePlotter();
    plotter.setWidth(400);
    plotter.setHeight(400);

    plotter.setDimensions(xMin, xMax, yMin, yMax);
    return plotter;
  }

  @Override
  public void drawOutput(ImagePlotter plotter, String outputPath) {
    try {
      plotter.write(outputPath);
    } catch (IOException e) {
      e.getStackTrace();
    }
  }
}
