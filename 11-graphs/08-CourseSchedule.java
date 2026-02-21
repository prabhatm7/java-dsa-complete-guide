// LC 207. Course Schedule
// Approach: Topological sort with cycle detection. DFS with 3 states: unvisited(0), visiting(1), visited(2).
// Time: O(V+E) | Space: O(V+E)
import java.util.*;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        for (int[] p : prerequisites) graph.get(p[0]).add(p[1]);
        int[] state = new int[numCourses];
        for (int i = 0; i < numCourses; i++)
            if (hasCycle(graph, state, i)) return false;
        return true;
    }

    private boolean hasCycle(List<List<Integer>> graph, int[] state, int node) {
        if (state[node] == 1) return true;
        if (state[node] == 2) return false;
        state[node] = 1;
        for (int neighbor : graph.get(node))
            if (hasCycle(graph, state, neighbor)) return true;
        state[node] = 2;
        return false;
    }
}
