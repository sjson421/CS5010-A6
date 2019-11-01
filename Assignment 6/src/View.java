import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {
  public static void main(String[] args) throws IOException {
    new Controller().go((new LinearRegression()));
  }
}
