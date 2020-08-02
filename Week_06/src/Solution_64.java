class Solution_64 {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int nr = grid.length;
        int nc = grid[0].length;

        int dp[] = new int[nc];
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[0][0];
                } else if (i == 0) {
                    dp[j] = grid[i][j] + dp[j - 1];
                } else if (j == 0) {
                    dp[j] = grid[i][j] + dp[j];
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
                }
            }
        }

        return dp[nc - 1];
    }
}