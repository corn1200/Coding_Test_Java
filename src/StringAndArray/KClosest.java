package StringAndArray;

import java.util.PriorityQueue;
import java.util.Queue;

public class KClosest {
    public static void main(String[] args) {
        KClosest a = new KClosest();
        int[][] points = {{1, 3}, {-2, 2}};
        int k = 2;
        int[][] result = a.solve(points, k);
        a.print(result);
    }

    public int[][] solve(int[][] points, int k) {
        Queue<int[]> queue = new PriorityQueue<>(points.length, (a,b) -> (a[0]*a[0]+a[1]*a[1]) - (b[0]*b[0]+b[1]*b[1]));
        int[][] result = new int[k][2];
        int index = 0;

        for (int[] p : points) {
            queue.offer(p);
        }
        while (index < k) {
            result[index] = queue.poll();
            index++;
        }
        return result;
    }

    public void print(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
