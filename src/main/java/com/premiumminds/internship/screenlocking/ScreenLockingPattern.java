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
        Set<String> result = screenLockingPattern.calculatePaths(3, 7);
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

    //[1, 2, 9, 5, 4, 7, 3]
    public Set<String> calculatePaths(int startIndex, int length) {
        if (startIndex > 9 || startIndex < 1 || length > 9 || length < 1) {
            return new HashSet<>();
        }
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
                    List<Integer> extendedNeighbors = computeAdditionalPaths.additionalPaths(inPath, current);
                    addToStack(unprocessedNodes, inPath, neighbors);
                    addToStack(unprocessedNodes, inPath, extendedNeighbors);
                } else {
                    result.add(path.toString());
                }
            }
        }
        return result;
    }
}
