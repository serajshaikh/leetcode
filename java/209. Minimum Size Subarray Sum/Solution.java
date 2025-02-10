class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       
        int left = 0;
        int right = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        // {2, 3, 1, 2, 4, 3};
        while (left<nums.length) {
            sum += nums[left];
            System.out.println("left: " + left + " right: " + right + " sum: " + sum);
            while(sum>=target && left>=right){
                min=Math.min(min, left-right+1);
                System.out.println("========>"+"left: " + left + " right: " + right + " sum: " + sum+" min: "+min);
                sum -=nums[right++];
            }
            left++;
  
        }
        return min==Integer.MAX_VALUE?0:min;
    }
}