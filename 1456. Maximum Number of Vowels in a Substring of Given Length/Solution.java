class Solution {
    public int maxVowels(String s, int k) {
        
        int n=s.length();
        int max=0;
        int count=0;
        for(int i=0;i<k;i++){
            if(isVowel(s.charAt(i))){
                count++;
            }
        }
        max=count;

        for(int i=k;i<n;i++){
            if(isVowel(s.charAt(i-k))){
                count--;
            }
            if(isVowel(s.charAt(i))){
                count++;
            }
            max=Math.max(max,count);
        }
        return max;
    }
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

// typescript Solution.ts
/* 
function isVowel(c: string): boolean {
    return c === 'a' || c === 'e' || c === 'i' || c === 'o' || c === 'u';
}

function maxVowels(s: string, k: number): number {
    let n = s.length;
    let max = 0;
    let count = 0;

    // Calculate the number of vowels in the first window of size k
    for (let i = 0; i < k; i++) {
        if (isVowel(s.charAt(i))) {
            count++;
        }
    }

    max = count;

    // Slide the window from start to end
    for (let i = k; i < n; i++) {
        if (isVowel(s.charAt(i))) {
            count++;
        }
        if (isVowel(s.charAt(i - k))) {
            count--;
        }
        max = Math.max(max, count);
    }

    return max;
}
 */