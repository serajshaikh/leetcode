import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final int MOD = 1000000007;

    public int minMaxSums(int[] nums, int k) {
        int n = nums.length;
        long totalSum = 0;
        
        // Enumerate all non-empty subsequences
        for (int mask = 1; mask < (1 << n); mask++) {
            List<Integer> subsequence = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subsequence.add(nums[i]);
                }
            }

            // Only consider subsequences of size <= k
            if (subsequence.size() <= k) {
                int minVal = Integer.MAX_VALUE;
                int maxVal = Integer.MIN_VALUE;
                for (int num : subsequence) {
                    minVal = Math.min(minVal, num);
                    maxVal = Math.max(maxVal, num);
                }
                totalSum = (totalSum + minVal + maxVal) % MOD;
            }
        }
        
        return (int) totalSum;
    }

    public char[] dailyTemperatures(int[] is) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dailyTemperatures'");
    }

    public static char[] eraseOverlapIntervals(int[][] intervals) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eraseOverlapIntervals'");
    }
}