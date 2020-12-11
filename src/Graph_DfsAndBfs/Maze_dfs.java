package Graph_DfsAndBfs;

public class Maze_dfs {

    // 평면 maze 에서 0은 지나갈 수 있는 길이고
    // 1은 지나갈 수 없는 길입니다.
    // 시작 지점과 종착 지점을 입력받고
    // 시작 지점에서 종착 지점까지 도달할 수 있는지
    // 판단하는 프로그램입니다.
    public static void main(String[] args) {
        int[][] maze = {
                {0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0},
                {1, 1, 0, 1, 1},
                {0, 0, 0, 0, 0}
        };
        int[] start = {0, 4};
        int[] dest = {3, 2};
        Maze_dfs object = new Maze_dfs();
        System.out.println(object.hasPath(maze, start, dest));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row, column;

    // 평면의 크기를 구하고 중복방문 방지를 위한
    // visited 배열을 생성하여 방문한 좌표를
    // 저장합니다.
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        row = maze.length;
        column = maze[0].length;
        boolean[][] visited = new boolean[row][column];
        return dfs(maze, start, destination, visited);
    }

    // 현 좌표에서 상하좌우 방향으로 1을 만나거나
    // 더 이상 이동할 수 없을 때 까지 좌표를 이동시키고
    // 해당 좌표가 도착지점일 경우 true 를 반환하고
    // 아닐 경우 해당 좌표에서 다시 상하좌우
    // 방향을 탐색합니다.
    public boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {

        // 현재 위치가 평면 좌표에서 벗어나거나 이미 방문한 기록이 있다면 탐색을 중지합니다.
        if (start[0] < 0 || start[0] >= row || start[1] < 0 || start[1] >= column || visited[start[0]][start[1]]) {
            return false;
        }

        // 위치 좌표가 유효한 경우 방문 기록을 남깁니다.
        // 현재 위치가 도착 위치와 일치하는 경우
        // 미로 도달 가능 여부에 대해 true 를
        // 반환하고 종료합니다.
        visited[start[0]][start[1]] = true;
        if (start[0] == destination[0] && start[1] == destination[1]) {
            return true;
        }

        // 도착 위치에 해당되지 않고 좌표가 유효하며
        // 방문한 적이 없다면 현 좌표를 기준으로
        // 상하좌우를 탐색합니다.
        // 1을 만나거나 평면 좌표를 이달하기 전까지
        // 한 방향으로 좌표를 이동시킵니다.
        // 도착지점에 도달하면 결과적으로 true 를 반환하고
        // 모든 경우를 방문했음에도 도착지점에 도달하지 못하면
        // 결과적으로 false 를 반환합니다.
        for (int[] dir : dirs) {
            int x = start[0];
            int y = start[1];
            while (x >= 0 && x < row && y >= 0 && y < column && maze[x][y] != 1) {
                x += dir[0];
                y += dir[1];
            }
            x -= dir[0];
            y -= dir[1];
            if (dfs(maze, new int[]{x, y}, destination, visited)) {
                return true;
            }
            System.out.println();
        }

        return false;
    }

    private void print(boolean[][] visited) {
        if (visited == null || visited.length == 0)
            return;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                System.out.print(visited[i][j] + "\t");
            }
            System.out.println();
        }
    }

}