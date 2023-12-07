
import java.util.Arrays;
import java.util.stream.DoubleStream;

public class DoubleStreamProcessor {

  public static int numberZeros(DoubleStream stream){
    return (int) stream.filter(c -> c == 0).count();
  }

  public static boolean isStreamFractional(DoubleStream stream){
    return stream.anyMatch(c -> c % 1 != 0);
  }

  public static Double rangeValues(DoubleStream stream){
    double[] doubles = stream.sorted().toArray();
    if (doubles.length != 0){
      return Math.abs(doubles[0] - doubles[doubles.length-1]);
    }
    return null;
  }

  public static double[] numberLargerLimit(DoubleStream stream, double limit){
    return stream.filter(c -> c > limit).toArray();
  }

  public static Double longestNumber(DoubleStream stream){
    double[] doubles = stream.toArray();
    if (doubles.length != 0){
      int maxLength = (int) Arrays.stream(doubles).map(c -> String.valueOf(c).length()).max().getAsDouble();

      return Arrays.stream(doubles).filter(c -> String.valueOf(c).length() == maxLength).findFirst().getAsDouble();
    }
    return null;
  }
}
