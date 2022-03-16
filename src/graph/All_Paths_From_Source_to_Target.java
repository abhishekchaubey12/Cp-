/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 16/03/2022
 *   Time: 06:14
 *   File: All_Paths_From_Source_to_Target.java
 */

package graph;

import java.util.ArrayList;
import java.util.List;

public class All_Paths_From_Source_to_Target {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> answer = new ArrayList<>();
        int n = graph.length;
        boolean[] visited = new boolean[n];
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(0);
        sourceToTarget(graph, 0, visited, n, new ArrayList<>(), answer);
        return answer;

    }

    private void sourceToTarget(int[][] graph, int currentNode, boolean[] visited, int n, List<Integer> currentPath, List<List<Integer>> answer) {
        if (currentNode == n - 1) {
            currentPath.add(currentNode);
            answer.add(new ArrayList<>(currentPath));
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        if (visited[currentNode] == true) {
            return;
        }
        visited[currentNode] = true;
        currentPath.add(currentNode);

        for (Integer neighbour : graph[currentNode]) {
            sourceToTarget(graph, currentNode, visited, n, currentPath, answer);
            visited[currentNode] = false;
            currentPath.remove(currentPath.size() - 1);
            return;
        }
        visited[currentNode] = false;
        return;
    }
}