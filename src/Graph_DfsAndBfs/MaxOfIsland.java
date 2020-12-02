package Graph_DfsAndBfs;

// 평면 상에서 1은 육지 0은 바다입니다.
// 섬은 상하좌우로 이어진 1들의 집합을 의미합니다.
// 평면 상의 섬들 중에서 가장 육지가 큰 섬의
// 육지 크기를 출력하는 프로그램입니다.
public class MaxOfIsland {
    public static void main(String[] args) {
        int[][] grid = {{1, 1, 0, 1, 1},
                        {0, 1, 1, 0, 0},
                        {0, 0, 0, 0, 0},
                        {1, 1, 0, 1, 1},
                        {1, 0, 1, 1, 1},
                        {1, 0, 1, 1, 1}};
        MaxOfIsland object = new MaxOfIsland();
        System.out.println(object.maxAreaOfIsland(grid));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int width, height;

    // 가장 크기가 큰 섬의 크기를 반환하는 함수입니다.
    // 넓이와 높이를 구한 후에 육지(1)를 만나면
    // 육지와 이어진 상하좌우의 육지를 찾고
    // 기존에 발견한 섬의 크기 보다 클 경우
    // 새로 발견한 섬의 크기로 최대크기 값을 대체합니다.
    private int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        width = grid[0].length;
        height = grid.length;
        int max = 0;

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j] == 1) {
                    int area = mergeMaxAreaAsDFS(grid, i, j, 0);
                    max = Math.max(max, area);
                }
            }

        }
        return max;
    }

    // 육지의 상하좌우를 탐색하면서 탐색한 육지는 바다(0)으로
    // 표기하여 다시 탐색하지 않게 합니다.
    // 상하좌우에 육지가 더 존재한다면 계속 탐색하고
    // 더 이상 존재하지 않으면 탐색을 종료하며
    // 매개변수로 받은 섬의 크기 값을 반환합니다.
    // 육지 주변을 전부 탐색했으면 섬의 크기를 반환합니다.
    int mergeMaxAreaAsDFS(int[][] grid, int x, int y, int area) {
        if (x < 0 || x >= height || y < 0 || y >= width || grid[x][y] == 0) {
            return area;
        }
        grid[x][y] = 0;
        area++;
        for (int[] dir : dirs) {
            area = mergeMaxAreaAsDFS(grid, x + dir[0], y + dir[1], area);
        }
        return area;
    }
}
