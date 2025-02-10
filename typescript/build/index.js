"use strict";
function longestOnes(nums, k) {
    var n = nums.length;
    var left = 0, right = 0;
    var maxLen = 0;
    var zerosCount = 0;
    while (right < n) {
        if (nums[right] == 0) {
            zerosCount++;
        }
        while (zerosCount > k) {
            if (nums[right] == 0)
                zerosCount--;
            left++;
        }
        maxLen = Math.max(maxLen, right - left + 1);
        right++;
    }
    return maxLen;
}
;
var nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0];
var k = 2;
var res = longestOnes(nums, k);
console.log(res);
