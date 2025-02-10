class Solution {
    public long gridGame(int[][] grid) {
        int l = grid[0].length;
        long topSum = 0;
        long bottomSum = 0;

        for (int i = 0; i < l; i++) {
            topSum += grid[0][i];
            bottomSum += grid[1][i];
        }

        long result = Long.MAX_VALUE;


        long topAccumulated = 0; 
        long bottomAccumulated = 0;

        for (int i = 0; i < l; i++) {
            topSum -= grid[0][i]; 
            result = Math.min(result, Math.max(topSum, bottomAccumulated));
            bottomAccumulated += grid[1][i]; 
        }

        return result;
    }
}
