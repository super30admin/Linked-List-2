// Time complexity: O(n * n) where n is the length of the sqaure matrix.
// Space complexity: O(1).
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class MinFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return 0;
        int n = matrix.length;
        int min = Integer.MAX_VALUE;
        // Add values top to bottom.
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(j == 0) {            // no (j - 1) column.
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]); 
                }
                else if(j == n - 1) {   // No (j + 1) column.
                    matrix[i][j] += Math.min(matrix[i - 1][j], matrix[i - 1][j - 1]); 
                }
                else {
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i - 1][j], matrix[i - 1][j + 1]));
                }
            }
        }
        for(int i = 0;i < n;i++) {      // Minimum from the last row.
            min = Math.min(min, matrix[n - 1][i]);
        }
        return min;
    }
}