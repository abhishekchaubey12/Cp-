/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 26/03/2022
 *   Time: 09:42
 *   File: Detect_Cycle_In_Graph.java
 */

package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

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


    //Kahn's Algorithm
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        int[] inDegree = new int[V];
        //traversing the graph for finding the neighbour of the given vertex
        for (int i = 0; i < V; i++) {
            for (int negh : adj.get(i)) {
                inDegree[negh]++;
            }
        }
        //
        Queue<Integer> queue = new LinkedList<>();

        //if inDegree of given vertex is 0 then add it into the queue
        //else traverse the loop.
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }
        int count = 0;
        //this loop will move until queue is not empty.
        while (!queue.isEmpty()) {
            //remove the first vertex from the queue.
            int currentVertex = queue.poll();
            //and make the count increase by 1.
            count++;
            //whenever we're exploring the neighbour, now look at indegree array and decrement the vertex by one
            //if inDegree is zero pull it into the queue.
            for (int node : adj.get(currentVertex)) {
                inDegree[node]--;
                if (inDegree[node] == 0) {
                    queue.add(node);
                }
            }
        }
        if (count == V) {
            return false;
        }
        return true;
    }


}