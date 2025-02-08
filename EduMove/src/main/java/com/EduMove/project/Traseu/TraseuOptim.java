package com.EduMove.project.Traseu;

import java.util.ArrayList;
import java.util.List;

public class TraseuOptim {

    private double[][] distanceMatrix;
    private double minDistance = Double.MAX_VALUE; // Păstrează lungimea minimă
    private List<Integer> bestPath = new ArrayList<>(); // Păstrează traseul optim

    public TraseuOptim(double[][] distanceMatrix) {
        this.distanceMatrix = distanceMatrix;
    }

    public List<Integer> findOptimalPath() {
        int n = distanceMatrix.length;
        boolean[] visited = new boolean[n]; // Marcare pentru stațiile vizitate
        List<Integer> currentPath = new ArrayList<>();

        visited[0] = true;
        currentPath.add(0);

        backtrack(0, visited, currentPath, 0);

        return bestPath;
    }

    private void backtrack(int currentStation, boolean[] visited, List<Integer> currentPath, double currentDistance) {
        int n = distanceMatrix.length;

        if (currentPath.size() == n) {
            double roundTripDistance = currentDistance + distanceMatrix[currentStation][0];
            if (roundTripDistance < minDistance) {
                minDistance = roundTripDistance;
                bestPath = new ArrayList<>(currentPath);
                bestPath.add(0); // Adaugă punctul de plecare pentru închiderea circuitului
            }
            return;
        }

        for (int nextStation = 0; nextStation < n; nextStation++) {
            if (!visited[nextStation]) {
                double nextDistance = currentDistance + distanceMatrix[currentStation][nextStation];

                if (nextDistance >= minDistance) {
                    continue;
                }

                visited[nextStation] = true;
                currentPath.add(nextStation);

                backtrack(nextStation, visited, currentPath, nextDistance);

                visited[nextStation] = false;
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

    public double getMinDistance() {
        return minDistance;
    }
}

