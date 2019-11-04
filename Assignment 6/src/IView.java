/**
 * Interface for a class that would plot and print a set of given dataset points as well as its
 * chosen machine learning algorithm fit.
 */
public interface IView {
  /**
   * Set up the window where the data will be plotted.
   * @param xMin The minimum x to show on the window.
   * @param xMax The maximum x to show on the window.
   * @param yMin The minimum y to show on the window.
   * @param yMax The maximum x to show on the window.
   * @return
   */
  ImagePlotter setUpPlotter(int xMin, int xMax, int yMin, int yMax);

  /**
   * Performs the function of drawing the given data from plotter.
   * @param plotter ImagePlotter that holds the information to plot.
   * @param outputPath Path to post the output into.
   */
  void drawOutput(ImagePlotter plotter, String outputPath);
}
