/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 26/03/2022
 *   Time: 22:36
 *   File: Course_Schedule2.java
 */

package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Course_Schedule2 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = createGraph(numCourses, prerequisites);

        HashSet<Integer> visited = new HashSet<>();
        HashSet<Integer> recStack = new HashSet<>();
        List<Integer> traversal = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (visited.contains(i)) {
                continue;
            }
            //If your currentVertex is not visited you have to run dfs.
            if (isCycle(graph, i, visited, recStack, traversal)) {
                return new int[0];
            }
        }
        Collections.reverse(traversal);
        int[] answer = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            answer[i] = traversal.get(i);
        }

        return answer;
    }

    private List<List<Integer>> createGraph(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        //Now you need to populate your graph.
        for (int[] edge : prerequisites) {
            int v = edge[0];
            int u = edge[1];
            graph.get(u).add(v);
        }
        return graph;
    }


    private boolean isCycle(List<List<Integer>> graph, int currentVertex, HashSet<Integer> visited, HashSet<Integer> recStack, List<Integer> traversal) {
        visited.add(currentVertex);
        recStack.add(currentVertex);
        for (int neighbour : graph.get(currentVertex)) {
            if (!visited.contains(neighbour)) {
                if (isCycle(graph, currentVertex, visited, recStack, traversal)) {
                    return true;
                }
            }
            if (recStack.contains(neighbour)) {
                return true;
            }
        }
        traversal.add(currentVertex);
        recStack.remove(currentVertex);
        return false;
    }///
}


