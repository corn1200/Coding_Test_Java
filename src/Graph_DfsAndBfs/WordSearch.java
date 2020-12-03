package Graph_DfsAndBfs;

// 평면에서 지정된 글자들이 상하좌우로 연속해서
// 이어져 있는지에 대해 true or false 를
// 출력하는 프로그램입니다.
public class WordSearch {
    public static void main(String[] args) {
        char[][] grid = {{'A','B','C','E'},
                         {'S','F','C','S'},
                         {'A','D','E','E'}
        };
        String word = "ABCCED";
        WordSearch object = new WordSearch();
        System.out.println(object.setGridData(grid, word));
    }

    int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int row, column;

    // 평면을 순차적으로 확인하며 첫번째 글자를
    // 각 배열에 있는 글자를 한번씩 확인합니다.
    private boolean setGridData(char[][] grid, String word) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return false;
        }
        row = grid.length;
        column = grid[0].length;
        boolean[][] visited = new boolean[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; i < column; j++) {
                if (searchWordAsDFS(grid, visited, i, j, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    // 현재 배열의 값이 지정된 글자들 중에 start 번째에
    // 해당되지 않는다면 false 를 반환하고
    // 유효한 범위인 동시에 현재 배열의 값이 start 번째 글자에
    // 해당된다면 현재 배열을 이미 탐색했다는 표시를 하고
    // 다시 현재 배열에서 상하좌우를 탐지하며 다음
    // 글자에 해당하는 값이 있는지 탐지합니다.
    // 결과적으로 지정된 글자의 길이만큼의 길을 찾는다면
    // true 를 반환하고 결과적으로 길을 찾지 못하면
    // false 를 반환합니다.
    private boolean searchWordAsDFS(char[][] grid, boolean[][] visited, int x, int y, int start, String word) {
        if (start == word.length()) {
            return true;
        }
        if (x < 0 || x >= row || y < 0 || y >= column || visited[x][y] || grid[x][y] != word.charAt(start)) {
            return false;
        }
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (searchWordAsDFS(grid, visited, dx, dy, start + 1, word)) {
                return true;
            }
        }
        visited[x][y] = false;
        return false;
    }
}
