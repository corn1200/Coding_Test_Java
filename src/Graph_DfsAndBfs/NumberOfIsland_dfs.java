package Graph_DfsAndBfs;

// 2차원 배열의 인덱스는 평면의 좌표이고
// 내부의 값은 각 좌표가 육지인지 바다인지의 구분입니다.
// 1은 육지 0은 바다, 상하좌우로 이어져 있는 육지는
// 섬으로 구분되며 문제의 내용은 섬의 갯수를 출력하는 것입니다.

public class NumberOfIsland_dfs {
    public static void main(String[] args) {
        // grid 에는 우리가 계산해야할 평면의 데이터를 삽입하고
        // island_dfs 객체를 생성하여 클래스 함수를 이용한
        // 풀이를 할 것입니다.
        char[][] grid = {
                {'1','1','1','0','1'},
                {'1','1','0','0','0'},
                {'1','1','0','0','1'},
                {'1','0','0','0','1'}
        };

        NumberOfIsland_dfs island_dfs = new NumberOfIsland_dfs();
        System.out.println(island_dfs.fetchIslands(grid));
    }

    int m,n;

    // 우선 평면의 데이터가 유효한가를 확인합니다.
    // 가로, 세로(1차원과 2차원)의 크기를 계산하여
    // 크기대로 평면의 데이터를 확인합니다.
    // 육지를 의미하는 1을 조우시 섬의 갯수를 추가합니다.

    int fetchIslands(char[][] grid) {
        print(grid);

        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        m = grid.length;
        n = grid[0].length;
        int countOfIsland = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    countOfIsland++;
                    mergeLand(grid, i , j);
                }
            }
        }

        print(grid);
        return countOfIsland;
    }

    // 육지를 발견하면 주변에 연결된 육지를 전부 하나의 섬으로
    // 취급합니다. 그러기 위해선 현재 위치와 주변(상하좌우)의
    // 육지(1)들을 X로 표기하여 더 이상 별개의 섬으로
    // 세지 않도록 해야 합니다. mergeLand 함수 안에서
    // 현 위치의 X 처리를 하고 상하좌우에 해당하는 좌표에도
    // 똑같이 mergeLand 의 X 처리를 하며 더 이상
    // X 처리할 육지(섬과 연결된 육지)가 없다면 return 을
    // 하며 확장 처리를 중지합니다.

    void mergeLand(char[][] grid, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] != '1') return;
        grid[i][j] = 'X';

        mergeLand(grid, i-1, j);
        mergeLand(grid, i+1, j);
        mergeLand(grid, i, j+1);
        mergeLand(grid, i, j-1);
    }

    void print(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}
