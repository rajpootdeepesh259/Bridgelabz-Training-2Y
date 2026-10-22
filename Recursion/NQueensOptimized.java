public class NQueensOptimized {
    private int size;
    private int[] queens;
    private boolean[] cols;
    private boolean[] diag1;
    private boolean[] diag2;

    public void solve(int n) {
        this.size = n;
        this.queens = new int[n];
        this.cols = new boolean[n];
        this.diag1 = new boolean[2 * n - 1];
        this.diag2 = new boolean[2 * n - 1];
        backtrack(0);
    }

    private void backtrack(int row) {
        if (row == size) {
            return;
        }
        for (int col = 0; col < size; col++) {
            if (!cols[col] && !diag1[row + col] && !diag2[row - col + size - 1]) {
                queens[row] = col;
                cols[col] = true;
                diag1[row + col] = true;
                diag2[row - col + size - 1] = true;
                backtrack(row + 1);
                cols[col] = false;
                diag1[row + col] = false;
                diag2[row - col + size - 1] = false;
            }
        }
    }
}
