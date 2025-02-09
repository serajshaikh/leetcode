
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int maxLen = 0; 
        int zeroCount = 0;

        while (right < nums.length) {
            // If the current element is 0, increment the zeroCount
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If the number of 0's in the window exceeds k, move the left pointer
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);

            right++;
        }

        return maxLen;
    }
}