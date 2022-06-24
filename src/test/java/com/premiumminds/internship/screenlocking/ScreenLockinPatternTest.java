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
    int number = 1;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(1);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(3,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(2,3)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(4,7)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,9)));
  }

  @Test
  public void testTwoNeighbors() throws Exception {
    int number = 2;
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(1,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,8)));

  }

  @Test
  public void testThreeNeighbors() {
    int number = 3;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(3);
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(5));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(8));
    assertEquals(5,neighborsOfOne.size());

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(3,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(2,1)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,7)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(6,9)));
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
    int number = 4;
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(1,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,6)));
  }

  @Test
  public void testFiveNeighbors(){
    int number = 5;
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    List<Integer> neighborsOfOne = computeAdditionalPaths.normalNeighbors(number);
    Assert.assertTrue(neighborsOfOne.contains(1));
    Assert.assertTrue(neighborsOfOne.contains(2));
    Assert.assertTrue(neighborsOfOne.contains(3));
    Assert.assertTrue(neighborsOfOne.contains(4));
    Assert.assertTrue(neighborsOfOne.contains(6));
    Assert.assertTrue(neighborsOfOne.contains(7));
    Assert.assertTrue(neighborsOfOne.contains(8));
    Assert.assertTrue(neighborsOfOne.contains(9));
    assertEquals(8,neighborsOfOne.size());

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(1,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,4)));
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(3,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,3)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(4,1)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(8,9)));
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(1,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,2)));
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

    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(number);
    assertEquals(3,moreNeighbors.size());

    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(5,1)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(6,3)));
    assertTrue(moreNeighbors.contains(computeAdditionalPaths.toFromTo(8,7)));
  }

  @Test
  public void testCalculatePaths(){
    List<Integer> [] matrix = new List[10];
    List<ComputeAdditionalPaths.FromTo> [] matrixWithFriendshipExtension = new List[10];
    ComputeAdditionalPaths computeAdditionalPaths = new ComputeAdditionalPaths();
    ScreenLockingPattern screenLockingPattern = new ScreenLockingPattern();
    assertEquals(0,screenLockingPattern.calculatePaths(3,0).size());
    assertEquals(0,screenLockingPattern.calculatePaths(4,10).size());
    assertEquals(0,screenLockingPattern.calculatePaths(10,6).size());
    assertEquals(0,screenLockingPattern.calculatePaths(0,7).size());

    boolean [] inPath = new boolean[10];
    allTrue(inPath);
    for (int i = 1; i < matrix.length; i++) {
      matrixWithFriendshipExtension[i]  = computeAdditionalPaths.moreNeighbors(i);
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
          assertTrue(matrix[current].contains(next)||canHaveThisNeighbor(matrixWithFriendshipExtension[current],next));
          assertTrue(matrix[next].contains(current)||canHaveThisNeighbor(matrixWithFriendshipExtension[next],current));
        }
      }
    }
  }
  private boolean canHaveThisNeighbor(List<ComputeAdditionalPaths.FromTo> more, int y){
    for (ComputeAdditionalPaths.FromTo fromTo: more
         ) {
      if(fromTo.y()==y){
        return true;
      }
    }
    return false;
  }
  @Test
  public void ScreenLockinPatternTestFirst3Length2Test()  throws InterruptedException, ExecutionException, TimeoutException {
    Future<Integer> count  = new ScreenLockingPattern().countPatternsFrom(3, 2);
    Integer result = count.get(10, TimeUnit.SECONDS);
    assertEquals(result.intValue(), 5);
  }
}