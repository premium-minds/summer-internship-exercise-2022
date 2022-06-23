package com.premiumminds.internship.screenlocking;

import java.util.*;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockingPattern implements IScreenLockinPattern {
    private ComputeAdditionalPaths computeAdditionalPaths;
    public ScreenLockingPattern(){
        computeAdditionalPaths = new ComputeAdditionalPaths();
    }
 /**
  * Method to count patterns from firstPoint with the length
  * @param firstPoint initial matrix position
  * @param length the number of points used in pattern
  * @return number of patterns
  */
  public Future<Integer> countPatternsFrom(int firstPoint,int length) {
    throw new RuntimeException("Not Implemented Yet");
  };

  private List<Integer> getNeighbors(boolean [] inPath, int number) throws Exception {
      List<Integer> neighbors = computeAdditionalPaths.normalNeighbors(number);
      List<Integer> additionalNeighbors = computeAdditionalPaths.additionalPaths(inPath,number);
      neighbors.addAll(additionalNeighbors);
      return neighbors;
  }
  //[1, 2, 9, 5, 4, 7, 3]
  private Set<String> calculatePaths(int startIndex, int length) throws Exception {
      boolean inPath [] = new boolean[10];
      Set<Integer> path = new LinkedHashSet<>();
      Set<String> result = new HashSet<>();
      Stack<Integer> unprocessedNodes = new Stack<>();
      unprocessedNodes.add(startIndex);
      while(!unprocessedNodes.isEmpty()){
          int current = unprocessedNodes.pop();
          if(inPath[current]){
            path.remove(current);
            inPath[current]=false;
          }else if(path.size() < length ){
              if(path.add(current)){
                  inPath[current]=true;
                  unprocessedNodes.push(current);
                  if(path.size()<length){
                      List<Integer> neighbors = getNeighbors(inPath,current);
                      for (int aux:neighbors) {
                          if(!inPath[aux]){
                              unprocessedNodes.push(aux);
                          }
                      }
                  }else{
                      result.add(path.toString());
                  }
              }
          }else{
              result.add(path.toString());
          }
      }
      return result;
  }

  public static void main(String [] args) throws Exception {
      ScreenLockingPattern screenLockingPattern = new ScreenLockingPattern();
      long start = System.nanoTime();
      Set<String> result = screenLockingPattern.calculatePaths(3,9);
      System.out.println("TOOK "+(System.nanoTime()-start));
      System.out.println("GENERATED "+result.size());
  }
}
