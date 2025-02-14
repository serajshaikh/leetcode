





// <================ 394. Decode String ================>
function decodeString(s: string): string {
    const stack: string[] = [];

    for (let i = 0; i < s.length; i++) {
        const char = s.charAt(i);

        if (char !== ']') {
            stack.push(char);
        } else {
            let str = '';
            while (stack.length > 0 && stack[stack.length - 1] !== '[') {
                str = stack.pop() + str;
            }
            stack.pop();

            let num = '';
            while (stack.length > 0 && !isNaN(Number(stack[stack.length - 1]))) {
                num = stack.pop() + num;
            }

            const k = parseInt(num, 10);
            const repeatedStr = str.repeat(k);
            stack.push(repeatedStr);
        }
    }

    return stack.join('');
}

let s = "3[a2[cd]]"
console.log("Result------->", decodeString(s));

// <================ 2342. Max Sum of a Pair With Equal Sum of Digits ================>
/* function getDigitSum(num: number): number {
    let sum = 0;
    while (num > 0) {
        sum += num % 10; 
        num = Math.floor(num / 10);
    }
    return sum;
}

function maximumSum(nums: number[]): number {
    const freqMap = new Map<number, number[]>();
    for (let num of nums) {
        const digitSum = getDigitSum(num);
        if (!freqMap.has(digitSum)) {
            freqMap.set(digitSum, [-1, -1]);
        }
        const currentNums = freqMap.get(digitSum)!;

        if (num > currentNums[0]) {
            currentNums[1] = currentNums[0];
            currentNums[0] = num;
        } else if (num > currentNums[1]) {
            currentNums[1] = num;
        }
    }

    let maxSum = -1;

    for (const [key, values] of freqMap) {
        if (values[0] !== -1 && values[1] !== -1) {
            const currentSum = values[0] + values[1];
            maxSum = Math.max(maxSum, currentSum);
        }
    }

    return maxSum;
} */


    function getDigitSum(num: number): number {
        let sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = Math.floor(num / 10);
        }
        return sum;
    }
    
    function maximumSum(nums: number[]): number {
        if (nums.length < 2) return -1;
    
        const freqMap = new Map<number, [number, number]>();
    
        for (let num of nums) {
            const digitSum = getDigitSum(num);
            if (!freqMap.has(digitSum)) {
                freqMap.set(digitSum, [num, -1]);
            } else {
                const [top1, top2] = freqMap.get(digitSum)!;
                if (num > top1) {
                    freqMap.set(digitSum, [num, top1]);
                } else if (num > top2) {
                    freqMap.set(digitSum, [top1, num]);
                }
            }
        }
    
        let maxSum = -1; 
    
        for (const [_, [top1, top2]] of freqMap) {
            if (top1 !== -1 && top2 !== -1) {
                const currentSum = top1 + top2;
                maxSum = Math.max(maxSum, currentSum);
            }
        }
    
        return maxSum;
    }

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

// <================ 2390. Removing Stars From a String ================>
function removeStars(s: string): string {
    let result: string[] = [];
    let i = 0;

    while (i < s.length) {
        if (s.charAt(i) === "*") {
            if (result.length > 0) {
                result.pop();
            }
        } else {
            result.push(s.charAt(i));
        }
        i++;
    }

    return result.join("");
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