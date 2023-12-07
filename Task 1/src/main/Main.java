import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    double[] doublesEmpty = new double[0];

    double[] doubles3Int = {3,3,3};

    double[] doubles5Double = {0.29, 0.051, 0.16, 0.59, 0.97};

    double[] doubles = {0, 6, 0.16, -5, 0.97, 0, -9.05, 8.49, 0.01, 0, 3.75, -1.94, 0, 6.28, -4.91,
            -7.63, 2.5, 0, 12345.0987654321};

    for (double[] d: new double[][]{doublesEmpty, doubles3Int, doubles5Double, doubles}) {

      System.out.println(DoubleStreamProcessor.numberZeros(Arrays.stream(d)));
      System.out.println(DoubleStreamProcessor.isStreamFractional(Arrays.stream(d)));
      System.out.println(DoubleStreamProcessor.rangeValues(Arrays.stream(d)));
      System.out.println(Arrays.toString(DoubleStreamProcessor.numberLargerLimit(Arrays.stream(d), 0)));
      System.out.println(DoubleStreamProcessor.longestNumber(Arrays.stream(d)));
      System.out.println();
    }

  }
}