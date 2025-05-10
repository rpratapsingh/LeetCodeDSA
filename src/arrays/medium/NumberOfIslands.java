package arrays.medium;

class NumberOfIslands {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int numIslands = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    dfs(i, j, grid, n, m);
                    numIslands++;
                }
            }
        }
        return numIslands;
    }

    private void dfs(int i, int j, char[][] grid, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '$';
        dfs(i + 1, j, grid, n, m);
        dfs(i, j + 1, grid, n, m);
        dfs(i - 1, j, grid, n, m);
        dfs(i, j - 1, grid, n, m);
    }
}

class NumberOfIslandsTest {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        NumberOfIslands numberOfIslands = new NumberOfIslands();
        System.out.println(numberOfIslands.numIslands(grid));
    }

}
