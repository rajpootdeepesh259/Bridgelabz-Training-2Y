public class WordSearch {
    private static final int[] dRow = {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] dCol = {-1, 0, 1, -1, 1, -1, 0, 1};

    public boolean findWord(char[][] grid, String word) {
        int rows = grid.length;
        int cols = grid[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(grid, word, r, c, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] grid, String word, int r, int c, int index, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) {
            return false;
        }
        if (visited[r][c] || grid[r][c] != word.charAt(index)) {
            return false;
        }
        if (index == word.length() - 1) {
            return true;
        }
        visited[r][c] = true;
        for (int i = 0; i < 8; i++) {
            int nextR = r + dRow[i];
            int nextC = c + dCol[i];
            if (dfs(grid, word, nextR, nextC, index + 1, visited)) {
                return true;
            }
        }
        visited[r][c] = false;
        return false;
    }
}
