import java.util.*;

public class Solution {
    public int equalPairs(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int count = 0;
        
        Map<String, Integer> freqMapper = new HashMap<>();
        
        for (int[] row : grid) {
            String key = Arrays.toString(row);
            freqMapper.put(key, freqMapper.getOrDefault(key, 0) + 1);
        }
        
        for (int j = 0; j < c; j++) {
            int[] column = new int[r];
            for (int i = 0; i < r; i++) {
                column[i] = grid[i][j];
            }
            String key = Arrays.toString(column);
            if (freqMapper.containsKey(key)) {
                count += freqMapper.get(key);
            }
        }
        
        return count;
    }
}