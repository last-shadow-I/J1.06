import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DoubleStreamProcessorTest {

  double[] doublesEmpty = new double[0];

  double[] doubles3Int = {3,3,3};

  double[] doubles5Double = {0.29, 0.051, 0.16, 0.59, 0.97};

  double[] doubles = {0, 6, 0.16, -5, 0.97, 0, -9.05, 8.49, 0.01, 0, 3.75, -1.94, 0, 6.28, -4.91,
          -7.63, 2.5, 0, 12345.0987654321};

  double[][] arrays = new double[][]{doublesEmpty, doubles3Int, doubles5Double, doubles};

  @Test
  void numberZeros() {
    Integer[] outputArr = {0, 0, 0, 5};
    for (int i = 0; i < arrays.length; i++) {
      assertEquals(outputArr[i], DoubleStreamProcessor.numberZeros(Arrays.stream(arrays[i])));
    }
  }

  @Test
  void isStreamFractional() {
    Boolean[] outputArr = {false, false, true, true};
    for (int i = 0; i < arrays.length; i++) {
      assertEquals(outputArr[i], DoubleStreamProcessor.isStreamFractional(Arrays.stream(arrays[i])));
    }
  }

  @Test
  void rangeValues() {
    Double[] outputArr = {null, 0.0, 0.9189999999999999, 12354.148765432099};
    for (int i = 0; i < arrays.length; i++) {
      assertEquals(outputArr[i], DoubleStreamProcessor.rangeValues(Arrays.stream(arrays[i])));
    }
  }

  @Test
  void numberLargerLimit() {
    double[][] outputArrays = new double[4][];

    outputArrays[0] = new double[0];
    outputArrays[1] = new double[] {3.0, 3.0, 3.0};
    outputArrays[2] = new double[0];
    outputArrays[3] = new double[] {6.0, 8.49, 3.75, 6.28, 2.5, 12345.0987654321};

    for (int i = 0; i < arrays.length; i++) {
      assertArrayEquals(outputArrays[i], DoubleStreamProcessor.numberLargerLimit(Arrays.stream(arrays[i]), 1));
    }
  }

  @Test
  void longestNumber() {
    Double[] outputArr = {null, 3.0, 0.051, 12345.0987654321};
    for (int i = 0; i < arrays.length; i++) {
      assertEquals(outputArr[i], DoubleStreamProcessor.longestNumber(Arrays.stream(arrays[i])));
    }
  }
}