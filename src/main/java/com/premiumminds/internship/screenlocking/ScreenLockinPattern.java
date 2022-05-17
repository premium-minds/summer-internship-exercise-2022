package com.premiumminds.internship.screenlocking;

import java.util.concurrent.Future;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


import java.util.ArrayList;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockinPattern implements IScreenLockinPattern {

 /**
  * Method to count patterns from firstPoint with the length
  * @param firstPoint initial matrix position
  * @param length the number of points used in pattern
  * @return number of patterns
  */
  public Future<Integer> countPatternsFrom(int firstPoint,int length) {
    // TODO -> Check if firstPoint inside of matrix
    // TODO -> Check if length greater then 0 and less then 10

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    final Integer result = recursiveCountPattern(new ArrayList<Integer>(), new Integer(firstPoint), length);

    return executorService.submit( new Callable<Integer>() {
      public Integer call(){
        return result;
    }});
  };

  private Integer recursiveCountPattern(ArrayList<Integer> visited, Integer visiting, int remainLength){
    if (visited.contains(visiting)){
      return new Integer(0);
    }
    if (remainLength == 1){
      return new Integer(1);
    }

    Integer count = new Integer(0);
    visited.add(visiting);
    for (Integer adjacent: adjacentPoints(visiting, 3, visited))
      count += recursiveCountPattern(new ArrayList<Integer>(visited), adjacent, remainLength - 1);

    return count;

  }

  private ArrayList<Integer> adjacentPoints(int point, int matrixSize, ArrayList<Integer> visited){
    ArrayList<Integer> adjacentPoints = new ArrayList<Integer>();
    // TODO -> Create Object for this, static one, so that it doesn't need to create all this everytime
    ArrayList<Getter> getters = new ArrayList<Getter>();
    getters.add( new GetRight());
    getters.add( new GetLeft());
    getters.add( new GetUp());
    getters.add( new GetDown());
    getters.add( new GetUp_Right());
    getters.add( new GetUp_Left());
    getters.add( new GetDown_Right());
    getters.add( new GetDown_Left());

    Integer to_add;
  
    for(Getter getter: getters){
      to_add = getter.getAdjacentPoint(point, matrixSize, visited);
      if (to_add != null)
        adjacentPoints.add(to_add);
    }

    return adjacentPoints;
  }

  private interface Getter {
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited);
  }


  // TODO -> improve, a lot of repeated code
  private class GetRight implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point >= matrixSize * matrixSize)
        return null;
      
      if (!visited.contains(point + 1))
        return point + 1;
      return getAdjacentPoint(point + 1, matrixSize, visited);
    }
  }

  private class GetLeft implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point <= 1)
        return null;
      
      if (!visited.contains(point - 1))
        return point - 1;
      return getAdjacentPoint(point - 1, matrixSize, visited);
    }
  }

  private class GetDown implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point >= matrixSize * matrixSize)
        return null;
      
      if (!visited.contains(point + matrixSize))
        return point + matrixSize;

      return getAdjacentPoint(point + matrixSize, matrixSize, visited);
    }
  }

  private class GetUp implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point <= 1 || point <= matrixSize)
        return null;
      
      if (!visited.contains(point - matrixSize))
        return point - matrixSize;

      return getAdjacentPoint(point - matrixSize, matrixSize, visited);
    }
  }

  private class GetUp_Left implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point <= 1 || point <= matrixSize)
        return null;
      
      if (!visited.contains(point - (matrixSize + 1)))
        return point - (matrixSize + 1);

      return getAdjacentPoint(point - (matrixSize + 1), matrixSize, visited);
    }
  }

  private class GetUp_Right implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point <= 1 || point <= matrixSize || point == matrixSize)
        return null;
      
      if (!visited.contains(point - (matrixSize - 1)))
        return point - (matrixSize - 1);

      return getAdjacentPoint(point - (matrixSize - 1), matrixSize, visited);
    }
  }
  
  private class GetDown_Left implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point >= matrixSize * matrixSize || point >= matrixSize * (matrixSize - 1) || point == matrixSize * matrixSize - (matrixSize - 1))
        return null;
      
      if (!visited.contains(point + (matrixSize - 1)))
        return point + (matrixSize - 1);

      return getAdjacentPoint(point + (matrixSize - 1), matrixSize, visited);
    }
  }

  private class GetDown_Right implements Getter{
    public Integer getAdjacentPoint(int point, int matrixSize, ArrayList<Integer> visited){
      if (point >= matrixSize * matrixSize || point >= matrixSize * (matrixSize - 1))
        return null;
      
      if (!visited.contains(point + (matrixSize + 1)))
        return point + (matrixSize + 1);

      return getAdjacentPoint(point + (matrixSize + 1), matrixSize, visited);
    }
  }
}
