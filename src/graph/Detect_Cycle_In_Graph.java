/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 26/03/2022
 *   Time: 09:42
 *   File: Detect_Cycle_In_Graph.java
 */

package graph;

import java.util.ArrayList;
import java.util.HashSet;

public class Detect_Cycle_In_Graph {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        HashSet<Integer> recStack = new HashSet<>();
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < V; i++) {
            if (dfs(i, recStack, visited, adj)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int currentVertex, HashSet<Integer> recStack, HashSet<Integer> visited,
                        ArrayList<ArrayList<Integer>> adj) {
        visited.add(currentVertex);
        recStack.add(currentVertex);

        for (int edge : adj.get(currentVertex)) {
            if (!visited.contains(edge)) {
                if (dfs(edge, recStack, visited, adj)) {
                    return true;
                }
            }
            if (recStack.contains(edge)) {
                return true;
            }
        }
        recStack.remove(currentVertex);
        return false;
    }


}