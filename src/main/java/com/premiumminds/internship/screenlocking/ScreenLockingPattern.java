package com.premiumminds.internship.screenlocking;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aamado on 05-05-2022.
 */
class ScreenLockingPattern implements IScreenLockinPattern {
    private final ComputeAdditionalPaths computeAdditionalPaths;
    private final ExecutorService executor = Executors.newSingleThreadExecutor();

    public ScreenLockingPattern() {
        computeAdditionalPaths = new ComputeAdditionalPaths();
    }

    public static void main(String[] args) {
        ScreenLockingPattern screenLockingPattern = new ScreenLockingPattern();
        long start = System.nanoTime();
        Set<String> result = screenLockingPattern.calculatePaths(1, 7);

        /**
         *         for (String r:result
         *              ) {
         *             System.out.println(r);
         *         }
         */
        System.out.println("TOOK " + (System.nanoTime() - start));
        System.out.println("GENERATED " + result.size());
    }

    /**
     * Method to count patterns from firstPoint with the length
     *
     * @param firstPoint initial matrix position
     * @param length     the number of points used in pattern
     * @return number of patterns
     */
    public Future<Integer> countPatternsFrom(int firstPoint, int length) {
        return executor.submit(() -> calculatePaths(firstPoint, length).size());
    }

    private void addToStack(Stack<Integer> unprocessedNodes, boolean[] inPath, List<Integer> neighbors) {
        for (int aux : neighbors) {
            if (!inPath[aux]) {
                unprocessedNodes.push(aux);
            }
        }
    }
    private void addToStack2(Stack<Integer> unprocessedNodes, boolean[] inPath, List<ComputeAdditionalPaths.FromTo> neighbors) {
        for (ComputeAdditionalPaths.FromTo aux : neighbors) {
            if ((inPath[aux.x()]) && !inPath[aux.y()]) {
                unprocessedNodes.push(aux.y());
            }
        }
    }

    //[1, 2, 9, 5, 4, 7, 3]
    /**
     * A variant of depth first search is implemented to find all
     * possible paths from startIndex to all nodes until with size length
     * @param startIndex
     * @param length
     * @return
     */
    public Set<String> calculatePaths(int startIndex, int length) {
        if (startIndex > 9 || startIndex < 1 || length > 9 || length < 1) {
            return new HashSet<>();
        }
        //int countPatter = 0;
        boolean[] inPath = new boolean[10];
        Set<Integer> path = new LinkedHashSet<>();
        Set<String> result = new HashSet<>();
        Stack<Integer> unprocessedNodes = new Stack<>();
        unprocessedNodes.add(startIndex);
        while (!unprocessedNodes.isEmpty()) {
            int current = unprocessedNodes.pop();
            if (inPath[current]) {
                path.remove(current);
                inPath[current] = false;
            } else if (path.size() < length && path.add(current)) {
                inPath[current] = true;
                unprocessedNodes.push(current);
                if (path.size() < length) {
                    List<Integer> neighbors = computeAdditionalPaths.normalNeighbors(current);
                    List<ComputeAdditionalPaths.FromTo> moreNeighbors = computeAdditionalPaths.moreNeighbors(current);
                    addToStack(unprocessedNodes, inPath, neighbors);
                    addToStack2(unprocessedNodes, inPath, moreNeighbors);
                } else {
                    result.add(path.toString());
                    //countPatter++;
                }
            }
        }
        //assert countPatter==result.size();
        return result;
    }
}
