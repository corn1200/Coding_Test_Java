package Graph_DfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

public class Maze_bfs {
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] destination = {4, 4};
        Maze_bfs object = new Maze_bfs();
        System.out.println(object.hasPath(maze, start, destination));
    }

    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row, column;
    private boolean hasPath(int[][] maze, int[] start, int[] destinations) {
        row = maze.length;
        column = maze[0].length;
        if (start[0] == destinations[0] && start[1] == destinations[1]) {
            return true;
        }
        boolean[][] visited = new boolean[row][column];
        visited[start[0]][start[1]] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});

        while (queue.isEmpty() == false) {
            int[] point = queue.poll();
            for (int[] dir : directions) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while (x >= 0 && x < row && y >= 0 && y <= column && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                }
                    x -= dir[0];
                    y -= dir[1];
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;
                if (x == destinations[0] && y == destinations[1]) {
                    return true;
                }
                queue.offer(new int[]{x, y});
            }
        }
        return false;
    }

    private void print(boolean[][] visited) {
        if (visited == null || visited.length == 0) {
            return;
        }
    }
}
