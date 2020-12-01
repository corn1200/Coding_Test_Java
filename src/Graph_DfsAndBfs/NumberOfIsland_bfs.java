package Graph_DfsAndBfs;

import java.util.LinkedList;
import java.util.Queue;

// 0과 1로 이루어진 2차원 배열이 있습니다.
// 0은 바다를 의미하고 1은 육지를 의미합니다.
// 2차원 배열의 인덱스는 평면의 좌표라고 가정합니다.
// 이 프로그램의 최종적인 목적은 평면 상의 모든 섬을 구하는 것인데,
// 섬의 정의는 1과 이어진 모든 1. 즉, 상하좌우로 이어져있는 육지를
// 하나의 섬으로 취급합니다.

public class NumberOfIsland_bfs {

    public static void main(String[] args) {
        char[][] grid= {
                {'1','1','0','0','1'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
                {'1','0','0','1','1'}
        };
        NumberOfIsland_bfs a = new NumberOfIsland_bfs();
        System.out.println(a.solve(grid));
    }
    int m, n;

    // 섬의 개수를 구합니다.
    public int solve(char[][] grid1) {
        // 평면 데이터가 정상적인지 확인합니다.
        if(grid1==null || grid1.length==0) {
            return 0;
        }
        m = grid1.length;
        n = grid1[0].length;
        int count=0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // 육지를 발견하면 즉시 섬의 개수를 한개 추가하고
                // 주변에 이어져있는 육지가 판별합니다.
                if(grid1[i][j]=='1') {
                    count++;
                    bfs(grid1,i,j);
                    print(grid1);
                }
            }
        }
        return count;
    }

    int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};

    public void bfs(char[][] grid2, int x, int y) {
        // 발견한 육지를 X 표시하여 더 이상 섬의 개수를
        // 구할 때 포함 시키지 않습니다.
        grid2[x][y] ='X';
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});
        while(!queue.isEmpty()) {
            int[] p = queue.poll();
            // 매개변수로 받아온 좌표의 상하좌우 좌표를 확인합니다.
            // 유효한 좌표인 동시에 해당 좌표가 육지라면
            // 처음 발견한 육지에서 이어진 육지이기 때문에
            // X 표시를 하여 다시 섬의 개수를 셀 때
            // 포함되지 않게 합니다.
            for(int[] dir : dirs) {
                int dx = p[0]+dir[0];
                int dy = p[1]+dir[1];
                // 유효한 좌표인지 확인하고 육지일 경우 X 표시를 한 후에
                // 해당 좌표를 상하좌우를 다시 확인하게 합니다.
                if(dx>=0&& dx<m && dy>=0 && dy<n && grid2[dx][dy]=='1') {
                    grid2[dx][dy]='X';
                    queue.offer(new int[] {dx, dy});
                }
            }
        }

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