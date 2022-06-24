package com.premiumminds.internship.screenlocking;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * Created by aamado on 05-05-2022.
 */
@RunWith(JUnit4.class)
public class ScreenLockinPatternTest {

  /**
   * The corresponding implementations to test.
   *
   * If you want, you can make others :)
   *
   */
  public ScreenLockinPatternTest() {
  };

  @Test
  public void testOneNeighbors() {
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(1);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,1);
    assertEquals(0,moreNeighbors.size());
    inPath[2]=inPath[5]=inPath[4]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,1);
    assertTrue(moreNeighbors.contains(3)&&moreNeighbors.contains(7)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,1);
    assertTrue(moreNeighbors.contains(3)&&moreNeighbors.contains(7)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());
  }

  @Test
  public void testTwoNeighbors() throws Exception {
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(2);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(7,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,2);
    assertEquals(0,moreNeighbors.size());

    inPath[5]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,2);
    assertTrue(moreNeighbors.contains(8));
    assertEquals(1,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,2);
    assertTrue(moreNeighbors.contains(8));
    assertEquals(1,moreNeighbors.size());
  }

  @Test
  public void testThreeNeighbors() {
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(3);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,3);
    assertEquals(0,moreNeighbors.size());
    inPath[2]=inPath[5]=inPath[6]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,3);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(7)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,3);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(7)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());
  }

  private void allTrue(boolean [] inPath){
    Arrays.fill(inPath,true);
  }
  @Test
  public void testAllTrueMethod(){
    boolean [] inPath = new boolean[10];
    allTrue(inPath);
    assertEquals(10,inPath.length);
    for (boolean element:inPath) {
      assertTrue(element);
    }
  }
  @Test
  public void testFourNeighbors() {
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(4);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(8));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(7,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,4);
    assertEquals(0,moreNeighbors.size());

    inPath[5]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,4);
    assertTrue(moreNeighbors.contains(6));
    assertEquals(1,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,4);
    assertTrue(moreNeighbors.contains(6));
    assertEquals(1,moreNeighbors.size());

  }

  @Test
  public void testFiveNeighbors(){
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(5);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(8));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(8,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,5);
    assertEquals(0,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,5);
    assertEquals(0,moreNeighbors.size());
  }
  @Test
  public void testSixNeighbors(){
    int number = 6;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(number);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(8));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(7,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertEquals(0,moreNeighbors.size());
    inPath[5]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(4));
    assertEquals(1,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(4));
    assertEquals(1,moreNeighbors.size());
  }
  @Test
  public void testSevenNeighbors(){
    int number = 7;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(number);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertEquals(0,moreNeighbors.size());
    inPath[4]=inPath[5]=inPath[8]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(3)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(3)&&moreNeighbors.contains(9));
    assertEquals(3,moreNeighbors.size());
  }
  @Test
  public void testEightNeighbors(){
    int number = 8;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(number);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(7,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertEquals(0,moreNeighbors.size());
    inPath[5]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(2));
    assertEquals(1,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(2));
    assertEquals(1,moreNeighbors.size());
  }
  @Test
  public void testNineNeighbors(){
    int number = 9;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(number);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    boolean [] inPath = new boolean[10];
    List<Integer> moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertEquals(0,moreNeighbors.size());
    inPath[5]=inPath[6]=inPath[8]=true;
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(3)&&moreNeighbors.contains(7));
    assertEquals(3,moreNeighbors.size());

    allTrue(inPath);
    moreNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
    assertTrue(moreNeighbors.contains(1)&&moreNeighbors.contains(3)&&moreNeighbors.contains(7));
    assertEquals(3,moreNeighbors.size());
  }

  @Test
  public void testCalculatePaths(){
    List<Integer> [] matrix = new List[10];
    List<Integer> [] matrixWithFriendshipExtension = new List[10];
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    ScreenLockingPattern screenLockingPattern = new ScreenLockingPattern();
    assertEquals(0,screenLockingPattern.calculatePaths(3,0).size());
    assertEquals(0,screenLockingPattern.calculatePaths(4,10).size());
    assertEquals(0,screenLockingPattern.calculatePaths(10,6).size());
    assertEquals(0,screenLockingPattern.calculatePaths(0,7).size());

    boolean [] inPath = new boolean[10];
    allTrue(inPath);
    for (int i = 1; i < matrix.length; i++) {
      matrixWithFriendshipExtension[i]  = computeAdditionalPaths.additionalPaths(inPath,i);
      matrix[i] = computeAdditionalPaths.normalNeighbors(i);
    }

    Random random = new Random();

    int maxIteration = random.nextInt(5,10);
    for (int i = 0; i < maxIteration; i++) {
      int index = random.nextInt(1,10);
      int len = random.nextInt(1,10);
      Set<String> result = screenLockingPattern.calculatePaths(index,len);

      assertTrue(result.size()>0);

      for (String seq:result) {
        String [] elems = seq.replace("[","").replace("]","").split(",");
        Assert.assertEquals(index,Integer.parseInt(elems[0]));
        Assert.assertEquals(len,elems.length);
        int current, next;
        for (int j = 0; j < len-1; j++) {
          current = Integer.parseInt(elems[j].trim());
          next = Integer.parseInt(elems[j+1].trim());
          assertTrue(matrix[current].contains(next)||matrixWithFriendshipExtension[current].contains(next));
          assertTrue(matrix[next].contains(current)||matrixWithFriendshipExtension[next].contains(current));
        }
      }
    }
  }
  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockingPattern().countPatternsFrom(3, 2);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 5);
  }
}