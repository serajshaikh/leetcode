// <================ 1004. Max Consecutive Ones III ================>
function longestOnes(nums: number[], k: number): number {
    let n=nums.length;
    let left=0, right=0;
    let maxLen=0;
    let zerosCount=0;
    while(right<n){
        if(nums[right]==0){
            zerosCount++;
        }

        while(zerosCount>k){
            if(nums[left]==0)
                zerosCount--;

            left++;
        }
        maxLen=Math.max(maxLen, right-left+1);
        right++;
    }
    return maxLen;

};
const ARR = [1,1,1,0,0,0,1,1,1,1,0];
const D=2;
const r=longestOnes(ARR, D);
console.log(r);