import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class No207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[][] matrix = new int[numCourses][numCourses];
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < prerequisites.length; i++) {
            matrix[prerequisites[i][1]][prerequisites[i][0]] = 1;
            inDegree[prerequisites[i][0]]++;
        }

        int count = 0;
        Queue<Integer> queue = new LinkedList();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            count++;
            for (int i = 0; i < numCourses; i++) {
                if (matrix[course][i] == 1) {
                    if (--inDegree[i] == 0) {
                        queue.offer(i);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
