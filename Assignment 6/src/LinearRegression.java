import java.lang.Math;
public class LinearRegression implements MLAlgorithm{
  double [] x = new double[1];
  double [] y = new double[];
  private double xSum;
  private double ySum;
  private double xBar;
  private double yBar;
  private double xxBar;
  private double yyBar;
  private double xyBar;
  private double d;
  private double theta;
  private double ft;
  private double a;
  private double b;
  private double c;

  @Override
  public Point fit(Point newPt) {
    return null;
  }

  private void calculateAverage(){
     xSum =0;
     ySum=0;
    for(int i =0;i<x.length;i++){
      xSum += x[i];
      ySum+= y[i];
    }
    xBar = xSum/x.length;
    yBar = ySum/y.length;
  }

  private void calculateXXBar(){
    for(int i=0;i<x.length;i++){
      xxBar+=(x[i]-xBar)*(x[i]-xBar);
      yyBar+=(y[i]-yBar)*(y[i]-yBar);
      xyBar+=(x[i]-xxBar)*(y[i]-yBar);
    }
    d = (2*xyBar)/(xxBar-yyBar);
    theta = Math.toDegrees(Math.atan(d));
  }

  private void calculateFt(){
    double ft1 = (yyBar-xxBar)*Math.cos(theta) - 2*xyBar*Math.sin(theta);
    double ft2 = (yyBar-xxBar)*Math.cos(theta+180) - 2*xyBar*Math.sin(theta+180);
    if(ft1>ft2){
      ft = ft1;
    }
    else{
      ft = ft2;
    }
  }
  private void calculateAbc(){
    a = Math.cos(theta/2);
    b = Math.sin(theta/2);
    c = (-a*xBar) - (b*yBar);

  }
}
