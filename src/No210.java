import java.util.LinkedList;
import java.util.Queue;

public class No210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        int[][] adjacencyMatrix = new int[numCourses][numCourses];

        for (int i = 0; i < prerequisites.length;i++) {
            adjacencyMatrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }

        int[] result = new int[numCourses];
        int count = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                result[count++] = i;
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            for (int i = 0; i < numCourses; i++) {
                if (adjacencyMatrix[course][i] == 1) {
                    if (--inDegree[i] == 0) {
                        result[count++] = i;
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses ? result : new int[0];
    }
}
