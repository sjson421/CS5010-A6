import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Program with the main method, for running the whole program.
 */
public class ProgramRunner {
  public static void main(String[] args) throws IOException {
    new Controller(new LinearRegression(), new KMeansClustering(), new View(),
            new InputStreamReader(System.in), System.out).runProgram();
  }
}
