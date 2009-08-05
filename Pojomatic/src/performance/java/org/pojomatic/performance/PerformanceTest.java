package org.pojomatic.performance;

import static org.junit.Assert.*;

import org.pojomatic.Pojomatic;

import examples.Common;

public class PerformanceTest {

  public static void main(String[] args) {
    long beginTime = System.currentTimeMillis();
    int iterations = 10000000;
    testEquals(iterations);
    System.out.println("");

    long endTime = System.currentTimeMillis();
    System.out.println("Done in " + (endTime - beginTime) / 1000 + " seconds");
  }

  private static void testEquals(int iterations) {
    for (int i=0; i < iterations; ++i) {
      Common a1 = new Common();
      a1.setAnInt(i);
      a1.setMyString(String.valueOf(i));
      Common a2 = new Common();
      a2.setAnInt(i);
      a2.setMyString(String.valueOf(i));

      assertTrue(Pojomatic.equals(a1, a2));
      assertTrue(Pojomatic.equals(a2, a1));

      Common b = new Common();
      assertFalse(Pojomatic.equals(a1, b));
      assertFalse(Pojomatic.equals(a2, b));

      assertFalse(Pojomatic.equals(b, a1));
      assertFalse(Pojomatic.equals(b, a2));

      if (i % 100000 == 0) {
        System.out.print('.');
        System.out.flush();
      }
    }
  }

}
