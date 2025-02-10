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

// <================ 2352. Equal Row and Column Pairs ================>
function equalPairs(grid: number[][]): number {
    const n = grid.length;
    const freqMapper = new Map<string, number>();

    for (const row of grid) {
        const key = JSON.stringify(row);
        freqMapper.set(key, (freqMapper.get(key) || 0) + 1);
    }

    let count = 0;

    for (let j = 0; j < n; j++) {
        const column: number[] = [];
        for (let i = 0; i < n; i++) {
            column.push(grid[i][j]);
        }
        const key = JSON.stringify(column);
        if (freqMapper.has(key)) {
            count += freqMapper.get(key)!;
        }
    }

    return count;
}
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>
// <================  ================>