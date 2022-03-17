/*   Created by IntelliJ IDEA.
 *   Author: Abhishek Kumar Chaubey
 *   Date: 17/03/2022
 *   Time: 20:24
 *   File: Find_The_Town_Judge.java
 */

package graph;

public class Find_The_Town_Judge {
    public int findJudge(int n, int[][] trust) {
        //outdegree indicates that the vertex to whom it is pointing out.
        int[] inDegree = new int[n + 1];
        // the indegree indicates how many are pointing towards the given vertices.
        int[] outDegree = new int[n + 1];

        //Here we are creating the graph. Like the first one indicate to second and vice versa.
        for (int i = 0; i < trust.length; i++) {
            int v1 = trust[i][0];
            int v2 = trust[i][1];

            outDegree[v1] += 1;
            inDegree[v2] += 1;

        }
        for (int i = 1; i <= n; i++) {
            if (outDegree[i] == 0 && inDegree[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }
}