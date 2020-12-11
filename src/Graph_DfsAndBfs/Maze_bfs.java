package Graph_DfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

// 평면 좌표에서 0은 지나갈 수 있는 길,
// 1은 지나갈 수 없는 벽으로 표현합니다.
// maze 평면에서 미로의 시작점과 종착점을
// 입력받고 시작점에서 종착점까지 도착할 수 있는가를
// 판단하여 true or false 를 출력합니다.
// 규칙상 이동은 일직선으로만 할 수 있기 때문에
// 지나갈 수 없는 구간을 만나기 전까지 방향을
// 전환할 수 없습니다.
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

    // 현 좌표를 기준으로 상하좌우를 가르키는 좌표집합입니다.
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row, column;

    // 미로의 데이터와 시작점, 종착점 좌표를 받습니다.
    // 시작점에서 출발하여 상하좌우로 탐색합니다.
    // 지나갈 수 있는 길은 queue 구조에 저장하고
    // 지나갈 수 없는 길은 지나칩니다.
    // 지나갈 수 있는 길을 발견하면
    // 계속 해당 방향으로 직진하며 벽을 만나거나
    // 미로의 크기를 벗어나면 해당 좌표에서 한번
    // 뒤로 가고 해당 좌표가 도착 지점인지 확인합니다.
    // 좌표를 확인하기 전엔 항상 visited 에 좌표를 기록하여
    // 중복으로 좌표를 확인하지 않도록 합니다.
    private boolean hasPath(int[][] maze, int[] start, int[] destinations) {
        row = maze.length;
        column = maze[0].length;

        // 입력 받은 시작점과 종착점이 같을 경우 true를 반환합니다.
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

                // 이미 방문한적 있는 좌표는 나머지 동작을 건너뜁니다.
                if (visited[x][y]) {
                    continue;
                }
                visited[x][y] = true;

                // 만약 현 좌표가 도착점이라면 true 를 반환합니다.
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
